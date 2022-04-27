package utfpr.constructionmaterials.server.services.usersService;

import org.springframework.stereotype.Component;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserRegisterReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserUpdateReplyDTO;

@Component
public class UsersServiceImpl implements UsersService {

    @Override
    public UserLoginReplyDTO login(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public UserRegisterReplyDTO register(UserRegisterDTO userRegisterDTO) {
        return null;
    }

    @Override
    public UserUpdateReplyDTO update(UserUpdateDTO userUpdateDTO) {
        return null;
    }

}
