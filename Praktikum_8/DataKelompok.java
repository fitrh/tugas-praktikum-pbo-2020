package id.fi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DataKelompok extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Text textKelompok = new Text();
        textKelompok.setText("Kelompok");
        
        CheckBox kelompok[] = { 
        new CheckBox("Kelompok 1"),
        new CheckBox("Kelompok 2"), 
        new CheckBox("Kelompok 3"),
        new CheckBox("Kelompok 4")}; 

        CheckBox gender[] = {
        new CheckBox("Laki-laki"),
        new CheckBox("Perempuan")};

        Label nim = new Label("NIM");
        TextField inputNim = new TextField();
        Label nama = new Label("Nama");
        TextField inputName = new TextField();
        Label jenisKelamin = new Label("Jenis Kelamin");
        

        Button save = new Button("Save");
        
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(100, 150, 10, 150));
        grid.add(kelompok[0], 0, 0);
        grid.add(kelompok[1], 0, 1);
        grid.add(kelompok[2], 1, 0);
        grid.add(kelompok[3], 1, 1);

        grid.add(nim, 2, 0);
        grid.add(nama, 2, 1);
        grid.add(jenisKelamin, 2, 2);
        grid.add(inputNim, 3, 0);
        grid.add(inputName, 3, 1);

        grid.add(gender[0], 3, 2);
        grid.add(gender[1], 3, 3);
        grid.add(save, 3, 4);
        
        grid.setVgap(20);
        grid.setHgap(50);
        
        save.setOnAction(e -> {
            for (int i = 0; i < kelompok.length; i++) {
                if(kelompok[i].isSelected()){
                    for (int j = 0; j < gender.length; j++) {
                        if (gender[j].isSelected()) {
                            Label showData[] = { new Label(String.format("Nama%16s : %s"," ",inputName.getText())),
                            new Label(String.format("Nim%20s: %s"," ",inputNim.getText())),
                            new Label(String.format("Jenis Kelamin%5s: %s"," ",gender[j].getText())),
                            new Label(String.format("Kelompok%10s: %s"," ",kelompok[i].getText()))};
                            GridPane gridK1 = new GridPane();
                            gridK1.setPadding(new Insets(200));
                            gridK1.add(showData[0], 0, 0);
                            gridK1.add(showData[1], 0, 1);
                            gridK1.add(showData[2], 0, 2);
                            gridK1.add(showData[3], 0, 3);
                            gridK1.setVgap(20);
                            Pane paneK1 = new Pane();
                            paneK1.getChildren().add(gridK1);
                            Scene scene2 = new Scene(paneK1, 500, 500);
                            primaryStage.setScene(scene2);
                            primaryStage.show();
                        }
                    }
                }
            }
        });
        
        Pane pane = new Pane();
        pane.getChildren().add(grid);
        Scene scene = new Scene(pane,850,350);
        primaryStage.setTitle("Data Kelompok");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}