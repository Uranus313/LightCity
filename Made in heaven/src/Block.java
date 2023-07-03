import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class Block {
    private String name;
    private long income;
    private long price;
    private long ownerID=0;
    private long ID;
    private static long IDCreator=1;
    private long cityID;
    private long salary=0;
    public Block(String name, long income, long price,long salary , long ownerID,long ID,long cityID) {
        this.name = name;
        this.income = income;
        this.price = price;
        this.ownerID = ownerID;
        this.salary=salary;
        this.ID=ID;
        this.cityID= cityID;
    }

    public Block(String name, long price,long cityID) {
        this.name = name;
        this.price = price;
        this.cityID=cityID;
        this.ID = IDCreator;
        IDCreator++;
        if (IDCreator==48){
            IDCreator=0;
        }
    }
    public LightCity getCity(){
        for(LightCity city: Heaven.getCities()){
            if(city.getID()==this.getCityID()){
                return city;
            }
        }
        return null;
    }
    public ArrayList<Avatar> getEmployees(){
        ArrayList<Avatar> employees = new ArrayList<>();
        for(Avatar avatar : this.getCity().getAvatars()){
            if(avatar.getEmployerID()==this.getID()){
                employees.add(avatar);
            }
        }
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getOwnerID() {
        return ownerID;
    }
    public Avatar getOwner(){
        for(Avatar avatar: getCity().getAvatars()){
            if(avatar.getID()==this.getOwnerID()){
                return avatar;
            }
        }
        return null;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public static long getIDCreator() {
        return IDCreator;
    }

    public static void setIDCreator(long IDCreator) {
        Block.IDCreator = IDCreator;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void customerMenu(Avatar avatar){
        Stage window = new Stage();
        Label welcomeLabel = new Label("welcome to "+ this.name);
        Button buyButton = new Button("buy this property");
        buyButton.setOnAction(e ->this.buyProperty(window,avatar));
        Button getInfoButton = new Button("property info");
        getInfoButton.setOnAction(e-> propertyInfo(window,avatar));
        Button joinButton = new Button("join this company");
        if(this.getClass()==Block.class){
            joinButton.setOnAction(e -> AlertBox.display("cant","you cant join an empty block"));
        }else {
            joinButton.setOnAction(e -> join(avatar));
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(welcomeLabel,getInfoButton,buyButton,joinButton);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(e -> this.getCity().reload(avatar));

    }
    public void OwnerMenu(Avatar avatar){
        Stage window = new Stage();
        Label welcomeLabel = new Label("welcome to "+ this.name);
        Button getInfoButton = new Button("property info");
        getInfoButton.setOnAction(e-> propertyInfo2(window,avatar));
        Button changeInfoButton = new Button("change property details");
        changeInfoButton.setOnAction(e -> this.changeInfo(window,avatar));
        Button upgradeButton = new Button("upgrade property");
        upgradeButton.setOnAction(e -> upgradeProperty(window,avatar));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> window.close());
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.getChildren().addAll(welcomeLabel,getInfoButton,changeInfoButton,upgradeButton);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(e -> this.getCity().reload(avatar));


    }
    public void propertyInfo(Stage window,Avatar avatar){
        Label welcomeLabel = new Label("Property Info");
        Label nameLabel = new Label("name :");
        Label priceLabel = new Label("price :");
        Label baseIncomeLabel = new Label("base income :");
        Label employeeCountLabel = new Label("employee count :");
        Label ownerLabel = new Label("owner :");
        Label currentName = new Label(this.getName());
        Label currentPrice = new Label(Long.toString(this.getPrice()));
        Label currentBaseIncome = new Label(Long.toString(this.getIncome()));
        Label currentEmployeeCount = new Label(Long.toString(this.getEmployees().size()));
        Label currentOwner = new Label("free");
        if(this.getOwner()!=null) {
            currentOwner.setText(this.getOwner().getName());
        }
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.customerMenu(avatar);
        });
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.add(welcomeLabel,0,0);
        layout.add(nameLabel,0,1);
        layout.add(priceLabel,0,2);
        layout.add(baseIncomeLabel,0,3);
        layout.add(employeeCountLabel,0,4);
        layout.add(ownerLabel,0,5);
        layout.add(currentName,1,1);
        layout.add(currentPrice,1,2);
        layout.add(currentBaseIncome,1,3);
        layout.add(currentEmployeeCount,1,4);
        layout.add(currentOwner,1,5);
        layout.add(backButton,0,6);
        Scene scene= new Scene(layout);
        window.setScene(scene);



    }
    public void propertyInfo2(Stage window,Avatar avatar){
        Label welcomeLabel = new Label("Property Info");
        Label nameLabel = new Label("name :");
        Label priceLabel = new Label("price :");
        Label baseIncomeLabel = new Label("base income :");
        Label employeeCountLabel = new Label("employee count :");
        Label ownerLabel = new Label("owner :");
        Label currentName = new Label(this.getName());
        Label currentPrice = new Label(Long.toString(this.getPrice()));
        Label currentBaseIncome = new Label(Long.toString(this.getIncome()));
        Label currentEmployeeCount = new Label(Long.toString(this.getEmployees().size()));
        Label currentOwner = new Label("free");
        if(this.getOwner()!=null) {
            currentOwner.setText(this.getOwner().getName());
        }
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.OwnerMenu(avatar);
        });
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.add(welcomeLabel,0,0);
        layout.add(nameLabel,0,1);
        layout.add(priceLabel,0,2);
        layout.add(baseIncomeLabel,0,3);
        layout.add(employeeCountLabel,0,4);
        layout.add(ownerLabel,0,5);
        layout.add(currentName,1,1);
        layout.add(currentPrice,1,2);
        layout.add(currentBaseIncome,1,3);
        layout.add(currentEmployeeCount,1,4);
        layout.add(currentOwner,1,5);
        layout.add(backButton,0,6);
        Scene scene= new Scene(layout);
        window.setScene(scene);



    }
    public void upgradeProperty(Stage window,Avatar avatar){
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("upgrade property");
        Label priceLabel = new Label("price");
        Label incomeLabel = new Label("base income");
        Label casinoLabel = new Label("casino :");
        Label drugStoreLabel = new Label("drug store :");
        Label entertainmentLabel = new Label("entertainment center :");
        Label factoryLabel = new Label("factory :");
        Label restaurantLabel = new Label("restaurant :");
        Label superMarketLabel = new Label("super market :");
        Label casinoPrice = new Label(Long.toString(this.getCity().getCasinoPrice()));
        Label drugStorePrice = new Label(Long.toString(this.getCity().getDrugStorePrice()));
        Label entertainmentPrice = new Label(Long.toString(this.getCity().getEntertainmentPrice()));
        Label factoryPrice = new Label(Long.toString(this.getCity().getFactoryPrice()));
        Label restaurantPrice = new Label(Long.toString(this.getCity().getRestaurantPrice()));
        Label superMarketPrice = new Label(Long.toString(this.getCity().getSuperMarketPrice()));
        Label casinoIncome = new Label(Long.toString(this.getCity().getCasinoIncome()));
        Label drugStoreIncome = new Label(Long.toString(this.getCity().getDrugStoreIncome()));
        Label entertainmentIncome = new Label(Long.toString(this.getCity().getEntertainmentIncome()));
        Label factoryIncome = new Label(Long.toString(this.getCity().getFactoryIncome()));
        Label restaurantIncome = new Label(Long.toString(this.getCity().getRestaurantIncome()));
        Label superMarketIncome = new Label(Long.toString(this.getCity().getSuperMarketIncome()));
        Button casinoButton = new Button("Build casino");
        casinoButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getCasinoPrice())){
                Casino newBorn = new Casino(this.getName(),this.getCity().getCasinoIncome(),this.getCity().getCasinoPrice(),this.getSalary(),this.getOwnerID(),this.getID(),this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);
                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button drugStoreButton = new Button("Build drugStore");
        drugStoreButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getDrugStorePrice())){
                DrugStore newBorn = new DrugStore(this.getName(),this.getCity().getDrugStoreIncome(),this.getCity().getDrugStorePrice(),this.getSalary(),this.getOwnerID(),this.getID(),this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);
                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button entertainmentButton = new Button("Build entertainment center");
        entertainmentButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getEntertainmentPrice())){
                Entertainment newBorn = new Entertainment(this.getName(),this.getCity().getEntertainmentIncome(),this.getCity().getEntertainmentPrice(),this.getSalary(),this.getOwnerID(),this.getID()-1,this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);

                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button factoryButton = new Button("Build factory");
        factoryButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getFactoryPrice())){
                Factory newBorn = new Factory(this.getName(),this.getCity().getFactoryIncome(), this.getCity().getFactoryPrice(),this.getSalary(),this.getOwnerID(),this.getID(),this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);
                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button restaurantButton = new Button("Build restaurant");
        restaurantButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getRestaurantPrice())){
                Restaurant newBorn = new Restaurant(this.getName(),this.getCity().getRestaurantIncome(),this.getCity().getRestaurantPrice(),this.getSalary(),this.getOwnerID(),this.getID(),this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);
                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button superMarketButton = new Button("Build super market");
        superMarketButton.setOnAction(e -> {
            if(Bank.checkMoney(avatar,null,this.getCity().getSuperMarketPrice())){
                SuperMarket newBorn = new SuperMarket(this.getName(),this.getCity().getSuperMarketIncome(),this.getCity().getSuperMarketPrice(),this.getSalary(),this.getOwnerID(),this.getID(),this.getCityID());
                this.getCity().getBlocks().remove((int)this.getID()-1);
                this.getCity().getBlocks().add((int)this.getID()-1,newBorn);
                Database.deleteData("block",this.getID(),this.getCityID());
                Database.insertData(newBorn);
                newBorn.OwnerMenu(avatar);
                window.close();
            }
        });
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.OwnerMenu(avatar);
        });
        layout.add(welcomeLabel,0,0);
        layout.add(priceLabel,1,1);
        layout.add(incomeLabel,2,1);
        layout.add(casinoLabel,0,2);
        layout.add(drugStoreLabel,0,3);
        layout.add(entertainmentLabel,0,4);
        layout.add(factoryLabel,0,5);
        layout.add(restaurantLabel,0,6);
        layout.add(superMarketLabel,0,7);
        layout.add(casinoPrice,1,2);
        layout.add(drugStorePrice,1,3);
        layout.add(entertainmentPrice,1,4);
        layout.add(factoryPrice,1,5);
        layout.add(restaurantPrice,1,6);
        layout.add(superMarketPrice,1,7);
        layout.add(casinoIncome,2,2);
        layout.add(drugStoreIncome,2,3);
        layout.add(entertainmentIncome,2,4);
        layout.add(factoryIncome,2,5);
        layout.add(restaurantIncome,2,6);
        layout.add(superMarketIncome,2,7);
        layout.add(casinoButton,3,2);
        layout.add(drugStoreButton,3,3);
        layout.add(entertainmentButton,3,4);
        layout.add(factoryButton,3,5);
        layout.add(restaurantButton,3,6);
        layout.add(superMarketButton,3,7);
        layout.add(backButton,0,8);
        Scene scene = new Scene(layout);
        window.setScene(scene);





    }
    public void buyProperty(Stage window,Avatar avatar){
        if(this.getPrice()==0){
            AlertBox.display("unbuyable","this property isn't for sale");
            return;
        }
        if(avatar.getMoney()>=this.getPrice()){
            try{
                avatar.setMoney(avatar.getMoney()-this.getPrice());
                this.getOwner().setMoney(this.getOwner().getMoney()+this.getPrice());
                System.out.println(5);
                this.setOwnerID(avatar.getID());
                System.out.println(6);
                AlertBox.display("success","this property is yours");
                this.OwnerMenu(avatar);
                window.close();
                return;
            }catch (Exception e){
                System.out.println(5);
                this.setOwnerID(avatar.getID());
                System.out.println(6);
                AlertBox.display("success","this property is yours");
                this.OwnerMenu(avatar);
                window.close();
                return;
            }
        }
        AlertBox.display("fail","you dont have enough money to buy this property");
    }
    public void changeInfo(Stage window, Avatar avatar){
        TextField nameField = new TextField();
        nameField.setPromptText(this.getName());
        TextField priceField = new TextField();
        priceField.setPromptText( Long.toString(this.getPrice()));
        TextField salaryField = new TextField();
        salaryField.setPromptText(Long.toString(this.getSalary()));
        Label welcomeLabel = new Label("change property info");
        Label nameLabel = new Label("name :");
        Label priceLabel = new Label("sell price :");
        Label salaryLabel = new Label("salary :");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e ->{
            if(!nameField.getText().isEmpty() && !nameField.getText().equals(this.getName())){
                this.setName(nameField.getText());
                AlertBox.display("success","property's name has successfully changed");
            }
            try{
                if(!priceField.getText().isEmpty() && Long.parseLong(priceField.getText())!=this.getPrice()){
                    this.setPrice(Long.parseLong(priceField.getText()));
                    AlertBox.display("success","property's price has successfully changed\n" +
                            "enter 0 to make it unbuyable ");
                }

            }catch (Exception c){
                AlertBox.display("fail","property's price must be a number");
            }
            try{
                if(!salaryField.getText().isEmpty() && Long.parseLong(salaryField.getText())!=this.getSalary()){
                    this.setSalary(Long.parseLong(salaryField.getText()));
                    AlertBox.display("success","property's salary has successfully changed");
                }
            }catch (Exception c){
                AlertBox.display("fail","property's salary must be a number");
            }
        });
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.close();
            this.OwnerMenu(avatar);
        });
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.add(welcomeLabel,0,0);
        layout.add(nameLabel,0,1);
        layout.add(priceLabel,0,2);
        layout.add(salaryLabel,0,3);
        layout.add(nameField,1,1);
        layout.add(priceField,1,2);
        layout.add(salaryField,1,3);
        layout.add(backButton,0,4);
        layout.add(submitButton,1,4);
        Scene scene = new Scene(layout);
        window.setScene(scene);
    }
    public void join(Avatar avatar){
        if(avatar.getEmployed()){
            AlertBox.display("IMPOSSIBLE","you cant have 2 jobs at once");
        }else{
            avatar.setEmployerID(this.getID());
            avatar.setEmployed(true);
            AlertBox.display("employed","you successfully joined this corporation");
        }
    }



}
