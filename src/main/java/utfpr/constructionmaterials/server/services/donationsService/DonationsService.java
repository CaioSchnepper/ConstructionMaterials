package utfpr.constructionmaterials.server.services.donationsService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDeleteDTO;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;

public interface DonationsService {

    EventDTO create(DonationCreateDTO donationCreateDTO);

    EventDTO update(DonationUpdateDTO donationUpdateDTO);

    EventDTO delete(DonationDeleteDTO donationDeleteDTO);

}
