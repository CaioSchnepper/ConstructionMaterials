package utfpr.constructionmaterials.server.services.donationsService;

import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDeleteDTO;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationDeleteReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationUpdateReplyDTO;

public interface DonationsService {

    DonationCreateReplyDTO create(DonationCreateDTO donationCreateDTO);

    DonationUpdateReplyDTO update(DonationUpdateDTO donationUpdateDTO);

    DonationDeleteReplyDTO delete(DonationDeleteDTO donationDeleteDTO);

}
