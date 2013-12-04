package agd.yaskoam.binomial;

import agd.yaskoam.binomial.ui.MainPanel;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Q-YAA
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new MainPanel();
        stage.setTitle("Binomial distribution demo");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
