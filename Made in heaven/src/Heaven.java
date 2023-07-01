import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;

public class Heaven {
    private static ArrayList<LightCity> cities;
    private static ArrayList<User> users;
    Heaven(){
        cities = new ArrayList<>();
        users = new ArrayList<>();
    }
    public static void menu(Stage window){
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

    public static ArrayList<LightCity> getCities() {
        return cities;
    }

    public static void setCities(ArrayList<LightCity> cities) {
        Heaven.cities = cities;
    }
}
