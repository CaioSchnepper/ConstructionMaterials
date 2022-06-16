package utfpr.constructionmaterials.shared.constants;

import javafx.scene.image.Image;
import utfpr.constructionmaterials.MainApplication;

import java.util.Objects;

public class ServerImages {

    public static final Image ON = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("on.gif")));

    public static final Image OFF = new Image(Objects.requireNonNull(MainApplication.class.getClassLoader().getResourceAsStream("off.gif")));

}
