package kryo.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
    private static Stage primaryStage;

    public static void init(Stage startStage) {
        primaryStage = startStage;
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Kryo");
    }

    public static FXMLLoader getLoader() {
        return new FXMLLoader();
    }

    public static void createScene(Parent root) {
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
}
