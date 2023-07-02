import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Casino extends Shop{
    public Casino(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }

    public Casino(String name, long income, long price, long salary, long ownerID, long ID, long cityID, int item1Price, int item2Price, int item3Price, int item4Price) {
        super(name, income, price, salary, ownerID, ID, cityID, item1Price, item2Price, item3Price, item4Price);
    }
    public void buyItem(Stage window, Avatar avatar){
        Label welcomeLabel = new Label("play your games");
        Label item1Label = new Label("high chance,entry = "+getItem1Price()+",prize = "+getItem1Price()*0.5);
        Button item1Button = new Button("Coin flip");
        Label item2Label = new Label("medium chance, price = "+getItem2Price()+",prize = "+getItem2Price()*3);
        Button item2Button = new Button("Slot machine");
        Label item3Label = new Label("low chance,entry = "+getItem3Price()+",prize = "+10*getItem3Price());
        Button item3Button = new Button("Poker");
        Label item4Label = new Label("entry = your life ,prize = "+getItem4Price());
        Button item4Button = new Button("Russian roulette");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.customerMenu(avatar);

        });
        item1Button.setOnAction(e ->{
            Random random = new Random();
            if(Bank.checkMoney(avatar,this.getOwner(),getItem1Price())){
                int chance = random.nextInt(1,101);
                if(chance>50){
                    avatar.setMoney((long) (getItem1Price()*2.5));
                }
            }
        });
        item2Button.setOnAction(e->{
            Random random = new Random();
            if(Bank.checkMoney(avatar,this.getOwner(),getItem2Price())){
                int chance = random.nextInt(1,101);
                if(chance>90){
                    avatar.setMoney((long) (getItem2Price()*4));
                }
            }
        });
        item3Button.setOnAction(e ->{
        Random random = new Random();
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){

                int chance = random.nextInt(1,101);
                if(chance>97){
                    avatar.setMoney((long) (getItem3Price()*11));
                }
            }
        });
        item4Button.setOnAction(e ->{
        Random random = new Random();
            int chance = random.nextInt(1,7);
            if(chance==1){
                avatar.setMoney(avatar.getMoney()+getItem4Price());
            }else{
                avatar.setHealth(0);
                avatar.setAlive(false);
                this.getOwner().setHappiness(this.getOwner().getHappiness()+10);
            }
        });
        if(this.getEmployees().size()<5){
            item2Button.setDisable(true);
        }
        if(this.getEmployees().size()<10){
            item3Button.setDisable(true);
        }
        if(this.getEmployees().size()<15){
            item4Button.setDisable(true);
        }

        GridPane layout = new GridPane();
        layout.add(welcomeLabel,0,0);
        layout.add(item1Label,0,1);
        layout.add(item2Label,0,2);
        layout.add(item3Label,0,3);
        layout.add(item4Label,0,4);
        layout.add(item1Button,1,1);
        layout.add(item2Button,1,2);
        layout.add(item3Button,1,3);
        layout.add(item4Button,1,4);
        layout.add(backButton,0,5);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        window.setScene(scene);

    }
}
