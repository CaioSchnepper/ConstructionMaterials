package utfpr.constructionmaterials.server.services.transactionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.entities.donations.Donation;
import utfpr.constructionmaterials.entities.receptions.Reception;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationFullDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionFullDTO;
import utfpr.constructionmaterials.events.transactions.ClientTransactionListDTO;
import utfpr.constructionmaterials.replyEvents.errors.ErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.TransactionsErrorDTO;
import utfpr.constructionmaterials.replyEvents.transactions.TransactionsReplyDTO;
import utfpr.constructionmaterials.server.repositories.donations.DonationsRepository;
import utfpr.constructionmaterials.server.repositories.receptions.ReceptionsRepository;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.USER_NOT_FOUND;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private DonationsRepository donationsRepository;

    @Autowired
    private ReceptionsRepository receptionsRepository;

    @Override
    public EventDTO list(ClientTransactionListDTO clientTransactionListDTO) {

        Optional<User> user = usersRepository.findById(clientTransactionListDTO.getClientTransactions().getIdClient());
        if (user.isPresent()) {
            ErrorDTO error = new ErrorDTO(USER_NOT_FOUND);
            return new TransactionsErrorDTO(error);
        }

        List<Donation> donations = donationsRepository.findAll();
        List<DonationFullDTO> donationFullDTOS = new ArrayList<>();
        donations.forEach(donation -> donationFullDTOS.add(ObjectMapperHelper.map(donation, DonationFullDTO.class)));

        List<Reception> receptions = receptionsRepository.findAll();
        List<ReceptionFullDTO> receptionFullDTOS = new ArrayList<>();
        receptions.forEach(reception -> receptionFullDTOS.add(ObjectMapperHelper.map(reception, ReceptionFullDTO.class)));

        return new TransactionsReplyDTO(donationFullDTOS, receptionFullDTOS).toClientTransactionsReplyDTO();
    }

}
