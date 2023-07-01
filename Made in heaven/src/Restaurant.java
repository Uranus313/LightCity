import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Restaurant extends Shop{
    public Restaurant(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }

    public Restaurant(String name, long income, long price, long salary, long ownerID,
                      long ID, long cityID, int item1Price, int item2Price, int item3Price, int item4Price) {
        super(name, income, price, salary, ownerID, ID, cityID, item1Price, item2Price, item3Price, item4Price);
    }
    public void buyItem(Stage window, Avatar avatar){
        Label welcomeLabel = new Label("buy something");
        Label item1Label = new Label("+3 food,+1 happiness,  price = "+getItem1Price());
        Button item1Button = new Button("Hamburgur");
        Label item2Label = new Label("+4 food,+2 happiness, price = "+getItem2Price());
        Button item2Button = new Button("pizza");
        Label item3Label = new Label("+10 food,+1 happiness ,price = "+getItem3Price());
        Button item3Button = new Button("ghorme sabzi");
        Label item4Label = new Label("+8 food,+5 happiness, price = "+getItem4Price());
        Button item4Button = new Button("chelo koobide");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.customerMenu(avatar);

        });
        item1Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem1Price())){
                avatar.setFood(avatar.getFood()+3);
                avatar.setHappiness(avatar.getHappiness()+1);

            }
        });
        item2Button.setOnAction(e->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem2Price())){
                avatar.setFood(avatar.getFood()+4);
                avatar.setHappiness(avatar.getHappiness()+2);
            }
        });
        item3Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+1);
                avatar.setFood(avatar.getFood()+10);
            }
        });
        item4Button.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+5);
                avatar.setFood(avatar.getFood()+8);
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

