package Id;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class Restaurant extends Application {
    private Stage window;
    private Scene scene1, scene2, scene3;
    private GridPane grid1, grid2;
    private CheckBox cheeseBurgerCB, meatBurgerCB, chickenBurgerCB, veggieBurgerCB, cokeCB, orangeJuiceCB, icedTeaCB, coffeeCB, classicFriesCB, curlyFriesCB, jumboFriesCB, chocolateCB, caramelCB, milkshakeCB;
    private TextField tableNumTF, cheeseBurgerTF, meatBurgerTF, chickenBurgerTF, veggieBurgerTF, cokeTF, orangeJuiceTF, icedTeaTF, coffeeTF, classicFriesTF, curlyFriesTF, jumboFriesTF, chocolateTF, caramelTF, milkshakeTF;
    private Label tableNumLabel, welcomeLabel, burgersMenuLabel, drinksMenuLabel, friesMenuLabel, iceCreamMenuLabel, cheeseBurgerLabel, meatBurgerLabel, chickenBurgerLabel, veggieBurgerLabel, cokeLabel, orangeJuiceLabel, icedTeaLabel, coffeeLabel, classicFriesLabel, curlyFriesLabel, jumboFriesLabel, chocolateLabel, caramelLabel, milkshakeLabel, thanksLabel, totalPriceLabel;
    private Button startButton, orderButton, backButton, showPriceButton, exitButton;
    private HBox cheeseBurgerHBox, meatBurgerHBox, chickenBurgerHBox, veggieBurgerHBox, cokeHBox, orangeJuiceHBox, icedTeaHBox, coffeeHBox, classicFriesHBox, curlyFriesHBox, jumboFriesHBox, chocolateHBox, caramelHBox, milkshakeHBox, buttonsHBox, lastButtonsHBox;
    private VBox burgersVBox, drinksVBox, friesVBox, iceCreamVBox, finalVBox;
    private Alert confirmAlert, errorAlert, infoAlert;
    private Optional<ButtonType> answer;
    private List<CheckBox> checkBoxesList;
    private Map<CheckBox, TextField> textFieldsMap;
    private Map<CheckBox, Integer> priceMap;

    // MAIN METHOD
    public static void main(String[] args) {
        launch();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        this.window.setTitle("RESTAURANT");
        
        scene1 = new Scene(this.getGrid1(), 300, 150);
        scene2 = new Scene(this.getGrid2(), 800, 400);
        scene3 = new Scene(this.getGrid3(), 500, 150);

        window.setScene(scene1);
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

    // SCENE 1 LAYOUT
    private GridPane getGrid1() {
        grid1 = new GridPane();
        grid1.setPadding(new Insets(20, 20, 20, 20));
        grid1.setVgap(8);
        grid1.setHgap(10);

        // LABELS
        tableNumLabel = new Label("Table Number : ");
        welcomeLabel = new Label();
        welcomeLabel.setStyle("-fx-font-size:16px;");
        // TEXTFIELD
        tableNumTF = new TextField();
        tableNumTF.setPromptText("enter your table number");
        // BUTTON
        startButton = new Button("Start Choosing");
        startButton.setOnAction(e -> {
            welcomeLabel.setText("Welcome, " + "Your Table Number is " + tableNumTF.getText());
            window.setScene(scene2);
        });

        GridPane.setConstraints(tableNumLabel, 0, 0);
        GridPane.setConstraints(tableNumTF, 1, 0);
        GridPane.setConstraints(startButton, 1, 1);

        grid1.getChildren().addAll(tableNumLabel, tableNumTF, startButton);
        grid1.setAlignment(Pos.CENTER);
        return grid1;
    }

    // SCENE 2 LAYOUT
    private GridPane getGrid2() {
        grid2 = new GridPane();
        grid2.setPadding(new Insets(20, 20, 20, 20));
        grid2.setVgap(8);
        grid2.setHgap(10);

        // CHECKBOXES
        cheeseBurgerCB = new CheckBox();
        meatBurgerCB = new CheckBox();
        chickenBurgerCB = new CheckBox();
        veggieBurgerCB = new CheckBox();
        cokeCB = new CheckBox();
        orangeJuiceCB = new CheckBox();
        icedTeaCB = new CheckBox();
        coffeeCB = new CheckBox();
        classicFriesCB = new CheckBox();
        curlyFriesCB = new CheckBox();
        jumboFriesCB = new CheckBox();
        chocolateCB = new CheckBox();
        caramelCB = new CheckBox();
        milkshakeCB = new CheckBox();

        // TEXTFIELDS
        cheeseBurgerTF = new TextField();
        cheeseBurgerTF.setPromptText("amount");
        meatBurgerTF = new TextField();
        meatBurgerTF.setPromptText("amount");
        chickenBurgerTF = new TextField();
        chickenBurgerTF.setPromptText("amount");
        veggieBurgerTF = new TextField();
        veggieBurgerTF.setPromptText("amount");
        cokeTF = new TextField();
        cokeTF.setPromptText("amount");
        orangeJuiceTF = new TextField();
        orangeJuiceTF.setPromptText("amount");
        icedTeaTF = new TextField();
        icedTeaTF.setPromptText("amount");
        coffeeTF = new TextField();
        coffeeTF.setPromptText("amount");
        classicFriesTF = new TextField();
        classicFriesTF.setPromptText("amount");
        curlyFriesTF = new TextField();
        curlyFriesTF.setPromptText("amount");
        jumboFriesTF = new TextField();
        jumboFriesTF.setPromptText("amount");
        chocolateTF = new TextField();
        chocolateTF.setPromptText("amount");
        caramelTF = new TextField();
        caramelTF.setPromptText("amount");
        milkshakeTF = new TextField();
        milkshakeTF.setPromptText("amount");

        // LABELS
        burgersMenuLabel = new Label("BURGERS");
        burgersMenuLabel.setStyle("-fx-font-size:18px;");
        cheeseBurgerLabel = new Label("Cheese Burger\t\tRp15.000,00");
        meatBurgerLabel = new Label("Meat Burger\t\tRp30.000,00");
        chickenBurgerLabel = new Label("Chicken Burger\tRp25.000,00");
        veggieBurgerLabel = new Label("Veggie Burger\t\tRp20.000,00");
        drinksMenuLabel = new Label("DRINKS");
        drinksMenuLabel.setStyle("-fx-font-size:16px;");
        cokeLabel = new Label("Coke\t\t\t\tRp8.000,00");
        orangeJuiceLabel = new Label("Orange Juice\t\t\tRp10.000,00");
        icedTeaLabel = new Label("Iced Tea\t\t\t\tRp7.000,00");
        coffeeLabel = new Label("Coffee\t\t\t\tRp12.000,00");
        friesMenuLabel = new Label("FRIES");
        friesMenuLabel.setStyle("-fx-font-size:16px;");
        classicFriesLabel = new Label("Classic Fries\t\tRp12.000,00");
        curlyFriesLabel = new Label("Curly Fries\t\tRp16.000,00");
        jumboFriesLabel = new Label("Jumbo Fries\t\tRp18.000,00");
        iceCreamMenuLabel = new Label("ICE CREAM");
        iceCreamMenuLabel.setStyle("-fx-font-size:16px;");
        chocolateLabel = new Label("Chocolate Ice Cream\tRp11.000,00");
        caramelLabel = new Label("Caramel Ice Cream\t\tRp12.000,00");
        milkshakeLabel = new Label("Milkshake Ice Cream\tRp13.000,00");

        // BUTTONS
        orderButton = new Button("Order");
        orderButton.setOnAction(e -> {
            priceMap = new HashMap<>();
            priceMap.put(cheeseBurgerCB, 15000);
            priceMap.put(meatBurgerCB, 30000);
            priceMap.put(chickenBurgerCB, 25000);
            priceMap.put(veggieBurgerCB, 20000);
            priceMap.put(cokeCB, 8000);
            priceMap.put(orangeJuiceCB, 10000);
            priceMap.put(icedTeaCB, 7000);
            priceMap.put(coffeeCB, 12000);
            priceMap.put(classicFriesCB, 12000);
            priceMap.put(curlyFriesCB, 16000);
            priceMap.put(jumboFriesCB, 18000);
            priceMap.put(chocolateCB, 11000);
            priceMap.put(caramelCB, 12000);
            priceMap.put(milkshakeCB, 13000);
            
            confirmAlert = new Alert(AlertType.CONFIRMATION);
            errorAlert = new Alert(AlertType.ERROR);

            if (getValidation()) {
                confirmAlert.setTitle("CONFIRMATION");
                confirmAlert.setContentText("Are you sure?");
                answer  = confirmAlert.showAndWait();
                if (answer.isPresent() && answer.get() != ButtonType.OK) {
                    return;
                } else {    
                    window.setScene(scene3);
                }
            } else {
                errorAlert.setTitle("ERROR");
                errorAlert.setContentText("Please Choose At Least 1 Item and Input a Valid Amount!");
                errorAlert.showAndWait();
            }
        });

        backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.setScene(scene1);
        });

        // HBOXES
        cheeseBurgerHBox = new HBox(10);
        cheeseBurgerHBox.getChildren().addAll(cheeseBurgerCB, cheeseBurgerTF, cheeseBurgerLabel);
        meatBurgerHBox = new HBox(10);
        meatBurgerHBox.getChildren().addAll(meatBurgerCB, meatBurgerTF, meatBurgerLabel);
        chickenBurgerHBox = new HBox(10);
        chickenBurgerHBox.getChildren().addAll(chickenBurgerCB, chickenBurgerTF, chickenBurgerLabel);
        veggieBurgerHBox = new HBox(10);
        veggieBurgerHBox.getChildren().addAll(veggieBurgerCB, veggieBurgerTF, veggieBurgerLabel);
        cokeHBox = new HBox(10);
        cokeHBox.getChildren().addAll(cokeCB, cokeTF, cokeLabel);
        orangeJuiceHBox = new HBox(10);
        orangeJuiceHBox.getChildren().addAll(orangeJuiceCB, orangeJuiceTF, orangeJuiceLabel);
        icedTeaHBox = new HBox(10);
        icedTeaHBox.getChildren().addAll(icedTeaCB, icedTeaTF, icedTeaLabel);
        coffeeHBox = new HBox(10);
        coffeeHBox.getChildren().addAll(coffeeCB, coffeeTF, coffeeLabel);
        classicFriesHBox = new HBox(10);
        classicFriesHBox.getChildren().addAll(classicFriesCB, classicFriesTF, classicFriesLabel);
        curlyFriesHBox = new HBox(10);
        curlyFriesHBox.getChildren().addAll(curlyFriesCB, curlyFriesTF, curlyFriesLabel);
        jumboFriesHBox = new HBox(10);
        jumboFriesHBox.getChildren().addAll(jumboFriesCB, jumboFriesTF, jumboFriesLabel);
        chocolateHBox = new HBox(10);
        chocolateHBox.getChildren().addAll(chocolateCB, chocolateTF, chocolateLabel);
        caramelHBox = new HBox(10);
        caramelHBox.getChildren().addAll(caramelCB, caramelTF, caramelLabel);
        milkshakeHBox = new HBox(10);
        milkshakeHBox.getChildren().addAll(milkshakeCB, milkshakeTF, milkshakeLabel);
        buttonsHBox = new HBox(10);
        buttonsHBox.getChildren().addAll(backButton, orderButton);

        // VBOXES
        burgersVBox = new VBox(8);
        burgersVBox.getChildren().addAll(burgersMenuLabel, cheeseBurgerHBox, meatBurgerHBox, chickenBurgerHBox, veggieBurgerHBox);
        drinksVBox = new VBox(8);
        drinksVBox.getChildren().addAll(drinksMenuLabel, cokeHBox, orangeJuiceHBox, icedTeaHBox, coffeeHBox);
        friesVBox = new VBox(8);
        friesVBox.getChildren().addAll(friesMenuLabel, classicFriesHBox, curlyFriesHBox, jumboFriesHBox);
        iceCreamVBox = new VBox(8);
        iceCreamVBox.getChildren().addAll(iceCreamMenuLabel, chocolateHBox, caramelHBox, milkshakeHBox);

        // MENU LAYOUT
        GridPane.setConstraints(welcomeLabel, 0, 0);
        GridPane.setConstraints(burgersVBox, 0, 1);
        GridPane.setConstraints(drinksVBox, 1, 1);
        GridPane.setConstraints(friesVBox, 0, 2);
        GridPane.setConstraints(iceCreamVBox, 1, 2);
        GridPane.setConstraints(buttonsHBox, 1, 3);

        grid2.getChildren().addAll(welcomeLabel, burgersVBox, drinksVBox, friesVBox, iceCreamVBox, buttonsHBox);
        grid2.setAlignment(Pos.CENTER);
        return grid2;
    }

    // SCENE 3 LAYOUT
    private VBox getGrid3() {
        finalVBox = new VBox(10);
        finalVBox.setAlignment(Pos.CENTER);

        // LABELS
        thanksLabel = new Label("Thank You For Ordering ^_^");
        thanksLabel.setAlignment(Pos.CENTER);
        totalPriceLabel = new Label();
        totalPriceLabel.setStyle("-fx-font-size:18px;");
        totalPriceLabel.setAlignment(Pos.CENTER);

        // BUTTONS
        showPriceButton = new Button("Show Bill");
        showPriceButton.setOnAction(e -> {
            totalPriceLabel.setText("Total Price : " + getTotalPrice().getText());
            infoAlert = new Alert(AlertType.INFORMATION);
            infoAlert.setTitle("TOTAL PRICE");
            infoAlert.setContentText(totalPriceLabel.getText());
            infoAlert.showAndWait();
        });

        backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.setScene(scene2);
        });

        exitButton = new Button("Paynow & Exit");
        exitButton.setOnAction(e -> {
            window.close();
        });

        // LAYOUT
        lastButtonsHBox = new HBox(10);
        lastButtonsHBox.getChildren().addAll(backButton, showPriceButton, exitButton);
        lastButtonsHBox.setAlignment(Pos.CENTER);

        finalVBox.getChildren().addAll(thanksLabel, lastButtonsHBox);
        return finalVBox;
    }

    // CHECKING USER'S CHOICE
    private boolean getValidation() {
        checkBoxesList = new ArrayList<>();
        checkBoxesList.add(cheeseBurgerCB);
        checkBoxesList.add(meatBurgerCB);
        checkBoxesList.add(chickenBurgerCB);
        checkBoxesList.add(veggieBurgerCB);
        checkBoxesList.add(cokeCB);
        checkBoxesList.add(orangeJuiceCB);
        checkBoxesList.add(icedTeaCB);
        checkBoxesList.add(coffeeCB);
        checkBoxesList.add(classicFriesCB);
        checkBoxesList.add(curlyFriesCB);
        checkBoxesList.add(jumboFriesCB);
        checkBoxesList.add(chocolateCB);
        checkBoxesList.add(caramelCB);
        checkBoxesList.add(milkshakeCB);

        textFieldsMap = new HashMap<>();
        textFieldsMap.put(cheeseBurgerCB, cheeseBurgerTF);
        textFieldsMap.put(meatBurgerCB, meatBurgerTF);
        textFieldsMap.put(chickenBurgerCB, chickenBurgerTF);
        textFieldsMap.put(veggieBurgerCB, veggieBurgerTF);
        textFieldsMap.put(cokeCB, cokeTF);
        textFieldsMap.put(orangeJuiceCB, orangeJuiceTF);
        textFieldsMap.put(icedTeaCB, icedTeaTF);
        textFieldsMap.put(coffeeCB, coffeeTF);
        textFieldsMap.put(classicFriesCB, classicFriesTF);
        textFieldsMap.put(curlyFriesCB, curlyFriesTF);
        textFieldsMap.put(jumboFriesCB, jumboFriesTF);
        textFieldsMap.put(chocolateCB, chocolateTF);
        textFieldsMap.put(caramelCB, caramelTF);
        textFieldsMap.put(milkshakeCB, milkshakeTF);

        if (handleCheckBoxes(checkBoxesList)) {
            if (handleTextFields(getSelectedCheckBox(textFieldsMap))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // RETURN A LIST OF CHOSEN CHECKBOXES
    private List<CheckBox> getSelectedCheckBox(Map<CheckBox, TextField> textFieldsMap) {
        List<CheckBox> isSelected = new ArrayList<>();
        for (CheckBox checkBox : textFieldsMap.keySet()) {
            if (checkBox.isSelected()) {
                isSelected.add(checkBox);
            }
        }
        return isSelected;
    }

    // CHECK IF THERE IS AT LEAST ONE CHOSEN CHECKBOX
    private boolean handleCheckBoxes(List<CheckBox> checkBoxesList) {
        int selected = 0;
        for (CheckBox checkBox : checkBoxesList) {
            if (checkBox.isSelected())
                selected++;
        }
        if (selected > 0) {
            return true;
        } else {
            return false;
        }
    }

    // CHECK IF THE INPUTED AMOUNT WAS VALID OR NOT
    private boolean handleTextFields(List<CheckBox> checkBoxesList) {
        int size = checkBoxesList.size();
        int count = 0;
        for (CheckBox checkBox : checkBoxesList) {
            if (isInt(this.textFieldsMap.get(checkBox).getText())) {
                count++;
            }
        }
        if (count == size) {
            return true;
        } else {
            return false;
        }
    }

    // CHECKING STRING
    private boolean isInt(String str) {
        if (str == null || Integer.valueOf(str) <= 0) {
            return false;
        }
        try {
           Integer.parseInt(str); 
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // CALCULATE THE TOTAL PRICE OF CHOSEN ITEM(S)
    private Label getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < getSelectedCheckBox(textFieldsMap).size(); i++) {
            String s = textFieldsMap.get(getSelectedCheckBox(textFieldsMap).get(i)).getText();
            totalPrice += (priceMap.get(getSelectedCheckBox(textFieldsMap).get(i))) * Integer.valueOf(s);
        }
        Label label = currencyFormatting(totalPrice);
        return label;
    }
    
    // FORMATTING STRING INTO INDONESIAN'S CURRENCY FORMAT
    private static Label currencyFormatting(Integer a) {
        String currency;
        Locale localeID = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(localeID);
        currency = rupiahFormat.format((double) a);

        Label currencyLabel = new Label();
        currencyLabel.setText(currency);

        return currencyLabel;
    }

}