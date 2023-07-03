import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Entertainment extends Shop {
    public Entertainment(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);

    }

    public Entertainment(String name, long income, long price, long salary, long ownerID,
                         long ID, long cityID, int item1Price, int item2Price, int item3Price, int item4Price) {
        super(name, income, price, salary, ownerID, ID, cityID, item1Price, item2Price, item3Price, item4Price);

    }
    public void buyItem(Stage window,Avatar avatar){
        Label welcomeLabel = new Label("buy a ticket");
        Label cinemaLabel = new Label("+5 happiness,-2 food, price = "+getItem1Price());
        Button cinemaButton = new Button("Cinema");
        Label parkLabel = new Label("+6 happiness,-3 drink,+1 health, price = "+getItem2Price());
        Button parkButton = new Button("park");
        Label concertLabel = new Label("+8 happiness,price = "+getItem3Price());
        Button concertButton = new Button("concert");
        Label clubLabel = new Label("+20 happiness,+4 drink, -4 food, -3 Health, price = "+getItem4Price());
        Button clubButton = new Button("G-Club");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.customerMenu(avatar);

        });
        cinemaButton.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem1Price())){
                avatar.setFood(avatar.getFood()-2);
                avatar.setHappiness(avatar.getHappiness()+5);

            }
        });
        parkButton.setOnAction(e->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem2Price())){
                avatar.setHappiness(avatar.getHappiness()+6);
                avatar.setDrink(avatar.getDrink()-3);
                avatar.setHealth(avatar.getHealth()+1);
            }
        });
        concertButton.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+8);
            }
        });
        clubButton.setOnAction(e ->{
            if(Bank.checkMoney(avatar,this.getOwner(),getItem3Price())){
                avatar.setHappiness(avatar.getHappiness()+20);
                avatar.setDrink(avatar.getDrink()+4);
                avatar.setFood(avatar.getFood()-4);
                avatar.setHealth(avatar.getHealth()-3);
            }
        });
        if(this.getEmployees().size()<5){
            cinemaButton.setDisable(true);
        }
        if(this.getEmployees().size()<10){
            concertButton.setDisable(true);
        }
        if(this.getEmployees().size()<15){
            clubButton.setDisable(true);
        }


        GridPane layout = new GridPane();
        layout.add(welcomeLabel,0,0);
        layout.add(cinemaLabel,0,1);
        layout.add(parkLabel,0,2);
        layout.add(concertLabel,0,3);
        layout.add(clubLabel,0,4);
        layout.add(cinemaButton,1,1);
        layout.add(parkButton,1,2);
        layout.add(concertButton,1,3);
        layout.add(clubButton,1,4);
        layout.add(backButton,0,5);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        window.setScene(scene);

    }

}
