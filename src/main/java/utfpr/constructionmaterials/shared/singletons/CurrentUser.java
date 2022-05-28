package utfpr.constructionmaterials.shared.singletons;

import utfpr.constructionmaterials.entities.users.User;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.NO_INSTANCE_ERROR;

public class CurrentUser {

    private static CurrentUser INSTANCE;

    private final User user;

    private CurrentUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static synchronized CurrentUser getInstance() {
        return INSTANCE;
    }

    public static synchronized void setInstance(User user) {
        if (INSTANCE == null) INSTANCE = new CurrentUser(user);
    }

    public static synchronized void destroyInstance() {
        INSTANCE = null;
    }

}
