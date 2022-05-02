package utfpr.constructionmaterials.server.services.usersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.constructionmaterials.entities.users.User;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserFullDTO;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.replyEvents.errors.ErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.LoginErrorDTO;
import utfpr.constructionmaterials.replyEvents.errors.RegisterErrorDTO;
import utfpr.constructionmaterials.replyEvents.users.UserRegisterReplyDTO;
import utfpr.constructionmaterials.server.repositories.users.UsersRepository;
import utfpr.constructionmaterials.shared.helpers.ObjectMapperHelper;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.*;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public EventDTO login(UserLoginDTO userLoginDTO) {
        User user = usersRepository.findByCpf(userLoginDTO.getLogin().getCpf());

        if (user == null) {
            ErrorDTO error = new ErrorDTO(USER_NOT_FOUND);
            return new LoginErrorDTO(error);
        }

        if (!user.getPassword().equals(userLoginDTO.getLogin().getPassword())) {
            ErrorDTO error = new ErrorDTO(USER_WRONG_PASSWORD);
            return new LoginErrorDTO(error);
        }

        return ObjectMapperHelper.map(user, UserFullDTO.class).toLoginReplyDTO();
    }

    @Override
    public EventDTO register(UserRegisterDTO userRegisterDTO) {
        User user = ObjectMapperHelper.map(userRegisterDTO.getRegister(), User.class);

        if (usersRepository.existsByCpf(user.getCpf())) {
            ErrorDTO error = new ErrorDTO(USER_CPF_DUPLICATED);
            return new RegisterErrorDTO(error);
        } else {
            usersRepository.save(user);
            return new UserRegisterReplyDTO();
        }
    }

    @Override
    public EventDTO update(UserUpdateDTO userUpdateDTO) {
        return null;
    }

}
