package kryo.control;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private TextField urlField;
    @FXML
    private WebView view;
    @FXML
    private Label status;
    private WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      /*System.setProperty("http.proxyHost", "172.16.63.3");
        System.setProperty("http.proxyPort", "3128");
        System.setProperty("https.proxyHost", "172.16.63.3");
        System.setProperty("https.proxyPort", "3128");
        engine = view.getEngine();*/
        engine.setUserAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        engine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                loadSuccess();
            } else if (newValue == Worker.State.FAILED) {
                loadFailed();
            } else {
                loadRunning();
            }
        });
    }

    @FXML
    private void go() {
        engine.load(urlField.getText());
    }

    private void loadSuccess() {
        status.setText("");
    }

    private void loadFailed() {
        status.setText("Loading failed");
    }

    private void loadRunning() {
        status.setText("Loading");
    }
}
