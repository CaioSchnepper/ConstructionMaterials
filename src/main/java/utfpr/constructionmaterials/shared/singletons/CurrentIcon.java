package utfpr.constructionmaterials.shared.singletons;

import javafx.scene.image.Image;
import utfpr.constructionmaterials.MainApplication;

import java.util.Objects;

public class CurrentIcon {
    private static CurrentIcon INSTANCE;
    private final Image icon;

    private CurrentIcon() {
        this.icon = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("icon.png")));
    }

    public Image getIcon() {
        return icon;
    }

    public static synchronized CurrentIcon getInstance() {
        return INSTANCE;
    }

    public static synchronized void createInstance() {
        if (INSTANCE == null) INSTANCE = new CurrentIcon();
    }

    public static synchronized void destroyInstance() {
        INSTANCE = null;
    }

}
