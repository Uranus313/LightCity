import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
//        new Heaven();
//      Heaven.menu(window);
        Button[] buttons = new Button[48];
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(5);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_LEFT);
        hBox.setStyle("-fx-background-color: blue;");
        Label nameLabel = new Label("Mehrbod 100");
        hBox.getChildren().add(nameLabel);
        Image bankImage = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\Bank.jpg");
        for(int i =0;i<48;i++){
            buttons[i]= new Button();
            ImageView view = new ImageView(bankImage);
            buttons[i].setGraphic(view);
        }
        int i=0;
        GridPane layout = new GridPane();
        layout.add(buttons[i++],0,0);
        layout.add(buttons[i++],7,0);
        layout.add(buttons[i++],14,0);
        layout.add(buttons[i++],2,2);
        layout.add(buttons[i++],6,2);
        layout.add(buttons[i++],8,2);
        layout.add(buttons[i++],12,2);
        layout.add(buttons[i++],3,3);
        layout.add(buttons[i++],5,3);
        layout.add(buttons[i++],9,3);
        layout.add(buttons[i++],11,3);
        layout.add(buttons[i++],4,4);
        layout.add(buttons[i++],10,4);
        layout.add(buttons[i++],3,5);
        layout.add(buttons[i++],6,5);
        layout.add(buttons[i++],8,5);
        layout.add(buttons[i++],11,5);
        layout.add(buttons[i++],2,6);
        layout.add(buttons[i++],5,6);
        layout.add(buttons[i++],7,6);
        layout.add(buttons[i++],9,6);
        layout.add(buttons[i++],12,6);
        layout.add(buttons[i++],0,7);
        layout.add(buttons[i++],6,7);
        layout.add(buttons[i++],8,7);
        layout.add(buttons[i++],14,7);
        layout.add(buttons[i++],2,8);
        layout.add(buttons[i++],5,8);
        layout.add(buttons[i++],7,8);
        layout.add(buttons[i++],9,8);
        layout.add(buttons[i++],12,8);
        layout.add(buttons[i++],3,9);
        layout.add(buttons[i++],6,9);
        layout.add(buttons[i++],8,9);
        layout.add(buttons[i++],11,9);
        layout.add(buttons[i++],4,10);
        layout.add(buttons[i++],10,10);
        layout.add(buttons[i++],3,11);
        layout.add(buttons[i++],5,11);
        layout.add(buttons[i++],9,11);
        layout.add(buttons[i++],11,11);
        layout.add(buttons[i++],2,12);
        layout.add(buttons[i++],6,12);
        layout.add(buttons[i++],8,12);
        layout.add(buttons[i++],12,12);
        layout.add(buttons[i++],0,14);
        layout.add(buttons[i++],7,14);
        layout.add(buttons[i++],14,14);
        layout.setHgap(3);
        layout.setVgap(3);
        vBox.getChildren().addAll(hBox,layout);

        layout.setAlignment(Pos.CENTER);
        layout.getStylesheets().add(getClass().getResource("Test.css").toExternalForm());

        Scene scene = new Scene(vBox);
        window.setMaxHeight(800);
        window.setMaxWidth(1000);
        scene.getStylesheets().add(getClass().getResource("Test.css").toExternalForm());
        window.setScene(scene);
        window.show();





    }





    private static PublicKey loadPublicKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] publicKeyBytes = Objects.requireNonNull(Main.class.getResourceAsStream("/key.pub")).readAllBytes();

        KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        return publicKeyFactory.generatePublic(publicKeySpec);
    }


    public static String encode(String toEncode) throws Exception {

        PublicKey publicKey = loadPublicKey();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(toEncode.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(bytes));
    }



    private static PrivateKey loadPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] privateKeyBytes = Objects.requireNonNull(Main.class.getResourceAsStream("/key.priv")).readAllBytes();

        KeyFactory privateKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        return privateKeyFactory.generatePrivate(privateKeySpec);
    }


    public static String decode(String toDecode) throws Exception {

        PrivateKey privateKey = loadPrivateKey();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(toDecode));
        return new String(bytes);

    }



}