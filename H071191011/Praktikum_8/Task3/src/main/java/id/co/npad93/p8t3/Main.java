package id.co.npad93.p8t3;

import java.io.*;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Main extends Application
{
    public static void main(String[] a)
    {
		Application.launch(Main.class, a);
	}
	
	@Override
	public void start(Stage stage)
	{
		// Button
		Button selectFileButton = new Button("Pilih Berkas");
		selectFileButton.setScaleX(2);
		selectFileButton.setScaleY(2);

		// TextArea
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setPrefHeight(768);

		// Button handler
		selectFileButton.setOnAction(new FilePickerButtonEvent(selectFileButton, textArea, stage));
		
		// Root pane
		VBox rootPane = new VBox();
		VBox.setMargin(selectFileButton, new Insets(24, 16, 16, 16));
		VBox.setMargin(textArea, new Insets(8, 8, 8, 8));
		rootPane.setAlignment(Pos.TOP_CENTER);
		rootPane.getChildren().addAll(selectFileButton, textArea);

		Scene scene = new Scene(rootPane, 640, 480);
		stage.setScene(scene);
		stage.setTitle("File Reader");
		stage.show();
	}

	static String readFile(File file) throws IOException
	{
		final int BUFSIZE = 4096;

		FileInputStream input = new FileInputStream(file);
		ByteArrayOutputStream tempOut = new ByteArrayOutputStream();

		// Read file in chunks
		byte[] buf = new byte[BUFSIZE];
		int readed = 0;
		do
		{
			readed = input.read(buf);
			tempOut.write(buf, 0, readed);
		} while (readed == BUFSIZE);

		String out = tempOut.toString("UTF-8");
		input.close();
		return out;
	}
}
