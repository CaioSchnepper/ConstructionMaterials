package utfpr.constructionmaterials.client.managers;

import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.replyEvents.connection.CloseConnectionReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationDeleteReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationUpdateReplyDTO;
import utfpr.constructionmaterials.replyEvents.errors.*;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionReplyDTO;
import utfpr.constructionmaterials.replyEvents.transactions.ClientTransactionsReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserRegisterReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserUpdateReplyDTO;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.EVENT_NAME_INVALID;
import static utfpr.constructionmaterials.shared.constants.EventNames.*;
import static utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper.mapFromJson;

@Component
public class EventReplyProcessorManager {

    public static EventDTO processEventReply(String eventName, byte[] message) {
        var isErrorEvent = ObjectMapperHelper.isErrorMessage(message);

        switch (eventName) {
            case LOGIN:
                return isErrorEvent
                        ? mapFromJson(message, LoginErrorDTO.class)
                        : mapFromJson(message, UserLoginReplyDTO.class);

            case REGISTER:
                return isErrorEvent
                        ? mapFromJson(message, RegisterErrorDTO.class)
                        : mapFromJson(message, UserRegisterReplyDTO.class);
            case DONATION:
                return isErrorEvent
                        ? mapFromJson(message, DonationErrorDTO.class)
                        : mapFromJson(message, DonationCreateReplyDTO.class);
            case RECEIVE:
                return isErrorEvent
                        ? mapFromJson(message, ReceptionsErrorDTO.class)
                        : mapFromJson(message, ReceptionCreateReplyDTO.class);
            case CLIENT_TRANSACTIONS:
                return isErrorEvent
                        ? mapFromJson(message, TransactionsErrorDTO.class)
                        : mapFromJson(message, ClientTransactionsReplyDTO.class);
            case RECEPTIONS:
                return isErrorEvent
                        ? mapFromJson(message, ReceptionsErrorDTO.class)
                        : mapFromJson(message, ReceptionReplyDTO.class);
            case DONATION_UPDATE:
                return isErrorEvent
                        ? mapFromJson(message, DonationUpdateErrorDTO.class)
                        : mapFromJson(message, DonationUpdateReplyDTO.class);
            case DONATION_DELETE:
                return isErrorEvent
                        ? mapFromJson(message, DonationDeleteErrorDTO.class)
                        : mapFromJson(message, DonationDeleteReplyDTO.class);
            case USER_UPDATE:
                return isErrorEvent
                        ? mapFromJson(message, UserUpdateErrorDTO.class)
                        : mapFromJson(message, UserUpdateReplyDTO.class);
            case CLOSE:
                return isErrorEvent
                        ? mapFromJson(message, CloseConnectionErrorDTO.class)
                        : mapFromJson(message, CloseConnectionReplyDTO.class);
            default:
                throw new IllegalArgumentException(EVENT_NAME_INVALID);
        }
    }

}
