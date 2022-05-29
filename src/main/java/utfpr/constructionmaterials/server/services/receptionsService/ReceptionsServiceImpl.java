package utfpr.constructionmaterials.server.services.receptionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.entities.donations.Donation;
import utfpr.constructionmaterials.entities.receptions.Reception;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationFullDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionCreateDTO;
import utfpr.constructionmaterials.events.receptions.ReceptionListDTO;
import utfpr.constructionmaterials.replyEvents.errors.ErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.ReceiveErrorDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.receptions.ReceptionReplyDTO;
import utfpr.constructionmaterials.server.repositories.donations.DonationsRepository;
import utfpr.constructionmaterials.server.repositories.receptions.ReceptionsRepository;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.DONATION_NOT_FOUND;
import static utfpr.constructionmaterials.shared.constants.ErrorMessages.USER_NOT_FOUND;

@Service
public class ReceptionsServiceImpl implements ReceptionsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private DonationsRepository donationsRepository;

    @Autowired
    private ReceptionsRepository receptionsRepository;

    @Override
    public EventDTO create(ReceptionCreateDTO receptionCreateDTO) {

        Reception reception = ObjectMapperHelper.map(receptionCreateDTO.getReceive(), Reception.class);

        Optional<User> receiver = usersRepository.findById(reception.getIdReceiver());
        if (!receiver.isPresent()) {
            ErrorDTO error = new ErrorDTO(USER_NOT_FOUND);
            return new ReceiveErrorDTO(error);
        }

        Optional<Donation> donation = donationsRepository.findById(reception.getIdDonation());
        if (!donation.isPresent()) {
            ErrorDTO error = new ErrorDTO(DONATION_NOT_FOUND);
            return new ReceiveErrorDTO(error);
        }

        receptionsRepository.save(reception);

        return new ReceptionCreateReplyDTO();
    }

    @Override
    public EventDTO list(ReceptionListDTO receptionListDTO) {
        List<Donation> donations = donationsRepository.findAll();

        List<DonationFullDTO> donationsDTOs = new ArrayList<>();
        donations.forEach(donation -> donationsDTOs.add(ObjectMapperHelper.map(donation, DonationFullDTO.class)));

        return new ReceptionReplyDTO(donationsDTOs).toReceptionListReplyDTO();
    }

}
