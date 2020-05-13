package id.co.npad93.p8t1;

import java.io.*;
import java.util.*;

import org.json.*;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application
{
	// List of restaurant menu
	static ArrayList<FoodEntry> menu = new ArrayList<FoodEntry>();

    public static void main(String[] a)
    {
		// Select file to load
		String menuJson = a.length >= 1 ? a[0] : "restaurant_menu.json";

		try
		{
			// Parse file
			JSONArray root = new JSONArray(readFile(menuJson));
			for (Object obj: root)
			{
				JSONObject entryObj = (JSONObject) obj;
				menu.add(new FoodEntry(entryObj.getString("name"), entryObj.getInt("price")));
			}
		}
		catch (JSONException e)
		{
			System.out.println("Unable to parse restaurant_menu.json, file appears invalid?");
			System.exit(1);
		}
		catch (IOException e)
		{
			System.out.println("Unable to locate restaurant_menu.json, maybe specify it as arg?");
			System.exit(1);
		}

		// Launch JavaFX app
		Application.launch(Main.class, a);
	}
	
	@Override
	public void start(Stage stage)
	{
		Insets margin = new Insets(8, 8, 8, 8);
		stage.setTitle("Menu Restoran");

		BorderPane rootPane = new BorderPane();

		// Title
		Text title = new Text("Restoran あみか");
		title.setFont(new Font(24));

		// Item selection
		VBox itemCheck = new VBox(8);
		VBox itemPrice = new VBox(8);
		CheckBox[] checkboxItems = new CheckBox[menu.size()];
		for (int i = 0; i < checkboxItems.length; i++)
		{
			FoodEntry entry = menu.get(i);
			Label price = new Label(String.format("Rp.%d", entry.getPrice()));

			CheckBox check = new CheckBox(entry.getName());
			check.setIndeterminate(false);
			check.setSelected(false);
			checkboxItems[i] = check;

			itemCheck.getChildren().add(check);
			itemPrice.getChildren().add(price);
		}

		// Button
		Button buyButton = new Button("Pesan");
		buyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ev)
			{
				long cumulativePrice = 0;
				Alert alert;

				for (int i = 0; i < checkboxItems.length; i++)
				{
					if (checkboxItems[i].isSelected())
						cumulativePrice += menu.get(i).getPrice();
				}

				if (cumulativePrice == 0)
				{
					// No items ticked
					alert = new Alert(AlertType.WARNING);
					alert.setTitle("Masalah Pemesanan");
					alert.setHeaderText("Tidak ada item yang dipilih");
					alert.setContentText("Pilih 1 atau lebih dari menu.");
				}
				else
				{
					// Ok there's items
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Konfirmasi Pembelian");
					alert.setHeaderText("Mau pesan item-item yang dipilih?");
					alert.setContentText("Harganya Rp." + cumulativePrice);
				}

				alert.showAndWait();
			}
		});

		// Set top BorderPane
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		BorderPane.setMargin(title, margin);
		rootPane.setTop(title);

		// Set left BorderPane
		BorderPane.setMargin(itemCheck, margin);
		rootPane.setLeft(itemCheck);

		// Set right BorderPane
		BorderPane.setMargin(itemPrice, margin);
		rootPane.setRight(itemPrice);

		// Set bottom BorderPane
		BorderPane.setMargin(buyButton, margin);
		BorderPane.setAlignment(buyButton, Pos.CENTER_RIGHT);
		rootPane.setBottom(buyButton);

		// Create scene
		Scene scene = new Scene(rootPane, 280, 480);
		stage.setScene(scene);
		stage.show();
	}

	static String readFile(String filename) throws IOException
	{
		final int BUFSIZE = 4096;

		FileInputStream input = new FileInputStream(filename);
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
