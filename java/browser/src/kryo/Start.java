package kryo;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kryo.utility.ViewManager;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        ViewManager.init(primaryStage);
        VBox home = ViewManager.getLoader().load(getClass().getResourceAsStream("/kryo/view/home.fxml"));
        ViewManager.createScene(home);
    }
}
