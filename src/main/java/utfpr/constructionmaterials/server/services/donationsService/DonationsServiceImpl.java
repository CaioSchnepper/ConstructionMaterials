package utfpr.constructionmaterials.server.services.donationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.entities.donations.Donation;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDeleteDTO;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationDeleteReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationUpdateReplyDTO;
import utfpr.constructionmaterials.replyEvents.errors.DonationErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.ErrorDTO;
import utfpr.constructionmaterials.server.repositories.donations.DonationsRepository;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import java.util.Optional;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.*;

@Service
public class DonationsServiceImpl implements DonationsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private DonationsRepository donationsRepository;

    @Override
    public EventDTO create(DonationCreateDTO donationCreateDTO) {
        Donation donation = ObjectMapperHelper.map(donationCreateDTO.getDonation(), Donation.class);

        Optional<User> user = usersRepository.findById(donation.getIdDonor());
        if (user.isEmpty()) {
            ErrorDTO error = new ErrorDTO(USER_NOT_FOUND);
            return new DonationErrorDTO(error);
        }

        donationsRepository.save(donation);

        return new DonationCreateReplyDTO();
    }

    @Override
    public EventDTO update(DonationUpdateDTO donationUpdateDTO) {

        Optional<User> user = usersRepository.findById(donationUpdateDTO.getDonationUpdate().getIdDonor());
        if (user.isEmpty()) {
            ErrorDTO error = new ErrorDTO(USER_NOT_FOUND);
            return new DonationErrorDTO(error);
        }

        Optional<Donation> donation = donationsRepository.findById(donationUpdateDTO.getDonationUpdate().getId());
        if (donation.isEmpty()) {
            ErrorDTO error = new ErrorDTO(DONATION_NOT_FOUND);
            return new DonationErrorDTO(error);
        }

        Donation donationToUpdate = donation.get();
        donationToUpdate.updateFromDTO(donationUpdateDTO);

        donationsRepository.save(donationToUpdate);

        return new DonationUpdateReplyDTO();
    }

    @Override
    public EventDTO delete(DonationDeleteDTO donationDeleteDTO) {

        if (donationsRepository.existsById(donationDeleteDTO.getDonationDelete().getId())) {
            donationsRepository.deleteById(donationDeleteDTO.getDonationDelete().getId());
            return new DonationDeleteReplyDTO();
        } else {
            ErrorDTO error = new ErrorDTO(DONATION_NOT_FOUND);
            return new DonationErrorDTO(error);
        }

    }

}
