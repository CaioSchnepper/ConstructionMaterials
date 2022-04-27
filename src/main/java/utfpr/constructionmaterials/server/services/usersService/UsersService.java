package utfpr.constructionmaterials.server.services.usersService;

import utfpr.constructionmaterials.events.users.UserLoginDTO;
import utfpr.constructionmaterials.events.users.UserRegisterDTO;
import utfpr.constructionmaterials.events.users.UserUpdateDTO;
import utfpr.constructionmaterials.replyEvents.users.UserLoginReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserRegisterReplyDTO;
import utfpr.constructionmaterials.replyEvents.users.UserUpdateReplyDTO;

public interface UsersService {

     UserLoginReplyDTO login(UserLoginDTO userLoginDTO);

     UserRegisterReplyDTO register(UserRegisterDTO userRegisterDTO);

     UserUpdateReplyDTO update(UserUpdateDTO userUpdateDTO);

}
