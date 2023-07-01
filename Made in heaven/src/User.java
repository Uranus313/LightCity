import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class User {
    private int ID;
    private String username;
    private String password;
    private static int IDCreator=1;

    public User(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.ID= IDCreator;
        IDCreator++;
    }
    public void menu(Stage window){
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        Button joinButton = new Button("Join");
        joinButton.setOnAction(e -> this.joinCity(window) );
        Button signUpButton = new Button("Make city(simple)");
        signUpButton.setOnAction(e -> this.simpleMakeCity(window));
        Button proMakeCityButton = new Button("Make city(custom)");
        proMakeCityButton.setOnAction(e -> proMakeCity(window));
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(joinButton,signUpButton,proMakeCityButton,exitButton);
        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.setHeight(500);
        window.setWidth(500);
        window.show();
    }
    public void proMakeCity(Stage window){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("create city");
        Label userNameLabel = new Label("city name :");
        Label passwordLabel = new Label("password :");
        Label pricesLabel = new Label("Prices");
        Label incomesLabel = new Label("Incomes");
        Label blockLabel = new Label("empty block :");
        Label bankLabel = new Label("Bank :");
        Label entertainmentLabel = new Label("Entertainment center :");
        Label restaurantLabel = new Label("Restaurant :");
        Label drugStoreLabel = new Label("Drug store :");
        Label superMarketLabel = new Label("Super market :");
        Label casinoLabel = new Label("Casino :");
        Label factoryLabel = new Label("Factory :");
        TextField blockPriceField = new TextField();
        TextField bankPriceField = new TextField();
        TextField entertainmentPriceField = new TextField();
        TextField restaurantPriceField = new TextField();
        TextField drugStorePriceField = new TextField();
        TextField superMarketPriceField = new TextField();
        TextField casinoPriceField = new TextField();
        TextField factoryPriceField = new TextField();
        TextField bankIncomeField = new TextField();
        TextField entertainmentIncomeField = new TextField();
        TextField restaurantIncomeField = new TextField();
        TextField drugStoreIncomeField = new TextField();
        TextField superMarketIncomeField = new TextField();
        TextField casinoIncomeField = new TextField();
        TextField factoryIncomeField = new TextField();




        TextField userNameField = new TextField();
        userNameField.setPromptText("city name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("********");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> menu(window));
        Button logInButton = new Button("Sign up");
        logInButton.setOnAction(e -> {
            try {
                if (passwordField.getText().isEmpty()) {
                    throw new Exception();
                }
                for (LightCity lightCity : Heaven.getCities()) {
                    if (lightCity.getName().equals(userNameField.getText())) {
                        throw new Exception();
                    }
                }

                try {
                    LightCity newCity = new LightCity(userNameField.getText(), passwordField.getText(),
                            Long.parseLong(blockPriceField.getText()), Long.parseLong(bankPriceField.getText()),
                            Long.parseLong(superMarketPriceField.getText()), Long.parseLong(drugStorePriceField.getText()),
                            Long.parseLong(entertainmentPriceField.getText()), Long.parseLong(restaurantPriceField.getText()), Long.parseLong(casinoPriceField.getText()),
                            Long.parseLong(factoryPriceField.getText()), Long.parseLong(bankIncomeField.getText()),
                            Long.parseLong(superMarketIncomeField.getText()), Long.parseLong(drugStoreIncomeField.getText())
                            , Long.parseLong(entertainmentIncomeField.getText()),
                            Long.parseLong(restaurantIncomeField.getText()), Long.parseLong(casinoIncomeField.getText()),
                            Long.parseLong(factoryIncomeField.getText()));
                    Heaven.getCities().add(newCity);
                    this.createAvatar(window,newCity);

                } catch (Exception c) {
                    AlertBox.display("fail", "all prices and incomes should be a number ");
                }
            }catch (Exception c){
                AlertBox.display("problem", "this username is already taken");
            }
        });
        layout.add(welcomeLabel,0,0);
        layout.add(userNameLabel,1,1);
        layout.add(passwordLabel,1,2);
        layout.add(userNameField,2,1);
        layout.add(passwordField,2,2);
        layout.add(pricesLabel,1,3);
        layout.add(incomesLabel,2,3);
        layout.add(blockLabel,0,4);
        layout.add(blockPriceField,1,4);
        layout.add(bankLabel,0,5);
        layout.add(bankPriceField,1,5);
        layout.add(bankIncomeField,2,5);
        layout.add(superMarketLabel,0,6);
        layout.add(superMarketPriceField,1,6);
        layout.add(superMarketIncomeField,2,6);
        layout.add(drugStoreLabel,0,7);
        layout.add(drugStorePriceField,1,7);
        layout.add(drugStoreIncomeField,2,7);
        layout.add(entertainmentLabel,0,8);
        layout.add(entertainmentPriceField,1,8);
        layout.add(entertainmentIncomeField,2,8);
        layout.add(restaurantLabel,0,9);
        layout.add(restaurantPriceField,1,9);
        layout.add(restaurantIncomeField,2,9);
        layout.add(casinoLabel,0,10);
        layout.add(casinoPriceField,1,10);
        layout.add(casinoIncomeField,2,10);
        layout.add(factoryLabel,0,11);
        layout.add(factoryPriceField,1,11);
        layout.add(factoryIncomeField,2,11);
        layout.add(backButton,0,12);
        layout.add(logInButton,1,12);
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }
    public void simpleMakeCity(Stage window){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Sign Up");
        Label userNameLabel = new Label("city name :");
        Label passwordLabel = new Label("password :");
        TextField userNameField = new TextField();
        userNameField.setPromptText("city name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("********");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> menu(window));
        Button logInButton = new Button("Sign up");
        logInButton.setOnAction(e -> {
            boolean checker = true;
            if(passwordField.getText().isEmpty()){
                checker = false;
            }
            for(LightCity lightCity : Heaven.getCities()) {
                if (lightCity.getName().equals(userNameField.getText())) {
                    checker = false;
                    break;
                }
            }
                if(checker){
                    LightCity lightCity = new LightCity(userNameField.getText(),passwordField.getText());
                    Heaven.getCities().add(lightCity);
                    createAvatar(window,lightCity);
                }else{
                    AlertBox.display("problem","this username is already taken");
                }
        });
        layout.add(welcomeLabel,0,0);
        layout.add(userNameLabel,0,1);
        layout.add(passwordLabel,0,2);
        layout.add(userNameField,1,1);
        layout.add(passwordField,1,2);
        layout.add(backButton,0,3);
        layout.add(logInButton,1,3);
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }
    public void joinCity(Stage window){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Log In");
        Label userNameLabel = new Label("city name :");
        Label passwordLabel = new Label("password :");
        TextField userNameField = new TextField();
        userNameField.setPromptText("city name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("********");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> menu(window));
        Button logInButton = new Button("Log In");
        logInButton.setOnAction(e -> {
            boolean checker = true;
            boolean checker2 = true;
            for(LightCity lightCity : Heaven.getCities()){
                if(lightCity.getName().equals(userNameField.getText()) && lightCity.getPassWord().equals(passwordField.getText())){
                    for(Avatar avatar : lightCity.getAvatars()){
                        if(avatar.getUserID()==this.getID()){
                            lightCity.menu(window,avatar);
                            checker2=false;
                        }
                    }
                    if(checker2) {
                        this.createAvatar(window,lightCity);
                    }
                    checker = false;
                }
            }
            if(checker){
                AlertBox.display("404","no city with this userName and password has been found");
            }
        });
        layout.add(welcomeLabel,0,0);
        layout.add(userNameLabel,0,1);
        layout.add(passwordLabel,0,2);
        layout.add(userNameField,1,1);
        layout.add(passwordField,1,2);
        layout.add(backButton,0,3);
        layout.add(logInButton,1,3);
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }
    public void createAvatar(Stage window,LightCity city){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("create Avatar");
        Label nameLabel = new Label("avatar name :");
        Label raceLabel = new Label("Race :");
        Label genderLabel = new Label("Gender :");
        TextField nameField = new TextField();
        ChoiceBox<String> raceBox = new ChoiceBox<>();
        raceBox.getItems().add("White");
        raceBox.getItems().add("Black");
        raceBox.getItems().add("Asian");
        raceBox.setValue("White");
        ChoiceBox<String> genderBox = new ChoiceBox<>();
        genderBox.getItems().add("Male");
        genderBox.getItems().add("Female");
        genderBox.setValue("Male");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> this.menu(window));
        Button submitButton = new Button("Create");
        submitButton.setOnAction(e -> {
            try {
                if(nameField.getText().isEmpty()){
                    throw new Exception();
                }
                for (Avatar avatar : city.getAvatars()) {
                    if(avatar.getName().equals(nameField.getText())){
                        throw new Exception();
                    }
                }
                Avatar avatar =new Avatar(nameField.getText(),this.getID(),city.getID(), Gender.valueOf(genderBox.getValue()),Race.valueOf(raceBox.getValue()));
                city.getAvatars().add(avatar);
                city.menu(window,avatar);
            }catch (Exception c){
                AlertBox.display("fail","this name is already taken");
            }
        });
        layout.add(welcomeLabel,0,0);
        layout.add(nameLabel,0,1);
        layout.add(nameField,1,1);
        layout.add(genderLabel,0,2);
        layout.add(genderBox,1,2);
        layout.add(raceLabel,0,3);
        layout.add(raceBox,1,3);
        layout.add(backButton,0,4);
        layout.add(submitButton,1,4);
        Scene scene = new Scene(layout);
        window.setScene(scene);

    }
    public ArrayList<Avatar> getAvatars(){
        ArrayList<Avatar> avatars = new ArrayList<>();
        for(LightCity city : Heaven.getCities() ){
            for(Avatar avatar : city.getAvatars()){
                if(avatar.getUserID()==this.getID()){
                    avatars.add(avatar);
                }
            }
        }
        return avatars;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getIDCreator() {
        return IDCreator;
    }

    public static void setIDCreator(int IDCreator) {
        User.IDCreator = IDCreator;
    }

}
