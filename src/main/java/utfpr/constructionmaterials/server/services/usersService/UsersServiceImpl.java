package utfpr.constructionmaterials.server.services.usersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserRegisterReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserUpdateReplyDTO;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;
import utfpr.constructionmaterials.shared.helpers.JsonHelper;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserLoginReplyDTO login(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public UserRegisterReplyDTO register(UserRegisterDTO userRegisterDTO) {
        User user = JsonHelper.map(userRegisterDTO.getRegister(), User.class);
        usersRepository.save(user);
        return new UserRegisterReplyDTO();
    }

    @Override
    public UserUpdateReplyDTO update(UserUpdateDTO userUpdateDTO) {
        return null;
    }

}
