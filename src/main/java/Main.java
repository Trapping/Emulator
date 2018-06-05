import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent panel = null;

        try {
            panel = FXMLLoader.load(getClass().getResource("Form.fxml"));
        } catch (Exception e){
            System.out.println("Error in loading FXML form.");
            e.printStackTrace();
        }

        Scene scene = new Scene(panel);

        primaryStage.setTitle("Intel 8080A Emulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
