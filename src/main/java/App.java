import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/fxml/MainContainer.fxml"));

        StackPane stackPane = loader.load();

        Scene scene = new Scene(stackPane, 1024, 768);

        primaryStage.setScene(scene);

        primaryStage.setTitle("System do obslugi floty");

        primaryStage.setResizable(true);

        primaryStage.show();

    }
}
