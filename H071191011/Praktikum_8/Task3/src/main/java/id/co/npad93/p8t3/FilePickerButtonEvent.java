package id.co.npad93.p8t3;

import java.io.*;

import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;

class FilePickerButtonEvent implements EventHandler<ActionEvent>
{
	public FilePickerButtonEvent(Button button, TextArea textArea, Stage stage)
	{
		this.button = button;
		this.stage = stage;
		this.textArea = textArea;
	}

	@Override
	public void handle(ActionEvent event)
	{
		button.setDisable(true);
		textArea.setText("");

		// Setup file picker
		FileChooser filePicker = new FileChooser();
		filePicker.setTitle("Select UTF-8 Text File");
		filePicker.getExtensionFilters().addAll(
			new FileChooser.ExtensionFilter("Text Files", "*.txt"),
			new FileChooser.ExtensionFilter("All Files", "*.*")
		);
		File file = filePicker.showOpenDialog(stage);

		// If no file selected, return
		if (file == null)
		{
			button.setDisable(false);
			return;
		}

		// Try to read and set the TextArea contents to the
		// contents of the file
		try
		{
			textArea.setText(Main.readFile(file));
		}
		catch (IOException e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Masalah");
			alert.setHeaderText("Masalah saat membaca file.");
			alert.setContentText(e.getMessage());
		}
		catch (Exception e)
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Masalah");
			alert.setHeaderText("Masalah tidak diketahui.");
			alert.setContentText(e.getMessage());
		}

		button.setDisable(false);
	}

	protected Button button;
	protected Stage stage;
	protected TextArea textArea;
}
