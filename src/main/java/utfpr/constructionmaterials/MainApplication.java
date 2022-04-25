package utfpr.constructionmaterials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.constructionmaterials.client.ClientApplication;
import utfpr.constructionmaterials.server.ServerApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
//		SpringApplication.run(MainApplication.class, args);
		SpringApplication.run(ServerApplication.class, args);
		SpringApplication.run(ClientApplication.class, args);
	}

}
