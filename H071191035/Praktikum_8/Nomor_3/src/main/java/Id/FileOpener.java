package Id;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileOpener implements EventHandler<ActionEvent> {
  private Stage window;
  private Button selectButton;
  private TextArea textArea;
  private FileChooser fileChooser;
  private File file;
  private Alert alert;

  // CONSTRUCTOR
  FileOpener(Stage window, Button selectButton, TextArea textArea) {
    this.window = window;
    this.selectButton = selectButton;
    this.textArea = textArea;
  }

  @Override
  public void handle(ActionEvent e) {
    this.selectButton.setDisable(true);
    this.textArea.setText("");

    fileChooser = new FileChooser();
    fileChooser.setTitle("Select Text File");
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt Files", "*.txt"), new FileChooser.ExtensionFilter("All Files", "*."));
  
    file = fileChooser.showOpenDialog(this.window);
    if (file == null) {
      this.selectButton.setDisable(false);
      return;
    }

    try {
      this.textArea.setText(SimpleFileReader.readFile(file));
    } catch (IOException ioe) {
      alert  = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Can't read the chosen file");
      alert.setContentText(ioe.getMessage());
    }
    this.selectButton.setDisable(false);
  }
}