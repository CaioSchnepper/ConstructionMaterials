package utfpr.constructionmaterials.server.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.connection.CloseConnectionDTO;
import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDeleteDTO;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionCreateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.server.services.connectionService.ConnectionService;
import utfpr.constructionmaterials.server.services.donationsService.DonationsService;
import utfpr.constructionmaterials.server.services.receptionsService.ReceptionsService;
import utfpr.constructionmaterials.server.services.transactionsService.TransactionsService;
import utfpr.constructionmaterials.server.services.usersService.UsersService;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.EVENT_NAME_INVALID;
import static utfpr.constructionmaterials.shared.constants.EventNames.*;
import static utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper.mapFromJson;

@Component
public class EventProcessorManager {

    private final UsersService usersService;

    private final DonationsService donationsService;

    private final ReceptionsService receptionsService;

    private final TransactionsService transactionsService;

    private final ConnectionService connectionService;

    @Autowired
    public EventProcessorManager(
            UsersService usersService,
            DonationsService donationsService,
            ReceptionsService receptionsService,
            TransactionsService transactionsService,
            ConnectionService connectionService
    ) {
        this.usersService = usersService;
        this.donationsService = donationsService;
        this.receptionsService = receptionsService;
        this.transactionsService = transactionsService;
        this.connectionService = connectionService;
    }

    public EventDTO processEvent(String eventName, byte[] message) {
        switch (eventName) {
            case LOGIN:
                return usersService.login(mapFromJson(message, UserLoginDTO.class));
            case REGISTER:
                return usersService.register(mapFromJson(message, UserRegisterDTO.class));
            case DONATION:
                return donationsService.create(mapFromJson(message, DonationCreateDTO.class));
            case RECEIVE:
                return receptionsService.create(mapFromJson(message, ReceptionCreateDTO.class));
            case CLIENT_TRANSACTIONS:
                return transactionsService.list(mapFromJson(message, ClientTransactionListDTO.class));
            case RECEPTIONS:
                return receptionsService.list(mapFromJson(message, ReceptionListDTO.class));
            case DONATION_UPDATE:
                return donationsService.update(mapFromJson(message, DonationUpdateDTO.class));
            case DONATION_DELETE:
                return donationsService.delete(mapFromJson(message, DonationDeleteDTO.class));
            case USER_UPDATE:
                return usersService.update(mapFromJson(message, UserUpdateDTO.class));
            case CLOSE:
                return connectionService.close(mapFromJson(message, CloseConnectionDTO.class));
            default:
                throw new IllegalArgumentException(EVENT_NAME_INVALID);
        }
    }

}
