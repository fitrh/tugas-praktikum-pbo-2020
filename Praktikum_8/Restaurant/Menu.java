package id.fi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Menu {

    private AnchorPane pane;
    private Stage stage;

    public Menu(Stage stage) {
        this.stage = stage;
    }

    public void setLayout(AnchorPane pane) {
        this.pane = pane;
        BorderPane bord = new BorderPane();

        //Layout Menu Makanan
        TextField addFood[] = { new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), 
            new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), };
        for (int i = 0; i < addFood.length; i++) {
            addFood[i].setId("addFood");
            addFood[i].setPromptText("0");
        }
        for (int i = 0; i < addFood.length; i++) {
            addFood[i].setMaxSize(40, 35);
        }
        int foodCost[] = {22000,13000,20000,20000,15000,5000,5000,8000,7000,12000,4000,1000};
        Label food[] = {new Label("Ayam Geprek Spesial\nRp." +foodCost[0]),new Label("Ayam Geprek Biasa\t\nRp." +foodCost[1]),
            new Label("Ayam Goreng\t\t\nRp." +foodCost[2]), new Label("Ayam Bakar\t\t\nRp." +foodCost[3]),
            new Label("Ayam Krispi\t\t\nRp." +foodCost[4]),new Label("Nasi\t\t\t\t\nRp." +foodCost[5]),
            new Label("Es Teh\t\nRp." +foodCost[6]),new Label("Jus Jeruk\nRp." +foodCost[7]),
            new Label("Jus Lemon\nRp." +foodCost[8]),new Label("Jus Alfukat\nRp." +foodCost[9]),
            new Label("Air Botol\t\nRp." +foodCost[10]),new Label("Air Gelas\t\nRp." +foodCost[11]),};
        HBox geprekSBox = new HBox();
        geprekSBox.getChildren().addAll(food[0],addFood[0]);
        geprekSBox.setSpacing(10);
        FlowPane left = new FlowPane();
        left.getChildren().add(geprekSBox);
        
        HBox geprekBox = new HBox();
        geprekBox.getChildren().addAll(food[1],addFood[1]);
        geprekBox.setSpacing(10);
        FlowPane left2 = new FlowPane();
        left2.getChildren().add(geprekBox);

        HBox gorengBox = new HBox();
        gorengBox.getChildren().addAll(food[2],addFood[2]);
        gorengBox.setSpacing(10);
        FlowPane left3 = new FlowPane();
        left3.getChildren().add(gorengBox);

        HBox bakarBox = new HBox();
        bakarBox.getChildren().addAll(food[3],addFood[3]);
        bakarBox.setSpacing(10);
        FlowPane left4 = new FlowPane();
        left4.getChildren().add(bakarBox);

        HBox krispyBox = new HBox();
        krispyBox.getChildren().addAll(food[4],addFood[4]);
        krispyBox.setSpacing(10);
        FlowPane left5 = new FlowPane();
        left5.getChildren().add(krispyBox);

        HBox nasiBox = new HBox();
        nasiBox.getChildren().addAll(food[5],addFood[5]);
        nasiBox.setSpacing(10);
        FlowPane left6 = new FlowPane();
        left6.getChildren().add(nasiBox);

        VBox leftFood = new VBox();
        leftFood.getChildren().addAll(left,left2,left3,left4,left5,left6);
        leftFood.setSpacing(30);
        leftFood.setAlignment(Pos.TOP_CENTER);
        bord.setLeft(leftFood);

        HBox tehBox = new HBox();
        tehBox.getChildren().addAll(food[6],addFood[6]);
        tehBox.setSpacing(10);
        FlowPane right = new FlowPane();
        right.getChildren().add(tehBox);

        HBox jerukBox = new HBox();
        jerukBox.getChildren().addAll(food[7],addFood[7]);
        jerukBox.setSpacing(10);
        FlowPane right2 = new FlowPane();
        right2.getChildren().add(jerukBox);

        HBox lemonBox = new HBox();
        lemonBox.getChildren().addAll(food[8],addFood[8]);
        lemonBox.setSpacing(10);
        FlowPane right3 = new FlowPane();
        right3.getChildren().add(lemonBox);

        HBox alfukatBox = new HBox();
        alfukatBox.getChildren().addAll(food[9],addFood[9]);
        alfukatBox.setSpacing(10);
        FlowPane right4 = new FlowPane();
        right4.getChildren().add(alfukatBox);

        HBox botolBox = new HBox();
        botolBox.getChildren().addAll(food[10],addFood[10]);
        botolBox.setSpacing(10);
        FlowPane right5 = new FlowPane();
        right5.getChildren().add(botolBox);

        HBox gelasBox = new HBox();
        gelasBox.getChildren().addAll(food[11],addFood[11]);
        gelasBox.setSpacing(10);
        FlowPane right6 = new FlowPane();
        right6.getChildren().add(gelasBox);

        VBox rightFood = new VBox();
        rightFood.getChildren().addAll(right,right2,right3,right4,right5,right6);
        rightFood.setSpacing(30);
        rightFood.setAlignment(Pos.TOP_CENTER);
        bord.setRight(rightFood);

        Button pay = new Button("Bayar");
        pay.setMaxSize(400, 50);

        //Hbox untuk menu
        HBox allFood = new HBox();
        allFood.getChildren().addAll(leftFood,rightFood);
        allFood.setSpacing(8);
        bord.setCenter(allFood);

        


        Circle circle[] = { new Circle(), new Circle()};
        for (int i = 0; i < circle.length; i++) {
                circle[i].setRadius(4.0);
        }
        circle[0].setFill(Color.YELLOW);
        circle[1].setFill(Color.RED);

        // HBOX menu untuk exit
        HBox upperMenu = new HBox();
        
        Button exit = new Button();
        exit.setShape(circle[1]);
        exit.setId("Exit");
        
        Button minimize = new Button();
        minimize.setShape(circle[0]);
        minimize.setId("Minimize");

        upperMenu.setPadding(new Insets(10,10,0,0));
        upperMenu.setId("upperMenu");
        upperMenu.getChildren().addAll(minimize,exit);
        upperMenu.setSpacing(10);
        upperMenu.setAlignment(Pos.TOP_RIGHT);
        upperMenu.setPrefHeight(20);
        upperMenu.setPrefWidth(600);
        
        AnchorPane.setTopAnchor(upperMenu, 0.0);
        AnchorPane.setBottomAnchor(upperMenu, 420.0);
        AnchorPane.setLeftAnchor(upperMenu, 150.2);
        AnchorPane.setRightAnchor(upperMenu, 0.0);

        AnchorPane.setTopAnchor(bord, 50.0);
        AnchorPane.setBottomAnchor(bord, 50.0);
        AnchorPane.setLeftAnchor(bord, 100.0);
        AnchorPane.setRightAnchor(bord, 100.0);

        AnchorPane.setTopAnchor(pay, 420.0);
        AnchorPane.setBottomAnchor(pay, 5.0);
        AnchorPane.setLeftAnchor(pay, 100.0);
        AnchorPane.setRightAnchor(pay, 100.0);

        Cart cart = new Cart(stage, 0);
        cart.addToCart(addFood, foodCost, pay);

        exit.setOnAction(e -> System.exit(0));

        minimize.setOnAction(e -> {
                ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true);
        });

        pane.getChildren().addAll(bord, upperMenu,pay);
        pane.setId("anchor");
    }
    public AnchorPane getAnchor() {        
        return pane;
    }
}