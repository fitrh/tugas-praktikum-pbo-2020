package id.fi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Cart {
    private int totalPrice;
    private Stage stage;
    private Button exit;

    public Cart(Stage stage, int totalPrice) {
        this.totalPrice = totalPrice;
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setExitBtn(Button exit) {
        this.exit = exit;
    }
    public Button getExitBtn(){
        return exit;
    }
    public void addToCart(TextField[] addFood, int[] food, Button pay) {
        var objek = new Object(){
            Label totalHarga;
            Label foodName;
            Label retrun;
        };
        
        pay.setOnAction(e -> {
            for (int i = 0; i < addFood.length; i++) {
                Alert space = new Alert(AlertType.NONE);
                if (addFood[i].getText().contains(" ")) {
                    space = new Alert(AlertType.ERROR);
                    space.setContentText("Cannot have space");
                    space.show();
                }
            }

            int foodKind[] = { Integer.parseInt(0 + addFood[0].getText()), Integer.parseInt(0 + addFood[1].getText()),
                Integer.parseInt(0 + addFood[2].getText()),Integer.parseInt(0 + addFood[3].getText()),Integer.parseInt(0 + addFood[4].getText()),
                Integer.parseInt(0 + addFood[5].getText()),Integer.parseInt(0 + addFood[6].getText()),Integer.parseInt(0 + addFood[7].getText()),
                Integer.parseInt(0 + addFood[8].getText()),Integer.parseInt(0 + addFood[9].getText()),Integer.parseInt(0 + addFood[10].getText()),
                Integer.parseInt(0 + addFood[11].getText())};
            String menuName[] = {"Ayam Geprek Spesial" , "Ayam Geprek Biasa" , "Ayam Goreng", "Ayam Bakar" , "Ayam Krispi", 
                "Nasi", "Es Teh", "Jus Jeruk" ,"Jus Lemon","Jus Alfukat","Air Botol","Air gelas"};
            String out = "";
            int sumPrice = 0;
            for (int i = 0; i < addFood.length; i++) {
                if (foodKind[i] != 0) {
                    int menuPrice = foodKind[i]*food[i];
                    out += String.format("\n-%s\n  x%d\t : Rp.%d", menuName[i],foodKind[i],menuPrice);
                    sumPrice += menuPrice;
                }
            }
            objek.foodName = new Label("======== Your Orders Are : ========\n" +out+"\n============================");
            Label labelHarga = new Label("Total Harga");
            objek.totalHarga = new Label(String.format("= Rp.%d", sumPrice));
            objek.totalHarga.setId("LabelHarga");
            Label bayar = new Label("Uang Anda");
            TextField bayarField = new TextField();        
            
            //Kode Tampilan User
            AnchorPane pane = new AnchorPane();

            BorderPane bord = new BorderPane();
            
            Button confirm = new Button("confirm");
            VBox confirmBtn = new VBox();
            confirmBtn.getChildren().addAll(confirm);
            confirmBtn.setAlignment(Pos.BOTTOM_RIGHT);
            int sum = sumPrice;
            confirm.setOnAction(v -> {
            int back1 = Integer.parseInt(0 + bayarField.getText()) - sum;
            if(back1 <= 0) {
                Alert warningAlert = new Alert(AlertType.ERROR);
                warningAlert.setContentText("Silahkan Tambahkan Jumlah Pembayaran anda");
                warningAlert.setHeaderText("PEMBAYARAN ANDA KURANG");
                warningAlert.show();
            } else {
                objek.retrun = new Label(String.format("= Rp.%d", back1));
                Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
                confirmAlert.setContentText("PEMBAYARAN BERHASIL");
                confirmAlert.setHeaderText("Kembalian : " + "= Rp." + back1);
                confirmAlert.show();
            }
            
            });

            GridPane priceTotalBox = new GridPane();

            priceTotalBox.add(objek.foodName, 0, 0);
            priceTotalBox.add(labelHarga, 0, 1);
            priceTotalBox.add(objek.totalHarga, 1, 1);
            priceTotalBox.add(bayar, 0,2);
            priceTotalBox.add(bayarField,1,2);
            priceTotalBox.add(confirmBtn, 0, 3);
            priceTotalBox.setVgap(20);
            priceTotalBox.setHgap(20);

            VBox tes = new VBox();
            tes.getChildren().addAll(priceTotalBox);
            tes.setSpacing(30);
            tes.setAlignment(Pos.TOP_CENTER);
            bord.setCenter(tes);

            AnchorPane.setTopAnchor(bord, 50.0);
            AnchorPane.setBottomAnchor(bord, 50.0);
            AnchorPane.setLeftAnchor(bord, 50.0);
            AnchorPane.setRightAnchor(bord, 50.0);

            pane.getChildren().addAll(bord);
            pane.setId("anchor");

            Scene scene2 = new Scene(pane, 450, 450);
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.initStyle(StageStyle.UTILITY);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.show();

        });
    }
}