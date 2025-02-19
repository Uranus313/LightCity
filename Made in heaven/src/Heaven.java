import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;


public class Heaven {
    public static Image bankImage;
    public static Image blockImage;
    public static Image casinoImage;
    public static Image drugStoreImage;
    public static Image entertainmentImage;
    public static Image factoryImage;
    public static Image restaurantImage;
    public static Image superMarketImage;

    private static ArrayList<LightCity> cities;
    private static ArrayList<User> users;
    private static ArrayList<Block> blocks;
    private static ArrayList<Avatar> avatars;
    Heaven(){
         bankImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Bank.png");
         blockImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Block2.png");
         casinoImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Casino.png");
         drugStoreImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\DrugStore.png");
         entertainmentImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\entertainment.png");
         factoryImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Factory.png");
         restaurantImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Restaurant.png");
         superMarketImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\SuperMarket.png");
        cities = new ArrayList<>();
        users = new ArrayList<>();
        blocks = new ArrayList<>();
    }
    public static void loadAll(){
        users = Database.popUsers();
        blocks = Database.popBlocks();
        for (Casino block : Database.popCasinos()){
            blocks.add(block);
        }
        for (DrugStore block : Database.popDrugStores()){
            blocks.add(block);
        }
        for (Entertainment block : Database.popEntertainments()){
            blocks.add(block);
        }
        for (Factory block : Database.popFactories()){
            blocks.add(block);
        }
        for (Restaurant block : Database.popRestaurants()){
            blocks.add(block);
        }
        for (SuperMarket block : Database.popSuperMarkets()){
            blocks.add(block);
        }
        avatars = Database.popAvatars();
        cities = Database.popLightCities();
        if(cities.size()>0) {
            System.out.println(cities.size());
            LightCity.setIDCreator(cities.size()+1);
        }
        if(users.size()>0){
            User.setIDCreator(users.get(users.size()-1).getID() +1);
        }
        if(avatars.size()>0){
            Avatar.setIDCreator(avatars.get(avatars.size()-1).getID() +1);
        }
    }
    public static void menu(Stage window){
        LightCity.timeSkip();
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        Button joinButton = new Button("Join");
        joinButton.setOnAction(e -> logIn(window) );
        Button signUpButton = new Button("sign up");
        signUpButton.setOnAction(e -> signUp(window));
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> window.close());
        layout.getChildren().addAll(joinButton,signUpButton,exitButton);
        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.setHeight(500);
        window.setWidth(500);
        window.show();
    }
    public static void signUp(Stage window){

        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Sign Up");
        Label userNameLabel = new Label("user name :");
        Label passwordLabel = new Label("password :");
        TextField userNameField = new TextField();
        userNameField.setPromptText("user name");
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
            for(User user : users) {
                if (user.getUsername().equals(userNameField.getText())) {
                    checker = false;
                    break;
                }
            }
                if(checker){
                    User newUser = new User(userNameField.getText(),passwordField.getText());
                    Database.insertData(newUser);
                    users.add(newUser);
                    newUser.menu(window);
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
    public static void logIn(Stage window){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Label welcomeLabel = new Label("Log In");
        Label userNameLabel = new Label("user name :");
        Label passwordLabel = new Label("password :");
        TextField userNameField = new TextField();
        userNameField.setPromptText("user name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("********");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> menu(window));
        Button logInButton = new Button("Log In");
        logInButton.setOnAction(e -> {
            boolean checker = true;
            for(User user : users){
                if(user.getUsername().equals(userNameField.getText()) && user.getPassword().equals(passwordField.getText())){
                    user.menu(window);
                    checker = false;
                }
            }
            if(checker){
                AlertBox.display("404","no user with this userName and password has been found");
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

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        Heaven.users = users;
    }

    public static ArrayList<Block> getBlocks() {
        return blocks;
    }

    public static void setBlocks(ArrayList<Block> blocks) {
        Heaven.blocks = blocks;
    }

    public static ArrayList<Avatar> getAvatars() {
        return avatars;
    }

    public static void setAvatars(ArrayList<Avatar> avatars) {
        Heaven.avatars = avatars;
    }

    public static ArrayList<LightCity> getCities() {
        return cities;
    }

    public static void setCities(ArrayList<LightCity> cities) {
        Heaven.cities = cities;
    }
}
