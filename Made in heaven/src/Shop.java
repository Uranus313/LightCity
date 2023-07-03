import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Shop extends Block{
    private long Item1Price;
    private long Item2Price;
    private long Item3Price;
    private long Item4Price;
    public Shop(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }

    public Shop(String name, long income, long price, long salary, long ownerID, long ID, long cityID, int item1Price, int item2Price, int item3Price, int item4Price) {
        super(name, income, price, salary, ownerID, ID, cityID);
        Item1Price = item1Price;
        Item2Price = item2Price;
        Item3Price = item3Price;
        Item4Price = item4Price;
    }

    public long getItem1Price() {
        return Item1Price;
    }

    public void setItem1Price(long item1Price) {
        Item1Price = item1Price;
    }

    public long getItem2Price() {
        return Item2Price;
    }

    public void setItem2Price(long item2Price) {
        Item2Price = item2Price;
    }

    public long getItem3Price() {
        return Item3Price;
    }

    public void setItem3Price(long item3Price) {
        Item3Price = item3Price;
    }

    public long getItem4Price() {
        return Item4Price;
    }

    public void setItem4Price(long item4Price) {
        Item4Price = item4Price;
    }

    public void customerMenu(Avatar avatar){
        Stage window = new Stage();
        Label welcomeLabel = new Label("welcome to "+ this.getName());
        Button buyButton = new Button("buy this property");
        buyButton.setOnAction(e ->this.buyProperty(window,avatar));
        Button getInfoButton = new Button("property info");
        getInfoButton.setOnAction(e-> propertyInfo(window,avatar));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        Button buyItemButton = new Button("buy Items");
        buyItemButton.setOnAction(e -> buyItem(window,avatar));
        Button joinButton = new Button("join this company");
            joinButton.setOnAction(e -> join(avatar));
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(welcomeLabel,getInfoButton,buyItemButton,buyButton,joinButton);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(e -> this.getCity().reload(avatar));

    }
    public void OwnerMenu(Avatar avatar){
        Stage window = new Stage();
        Label welcomeLabel = new Label("welcome to "+ this.getName());
        Button getInfoButton = new Button("property info");
        getInfoButton.setOnAction(e-> propertyInfo(window,avatar));
        Button changeItemButton = new Button("change item prices");
        changeItemButton.setOnAction(e -> this.changeItemPrice(window,avatar));
        Button changeInfoButton = new Button("change property details");
        changeInfoButton.setOnAction(e -> this.changeInfo(window,avatar));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(welcomeLabel,getInfoButton,changeInfoButton,changeItemButton);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(e -> this.getCity().reload(avatar));

    }
    public void changeItemPrice(Stage window, Avatar avatar){
        TextField item1Field = new TextField();
        item1Field.setPromptText(Long.toString(this.getItem1Price()));
        TextField item2Field = new TextField();
        item2Field.setPromptText( Long.toString(this.getItem2Price()));
        TextField item3Field = new TextField();
        item3Field.setPromptText(Long.toString(this.getItem3Price()));
        TextField item4Field = new TextField();
        item4Field.setPromptText(Long.toString(this.getItem4Price()));
        Label welcomeLabel = new Label("change property info");
        Label item1Label = new Label("level 1 item price :");
        Label item2Label = new Label("level 2 item price :");
        Label item3Label = new Label("level 3 item price :");
        Label item4Label = new Label("level 4 item price :");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e ->{
            try{
                if(!item1Field.getText().isEmpty() && Long.parseLong(item1Field.getText())!=this.getPrice()){
                    this.setItem1Price(Long.parseLong(item1Field.getText()));
                    AlertBox.display("success","level 1 item's price has successfully changed\n" +
                            "enter 0 to make it unbuyable ");
                }

            }catch (Exception c){
                AlertBox.display("fail","item's price must be a number");
            }
            try{
                if(!item2Field.getText().isEmpty() && Long.parseLong(item2Field.getText())!=this.getPrice()){
                    this.setItem2Price(Long.parseLong(item2Field.getText()));
                    AlertBox.display("success","level 2 item's price has successfully changed\n" +
                            "enter 0 to make it unbuyable ");
                }

            }catch (Exception c){
                AlertBox.display("fail","item's price must be a number");
            }
            try{
                if(!item3Field.getText().isEmpty() && Long.parseLong(item3Field.getText())!=this.getPrice()){
                    this.setItem3Price(Long.parseLong(item3Field.getText()));
                    AlertBox.display("success","level 3 item's price has successfully changed\n" +
                            "enter 0 to make it unbuyable ");
                }

            }catch (Exception c){
                AlertBox.display("fail","item's price must be a number");
            }
            try{
                if(!item4Field.getText().isEmpty() && Long.parseLong(item4Field.getText())!=this.getPrice()){
                    this.setItem4Price(Long.parseLong(item4Field.getText()));
                    AlertBox.display("success","level 4 item's price has successfully changed\n" +
                            "enter 0 to make it unbuyable ");
                }

            }catch (Exception c){
                AlertBox.display("fail","item's price must be a number");
            }
        });
        Button backButton = new Button("Back");
        backButton.setOnAction(e ->{this.OwnerMenu(avatar);
        window.close();
        });
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.add(welcomeLabel,0,0);
        layout.add(item1Label,0,1);
        layout.add(item2Label,0,2);
        layout.add(item3Label,0,3);
        layout.add(item4Label,0,4);
        layout.add(item1Field,1,1);
        layout.add(item2Field,1,2);
        layout.add(item3Field,1,3);
        layout.add(item4Field,1,4);
        layout.add(backButton,0,5);
        layout.add(submitButton,1,5);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setOnCloseRequest(e -> this.getCity().reload(avatar));
    }
    public void buyItem(Stage window, Avatar avatar){}
}
