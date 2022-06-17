package utfpr.constructionmaterials.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.handler.advice.ErrorMessageSendingRecoverer;
import org.springframework.integration.handler.advice.RequestHandlerRetryAdvice;
import org.springframework.integration.ip.tcp.TcpOutboundGateway;
import org.springframework.integration.ip.tcp.connection.*;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import static utfpr.constructionmaterials.shared.constants.ClientConfigs.CONNECTION_TIMEOUT;

@Configuration
@EnableScheduling
public class TcpClientConfig implements ApplicationEventPublisherAware {

    @Value("${tcp.target-server.host}")
    private String host;

    @Value("${tcp.target-server.port}")
    private int port;

    @Value("${tcp.client.connection.poolSize}")
    private int connectionPoolSize;

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //@Bean
    public AbstractClientConnectionFactory clientConnectionFactory() {
        TcpNioClientConnectionFactory tcpNioClientConnectionFactory = new TcpNioClientConnectionFactory(host, port);
        tcpNioClientConnectionFactory.setUsingDirectBuffers(true);
        tcpNioClientConnectionFactory.setApplicationEventPublisher(applicationEventPublisher);
        return new CachingClientConnectionFactory(tcpNioClientConnectionFactory, connectionPoolSize);
    }

    @Bean
    public ThreadAffinityClientConnectionFactory threadBoundClient() {
        return new ThreadAffinityClientConnectionFactory(clientConnectionFactory());
    }

    @Bean
    public RequestHandlerRetryAdvice tcpRetryAdvice() {
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);

        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(100);
        backOffPolicy.setMaxInterval(1000);
        backOffPolicy.setMultiplier(3);

        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);

        RequestHandlerRetryAdvice tcpRetryAdvice = new RequestHandlerRetryAdvice();
        tcpRetryAdvice.setRetryTemplate(retryTemplate);

        // This allows fail-controlling
        tcpRetryAdvice.setRecoveryCallback(new ErrorMessageSendingRecoverer(outboundChannel()));

        return tcpRetryAdvice;
    }

    @EventListener
    public void listen(TcpConnectionCloseEvent event) {
        if (event.getConnectionFactoryName().equals("clientConnectionFactory")) {
            try {
                threadBoundClient().releaseConnection();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(event);
    }

    @Bean
    public MessageChannel outboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "outboundChannel")
    public MessageHandler outboundGateway(AbstractClientConnectionFactory clientConnectionFactory) {
        TcpOutboundGateway tcpOutboundGateway = new TcpOutboundGateway();
        tcpOutboundGateway.setConnectionFactory(clientConnectionFactory);
        tcpOutboundGateway.setRemoteTimeout(CONNECTION_TIMEOUT);
        tcpOutboundGateway.setRequestTimeout(CONNECTION_TIMEOUT);
        return tcpOutboundGateway;
    }

}
