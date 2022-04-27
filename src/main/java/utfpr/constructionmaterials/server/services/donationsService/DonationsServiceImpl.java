package utfpr.constructionmaterials.server.services.donationsService;

import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.donations.DonationCreateDTO;
import utfpr.constructionmaterials.events.donations.DonationDeleteDTO;
import utfpr.constructionmaterials.events.donations.DonationUpdateDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationCreateReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationDeleteReplyDTO;
import utfpr.constructionmaterials.replyEvents.donations.DonationUpdateReplyDTO;

@Component
public class DonationsServiceImpl implements DonationsService {

    @Override
    public DonationCreateReplyDTO create(DonationCreateDTO donationCreateDTO) {
        return null;
    }

    @Override
    public DonationUpdateReplyDTO update(DonationUpdateDTO donationUpdateDTO) {
        return null;
    }

    @Override
    public DonationDeleteReplyDTO delete(DonationDeleteDTO donationDeleteDTO) {
        return null;
    }

}
