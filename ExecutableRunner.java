import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class ExecutableRunner extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button startButton = new Button("START");
        startButton.setStyle("-fx-font-weight: bold; -fx-font-size: 18;"); // Set button text to bold and increase font size
        StackPane root = new StackPane();

        // Set background image to cover the entire screen
        Image backgroundImage = new Image("RESIDENT.jpeg"); // Replace with your actual image file path
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(600);
        backgroundImageView.setFitHeight(400);
        root.getChildren().add(backgroundImageView);

        // Add the start button on top of the background
        root.getChildren().add(startButton);

        Scene scene = new Scene(root, 600, 400);

        startButton.setOnAction(e -> {
            try {
                runExecutable();
                startButton.setStyle("-fx-background-color: green; -fx-font-weight: bold; -fx-font-size: 18;");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.setTitle("SURVIVAL GAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runExecutable() throws IOException {
        // Replace "path/to/your/executable.exe" with the actual path to your executable file
        String executablePath = "zombie survival game.exe";
        ProcessBuilder processBuilder = new ProcessBuilder(executablePath);
        processBuilder.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
