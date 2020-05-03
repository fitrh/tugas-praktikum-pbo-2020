package id.co.npad93.p8t2;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] a)
    {
		Application.launch(Main.class, a);
	}
	
	@Override
	public void start(Stage stage)
	{
		Insets margin = new Insets(8, 8, 8, 8);

		// Kelompok
		BorderPane groups = new BorderPane();

		// Title
		Label groupTitle = new Label("Kelompok");

		// Daftar kelompok
		final int GROUPS_COUNT = 8;
		GridPane groupsRadioElement = new GridPane();
		ToggleGroup groupsListGroup = new ToggleGroup();
		RadioButton[] groupsRadioButton = new RadioButton[GROUPS_COUNT];
		for (int i = 0; i < GROUPS_COUNT; i++)
		{
			RadioButton radioButton = new RadioButton("Kelompok _" + (i + 1));
			radioButton.setMnemonicParsing(true);
			radioButton.setSelected(false);
			radioButton.setToggleGroup(groupsListGroup);
			GridPane.setMargin(radioButton, margin);

			groupsRadioButton[i] = radioButton;
			groupsRadioElement.add(radioButton, i % 2, i / 2);
		}

		// Merge all the group BorderPane
		BorderPane.setAlignment(groupTitle, Pos.TOP_CENTER);
		BorderPane.setMargin(groupTitle, margin);
		groups.setTop(groupTitle);
		BorderPane.setAlignment(groupsRadioElement, Pos.CENTER);
		BorderPane.setMargin(groupsRadioElement, margin);
		groups.setCenter(groupsRadioElement);

		// Data
		BorderPane dataPane = new BorderPane();

		// Title
		Label dataTitle = new Label("Data");

		// Tempat data
		GridPane dataContent = new GridPane();

		// NIM
		TextField nimInput = new TextField();
		Label nimLabel = new Label("N_IM");
		nimInput.setPromptText("ex. H071001000");
		nimLabel.setLabelFor(nimInput);
		nimLabel.setMnemonicParsing(true);

		// Name
		TextField nameInput = new TextField();
		Label nameLabel = new Label("_Nama");
		nameInput.setPromptText("ex. Airani Iofifteen");
		nameLabel.setLabelFor(nameInput);
		nameLabel.setMnemonicParsing(true);

		// Gender radio button
		ToggleGroup genderGroup = new ToggleGroup();
		RadioButton[] genderButton = {
			new RadioButton("_Laki-laki"),
			new RadioButton("_Perempuan")
		};
		genderButton[0].setMnemonicParsing(true);
		genderButton[0].setToggleGroup(genderGroup);
		genderButton[1].setMnemonicParsing(true);
		genderButton[1].setToggleGroup(genderGroup);

		// Gender label
		Label genderLabel = new Label("Jenis Kelamin");

		// Merge all the data GridPane
		GridPane.setMargin(nimLabel, margin);
		dataContent.add(nimLabel, 0, 0);
		GridPane.setMargin(nimInput, margin);
		dataContent.add(nimInput, 1, 0);
		GridPane.setMargin(nameLabel, margin);
		dataContent.add(nameLabel, 0, 1);
		GridPane.setMargin(nameInput, margin);
		dataContent.add(nameInput, 1, 1);
		GridPane.setMargin(genderLabel, margin);
		dataContent.add(genderLabel, 0, 2);
		GridPane.setMargin(genderButton[0], margin);
		dataContent.add(genderButton[0], 1, 2);
		GridPane.setMargin(genderButton[1], margin);
		dataContent.add(genderButton[1], 1, 3);

		// Merge the data BorderPane
		BorderPane.setAlignment(dataTitle, Pos.TOP_CENTER);
		BorderPane.setMargin(dataTitle, margin);
		dataPane.setTop(dataTitle);
		BorderPane.setAlignment(dataContent, Pos.CENTER);
		BorderPane.setMargin(dataContent, margin);
		dataPane.setCenter(dataContent);

		// Save button
		Button saveButton = new Button("Save");
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ev)
			{
				// Check group selection
				Toggle targetGroup = groupsListGroup.getSelectedToggle();
				if (targetGroup == null)
				{
					// Warning
					showWarning("Kesalahan", "Tidak ada kelompok yang dipilih", null);
					return;
				}

				int groupIndex = -1;
				for (int i = 0; i < groupsRadioButton.length; i++)
				{
					if (groupsRadioButton[i] == targetGroup)
					{
						groupIndex = i;
						break;
					}
				}

				if (groupIndex == -1)
				{
					// Should never happen
					showWarning("Kesalahan", "Kesalahan internal", "groupIndex == -1");
					return;
				}

				// Check NIM input
				String id = nimInput.getText();
				if (id == null || id.length() == 0)
				{
					// Warning
					showWarning("Kesalahan", "NIM kosong", null);
					return;
				}

				// Check name input
				String name = nameInput.getText();
				if (name == null || name.length() == 0)
				{
					// Warning
					showWarning("Kesalahan", "Nama kosong", null);
					return;
				}

				// Check gender
				Toggle genderToggle = genderGroup.getSelectedToggle();
				String gender = null;
				if (genderToggle == null)
				{
					// Warning
					showWarning("Kesalahan", "Tidak ada jenis kelamin yang dipilih", null);
					return;
				}
				else if (genderToggle == genderButton[0])
					gender = "Laki-laki";
				else if (genderToggle == genderButton[1])
					gender = "Perempuan";
				else
				{
					// Should never happen
					showWarning("Kesalahan", "Kesalahan internal", "gender == null");
					return;
				}

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				StringBuilder builder = new StringBuilder();
				builder.append("Nama: ");
				builder.append(name);
				builder.append("\n");
				builder.append("NIM: ");
				builder.append(id);
				builder.append("\n");
				builder.append("Jenis Kelamin: ");
				builder.append(gender);
				builder.append("\n");
				builder.append("Kelompok: ");
				builder.append(groupIndex + 1);
				builder.append("\n");
				alert.setTitle("Informasi");
				alert.setHeaderText("Informasi Data");
				alert.setContentText(builder.toString());
				alert.showAndWait();
			}
		});

		// Put all of it to root pane
		BorderPane rootPane = new BorderPane();
		rootPane.setLeft(groups);
		rootPane.setRight(dataPane);
		BorderPane.setAlignment(saveButton, Pos.TOP_RIGHT);
		BorderPane.setMargin(saveButton, margin);
		rootPane.setBottom(saveButton);

		Scene scene = new Scene(rootPane, 500, 240);
		stage.setTitle("Data Kelompok");
		stage.setScene(scene);
		stage.show();
	}

	public static void showWarning(String title, String header, String content)
	{
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(header);

		if (content != null)
			alert.setContentText(content);
		
		alert.showAndWait();
	}
}
