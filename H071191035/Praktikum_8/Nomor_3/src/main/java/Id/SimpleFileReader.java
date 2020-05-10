package Id;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class SimpleFileReader extends Application {
	private Stage window; 
	private Button selectButton;
	private TextArea textArea;
	private VBox root;
	private Scene mainScene;
	private Alert confirmAlert;
	private Optional<ButtonType> answer;

		// MAIN METHOD
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stage) {
			window = stage;

			mainScene = new Scene(this.getMainLayout(), 640, 480);
			
			window.setScene(mainScene);
			window.setTitle("Simple File Reader");
			window.show();

			// CLOSING PROGRAM
			window.setOnCloseRequest(e -> {
				confirmAlert = new Alert(AlertType.CONFIRMATION);
				confirmAlert.setTitle("EXIT CONFIRMATION");
				confirmAlert.setContentText("Are you sure want to exit?");
				
				answer  = confirmAlert.showAndWait();
				e.consume();
				
				if (answer.isPresent() && answer.get() != ButtonType.OK) {
						return;
				} else {    
						window.close();
				}
		});

		}

		public VBox getMainLayout() {
			root = new VBox();
			root.setAlignment(Pos.TOP_CENTER);

			// TEXTAREA
			textArea = new TextArea();
			textArea.setPrefHeight(900);
			textArea.setEditable(false);

			// BUTTON
			selectButton = new Button("Select TXT File to Read");
			selectButton.setOnAction(new FileOpener(window, selectButton, textArea));

			// LAYOUT
			VBox.setMargin(selectButton, new Insets(24, 16, 16, 16));
			VBox.setMargin(textArea, new Insets(20, 20, 20, 20));
			root.setAlignment(Pos.TOP_CENTER);
			root.getChildren().addAll(selectButton, textArea);

			return root;
		}
		
		// RETURN TXT FILE'S CONTENT
		public static String readFile(File file) throws IOException {
			final int size = 4096;
	
			FileInputStream input = new FileInputStream(file);
			ByteArrayOutputStream tempOutput = new ByteArrayOutputStream();
	
			byte[] buffer = new byte[size];
			int read = 0;
	
			do {
				read = input.read(buffer);
				tempOutput.write(buffer, 0, read);
			} while (read == size);
	
			String output = tempOutput.toString("UTF-8");
			input.close();
			return output;
		}
}