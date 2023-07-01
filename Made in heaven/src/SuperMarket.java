import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SuperMarket extends Shop{
    public SuperMarket(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }

    public SuperMarket(String name, long income, long price, long salary, long ownerID,
                       long ID, long cityID, int item1Price, int item2Price, int item3Price, int item4Price) {
        super(name, income, price, salary, ownerID, ID, cityID, item1Price, item2Price, item3Price, item4Price);
    }
    public void buyItem(Stage window, Avatar avatar){
        Label welcomeLabel = new Label("buy something");
        Label item1Label = new Label("+5 drink, price = "+getItem1Price());
        Button item1Button = new Button("Water");
        Label item2Label = new Label("+3 drink,+1 health,+1 food, price = "+getItem2Price());
        Button item2Button = new Button("fruit juice");
        Label item3Label = new Label("+1 happiness,+1 food,-1 food ,price = "+getItem3Price());
        Button item3Button = new Button("chips");
        Label item4Label = new Label("+4 drink,+22 happiness, -8 Health, price = "+getItem4Price());
        Button item4Button = new Button("coke");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.customerMenu(avatar);

        });
        item1Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem1Price())){
                avatar.setDrink(avatar.getDrink()+5);

            }
        });
        item2Button.setOnAction(e->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem2Price())){
                avatar.setFood(avatar.getFood()+1);
                avatar.setDrink(avatar.getDrink()+3);
                avatar.setHealth(avatar.getHealth()+1);
            }
        });
        item3Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+1);
                avatar.setFood(avatar.getFood()+1);
                avatar.setHealth(avatar.getHealth()-1);
            }
        });
        item4Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+10);
                avatar.setDrink(avatar.getDrink()+4);
                avatar.setHealth(avatar.getHealth()-4);
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
