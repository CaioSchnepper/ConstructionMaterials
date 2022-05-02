package utfpr.constructionmaterials.server.services.usersService;

import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;

public interface UsersService {

     EventDTO login(UserLoginDTO userLoginDTO);

     EventDTO register(UserRegisterDTO userRegisterDTO);

     EventDTO update(UserUpdateDTO userUpdateDTO);

}
