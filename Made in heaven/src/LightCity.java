import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class LightCity {
    private String name;
    private String passWord;
    private long ID;
    private static long IDCreator=1;
    private ArrayList<Block> blocks;
    private ArrayList<User> users;
    private ArrayList<Avatar> avatars;
    private long blockPrice=500;
    private long bankPrice=1000;
    private long superMarketPrice=500;
    private long drugStorePrice=500;
    private long entertainmentPrice=500;
    private long restaurantPrice=500;
    private long casinoPrice=500;
    private long factoryPrice=500;
    private long bankIncome=50;
    private long superMarketIncome=50;
    private long drugStoreIncome=50;
    private long entertainmentIncome=50;
    private long restaurantIncome=50;
    private long casinoIncome=50;
    private long factoryIncome=50;
    private long dayNumber=0;
    private Timestamp startTime;
    Label infoLabel;

    Button[] buttons = new Button[48];
    public LightCity(String name, String passWord) {

        this.name = name;
        this.passWord = passWord;
        blocks= new ArrayList<>();
        users= new ArrayList<>();
        avatars = new ArrayList<>();

        this.ID=IDCreator;
        System.out.println(ID);
        for(int i=0;i<48;i++){
            Block block = new Block("block "+i,blockPrice,this.getID());
            this.getBlocks().add(block);
            Database.insertData(block);
        }
        IDCreator++;
        startTime = new Timestamp(new Date().getTime());
    }


    public LightCity(String name, String passWord, long ID, long blockPrice, long bankPrice,
                     long superMarketPrice, long drugStorePrice, long entertainmentPrice, long restaurantPrice,
                     long casinoPrice, long factoryPrice, long bankIncome, long superMarketIncome,
                     long drugStoreIncome, long entertainmentIncome, long restaurantIncome,
                     long casinoIncome, long factoryIncome, long dayNumber, Timestamp startTime) {
        this.name = name;
        this.passWord = passWord;
        this.ID = ID;
        this.blockPrice = blockPrice;
        this.bankPrice = bankPrice;
        this.superMarketPrice = superMarketPrice;
        this.drugStorePrice = drugStorePrice;
        this.entertainmentPrice = entertainmentPrice;
        this.restaurantPrice = restaurantPrice;
        this.casinoPrice = casinoPrice;
        this.factoryPrice = factoryPrice;
        this.bankIncome = bankIncome;
        this.superMarketIncome = superMarketIncome;
        this.drugStoreIncome = drugStoreIncome;
        this.entertainmentIncome = entertainmentIncome;
        this.restaurantIncome = restaurantIncome;
        this.casinoIncome = casinoIncome;
        this.factoryIncome = factoryIncome;
        this.dayNumber = dayNumber;
        this.startTime = startTime;
        blocks= new ArrayList<>();
        users= new ArrayList<>();
        avatars = new ArrayList<>();
        for(int i=0;i<48;i++){
            for(Block block : Heaven.getBlocks()){
                if(block.getCityID()==this.getID() && block.getID()==i){
                    System.out.println(block.getID());
                    this.getBlocks().add(block);
                }
            }
        }
        for(Avatar avatar : Heaven.getAvatars()){
            if(avatar.getCity()==this){
                this.getAvatars().add(avatar);
            }
        }
    }

    public LightCity(String name, String passWord, long blockPrice, long bankPrice, long superMarketPrice,
                     long drugStorePrice, long entertainmentPrice, long restaurantPrice, long casinoPrice,
                     long factoryPrice, long bankIncome, long superMarketIncome, long drugStoreIncome,
                     long entertainmentIncome, long restaurantIncome, long casinoIncome, long factoryIncome) {
        this.name = name;
        this.passWord = passWord;
        this.blockPrice = blockPrice;
        this.bankPrice = bankPrice;
        this.superMarketPrice = superMarketPrice;
        this.drugStorePrice = drugStorePrice;
        this.entertainmentPrice = entertainmentPrice;
        this.restaurantPrice = restaurantPrice;
        this.casinoPrice = casinoPrice;
        this.factoryPrice = factoryPrice;
        this.bankIncome = bankIncome;
        this.superMarketIncome = superMarketIncome;
        this.drugStoreIncome = drugStoreIncome;
        this.entertainmentIncome = entertainmentIncome;
        this.restaurantIncome = restaurantIncome;
        this.casinoIncome = casinoIncome;
        this.factoryIncome = factoryIncome;
        this.ID=IDCreator;
        IDCreator++;
        startTime = new Timestamp(new Date().getTime());
        for(int i=0;i<48;i++){
            Block block = new Block("block "+i,blockPrice,this.getID());
            this.getBlocks().add(block);
            Database.insertData(block);
        }
        blocks= new ArrayList<>();
        users= new ArrayList<>();
        avatars = new ArrayList<>();
    }
    public void reload(Avatar avatar){
        timeSkip();
        Database.deleteData("avatar",avatar.getID(),this.getID());
        Database.insertData(avatar);
        System.out.println(blocks.get(0).getOwnerID());
        System.out.println(avatar.getID());
            for (int i = 0; i < 48; i++) {
                final int j = i;
                Block block1 = this.getBlocks().get(j);
                ImageView imageView = new ImageView(Heaven.blockImage);
                buttons[i].setGraphic(imageView);
                if (block1.getClass() == Bank.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == Casino.class) {
                    ImageView imageView1 = new ImageView(Heaven.casinoImage);

                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == DrugStore.class) {
                    ImageView imageView1 = new ImageView(Heaven.drugStoreImage);

                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == Factory.class) {
                    ImageView imageView1 = new ImageView(Heaven.factoryImage);

                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == Restaurant.class) {
                    ImageView imageView1 = new ImageView(Heaven.restaurantImage);

                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == SuperMarket.class) {
                    ImageView imageView1 = new ImageView(Heaven.superMarketImage);

                    buttons[i].setGraphic(imageView1);
                }else
                if (block1.getClass() == Entertainment.class) {
                    ImageView imageView1 = new ImageView(Heaven.entertainmentImage);
                    buttons[i].setGraphic(imageView1);
                }else {
                    Database.deleteData("block",block1.getID(),this.getID());
                    Database.insertData(block1);
                }


                buttons[i].setOnAction(e -> {
                    Block block = this.getBlocks().get(j);
                    if (block.getClass() == Bank.class) {
                        block = (Bank) block;
                    }
                    if (block.getClass() == Casino.class) {
                        block = (Casino) block;
                        Database.deleteData("casino",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (block.getClass() == DrugStore.class) {
                        block = (DrugStore) block;
                        Database.deleteData("drugstore",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (block.getClass() == Factory.class) {
                        block = (Factory) block;
                        Database.deleteData("factory",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (block.getClass() == Restaurant.class) {
                        block = (Restaurant) block;
                        Database.deleteData("restaurant",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (block.getClass() == SuperMarket.class) {
                        block = (SuperMarket) block;
                        Database.deleteData("supermarket",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (block.getClass() == Entertainment.class) {
                        block = (Entertainment) block;

                        Database.deleteData("entertainment",block.getID(),this.getID());
                        Database.insertData(block);
                    }
                    if (avatar.getID() == block.getOwnerID()) {
                        block.OwnerMenu(avatar);
                    } else {
                        System.out.println(1);
                        block.customerMenu(avatar);
                    }
                });

            }
        ImageView imageView1 = new ImageView(Heaven.bankImage);
        buttons[20].setGraphic(imageView1);

        infoLabel.setText("health = "+avatar.getHealth()+" food = "+avatar.getFood()+" drink = "+avatar.getDrink()+" happiness = "+avatar.getHappiness()+" money = "+avatar.getMoney());


    }

    public void menu(Stage window,Avatar avatar){
        timeSkip();
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        if(avatar.getAlive()) {
            for (int i = 0; i < 48; i++) {
                final int j = i;

                buttons[i] = new Button();
                buttons[i].setMinHeight(50);
                Block block1 = this.getBlocks().get(j);
                ImageView imageView = new ImageView(Heaven.blockImage);
                buttons[i].setGraphic(imageView);
                if (block1.getClass() == Bank.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == Casino.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == DrugStore.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == Factory.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == Restaurant.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == SuperMarket.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }
                if (block1.getClass() == Entertainment.class) {
                    ImageView imageView1 = new ImageView(Heaven.bankImage);
                    buttons[i].setGraphic(imageView1);
                }


                buttons[i].setOnAction(e -> {
                    Block block = this.getBlocks().get(j);
                    if (block.getClass() == Bank.class) {
                        block = (Bank) block;
                    }
                    if (block.getClass() == Casino.class) {
                        block = (Casino) block;
                    }
                    if (block.getClass() == DrugStore.class) {
                        block = (DrugStore) block;
                    }
                    if (block.getClass() == Factory.class) {
                        block = (Factory) block;
                    }
                    if (block.getClass() == Restaurant.class) {
                        block = (Restaurant) block;
                    }
                    if (block.getClass() == SuperMarket.class) {
                        block = (SuperMarket) block;
                    }
                    if (block.getClass() == Entertainment.class) {
                        block = (Entertainment) block;
                    }
                    if (avatar.getID() == block.getOwnerID()) {
                        block.OwnerMenu(avatar);
                    } else {
                        System.out.println(1);
                        block.customerMenu(avatar);
                    }
                });

            }
            ImageView imageView1 = new ImageView(Heaven.bankImage);
            buttons[20].setGraphic(imageView1);

            int i = 0;

            layout.add(buttons[i++], 0, 0);
            layout.add(buttons[i++], 7, 0);
            layout.add(buttons[i++], 14, 0);
            layout.add(buttons[i++], 2, 2);
            layout.add(buttons[i++], 6, 2);
            layout.add(buttons[i++], 8, 2);
            layout.add(buttons[i++], 12, 2);
            layout.add(buttons[i++], 3, 3);
            layout.add(buttons[i++], 5, 3);
            layout.add(buttons[i++], 9, 3);
            layout.add(buttons[i++], 11, 3);
            layout.add(buttons[i++], 4, 4);
            layout.add(buttons[i++], 10, 4);
            layout.add(buttons[i++], 3, 5);
            layout.add(buttons[i++], 6, 5);
            layout.add(buttons[i++], 8, 5);
            layout.add(buttons[i++], 11, 5);
            layout.add(buttons[i++], 2, 6);
            layout.add(buttons[i++], 5, 6);
            layout.add(buttons[i++], 7, 6);
            layout.add(buttons[i++], 9, 6);
            layout.add(buttons[i++], 12, 6);
            layout.add(buttons[i++], 0, 7);
            layout.add(buttons[i++], 6, 7);
            layout.add(buttons[i++], 8, 7);
            layout.add(buttons[i++], 14, 7);
            layout.add(buttons[i++], 2, 8);
            layout.add(buttons[i++], 5, 8);
            layout.add(buttons[i++], 7, 8);
            layout.add(buttons[i++], 9, 8);
            layout.add(buttons[i++], 12, 8);
            layout.add(buttons[i++], 3, 9);
            layout.add(buttons[i++], 6, 9);
            layout.add(buttons[i++], 8, 9);
            layout.add(buttons[i++], 11, 9);
            layout.add(buttons[i++], 4, 10);
            layout.add(buttons[i++], 10, 10);
            layout.add(buttons[i++], 3, 11);
            layout.add(buttons[i++], 5, 11);
            layout.add(buttons[i++], 9, 11);
            layout.add(buttons[i++], 11, 11);
            layout.add(buttons[i++], 2, 12);
            layout.add(buttons[i++], 6, 12);
            layout.add(buttons[i++], 8, 12);
            layout.add(buttons[i++], 12, 12);
            layout.add(buttons[i++], 0, 14);
            layout.add(buttons[i++], 7, 14);
            layout.add(buttons[i++], 14, 14);
        }else{
            Label deathLabel = new Label("YOU ARE DEAD");
            layout.add(deathLabel,0,0);
        }
        layout.setHgap(3);
        layout.setVgap(3);

        VBox vBox= new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(5);
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        hBox1.setAlignment(Pos.TOP_LEFT);
        hBox2.setAlignment(Pos.TOP_RIGHT);
        hBox.getChildren().addAll(hBox1,hBox2);
        hBox.setStyle("-fx-background-color : blue; -fx-font-size:14;");
         infoLabel = new Label("health = "+avatar.getHealth()+" food = "+avatar.getFood()+" drink = "+avatar.getDrink()+" happiness = "+avatar.getHappiness()+" money = "+avatar.getMoney());
        hBox1.getChildren().add(infoLabel);
        Button backButton = new Button("Back");
        backButton.setOnAction(e ->Heaven.menu(window));
        hBox2.getChildren().add(backButton);

        hBox.setSpacing(850);
        vBox.getChildren().addAll(hBox,layout);
        Scene scene = new Scene(vBox);
        layout.getStylesheets().add(getClass().getResource("Test.css").toExternalForm());
        Image img = new Image("C:\\Users\\Hico\\IdeaProjects\\Made in heaven\\2527739.jpg");
        BackgroundImage bi = new BackgroundImage(img, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background back = new Background(bi);
        layout.setBackground(back);

        window.setScene(scene);




    }
    public static void timeSkip(){
            for(LightCity city : Heaven.getCities()){
                long dayDiff = city.dayCounter()-city.dayNumber;
                city.dayNumber = city.dayCounter();
                while(dayDiff>=8){
                    dayDiff-=8;
                    city.timeJustSkipped();

                }

            }
    }
    public void timeJustSkipped(){
        for(Avatar avatar: this.getAvatars()){
            if(avatar.getEmployed()){
                avatar.setMoney(avatar.getMoney()+avatar.getEmployer().getSalary());
                avatar.getEmployer().getOwner().setMoney(avatar.getEmployer().getOwner().getMoney()-avatar.getEmployer().getSalary());
            }
            avatar.setDrink(avatar.getDrink()-10);
            avatar.setFood(avatar.getFood()-5);
            avatar.setHealth(avatar.getHealth()-2);
            if(avatar.getEmployed()){
                avatar.setHappiness(avatar.getHappiness()-6);
            }else{
                avatar.setHappiness(avatar.getHappiness()-2);
            }
            if(avatar.getDrink()<1){
                avatar.setHealth(avatar.getHealth()-10);
            }
            if (avatar.getFood()<1){
                avatar.setHealth(avatar.getHealth()-5);
            }
            avatar.checkDeath();
        }
        for(Block block : this.getBlocks()){
            try {
                block.getOwner().setMoney(block.getIncome());

            }catch (Exception e){

            }
        }
    }
    public long dayCounter(){
        return ((new Timestamp(new Date().getTime()).getTime()-this.getStartTime().getTime())/(60*60*1000));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
        LightCity.IDCreator = IDCreator;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Avatar> getAvatars() {
        return avatars;
    }

    public void setAvatars(ArrayList<Avatar> avatars) {
        this.avatars = avatars;
    }

    public long getBlockPrice() {
        return blockPrice;
    }

    public void setBlockPrice(long blockPrice) {
        this.blockPrice = blockPrice;
    }

    public long getBankPrice() {
        return bankPrice;
    }

    public void setBankPrice(long bankPrice) {
        this.bankPrice = bankPrice;
    }

    public long getSuperMarketPrice() {
        return superMarketPrice;
    }

    public void setSuperMarketPrice(long superMarketPrice) {
        this.superMarketPrice = superMarketPrice;
    }

    public long getDrugStorePrice() {
        return drugStorePrice;
    }

    public void setDrugStorePrice(long drugStorePrice) {
        this.drugStorePrice = drugStorePrice;
    }

    public long getEntertainmentPrice() {
        return entertainmentPrice;
    }

    public void setEntertainmentPrice(long entertainmentPrice) {
        this.entertainmentPrice = entertainmentPrice;
    }

    public long getRestaurantPrice() {
        return restaurantPrice;
    }

    public void setRestaurantPrice(long restaurantPrice) {
        this.restaurantPrice = restaurantPrice;
    }

    public long getCasinoPrice() {
        return casinoPrice;
    }

    public void setCasinoPrice(long casinoPrice) {
        this.casinoPrice = casinoPrice;
    }

    public long getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(long factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public long getBankIncome() {
        return bankIncome;
    }

    public void setBankIncome(long bankIncome) {
        this.bankIncome = bankIncome;
    }

    public long getSuperMarketIncome() {
        return superMarketIncome;
    }

    public void setSuperMarketIncome(long superMarketIncome) {
        this.superMarketIncome = superMarketIncome;
    }

    public long getDrugStoreIncome() {
        return drugStoreIncome;
    }

    public void setDrugStoreIncome(long drugStoreIncome) {
        this.drugStoreIncome = drugStoreIncome;
    }

    public long getEntertainmentIncome() {
        return entertainmentIncome;
    }

    public void setEntertainmentIncome(long entertainmentIncome) {
        this.entertainmentIncome = entertainmentIncome;
    }

    public long getRestaurantIncome() {
        return restaurantIncome;
    }

    public void setRestaurantIncome(long restaurantIncome) {
        this.restaurantIncome = restaurantIncome;
    }

    public long getCasinoIncome() {
        return casinoIncome;
    }

    public void setCasinoIncome(long casinoIncome) {
        this.casinoIncome = casinoIncome;
    }

    public long getFactoryIncome() {
        return factoryIncome;
    }

    public void setFactoryIncome(long factoryIncome) {
        this.factoryIncome = factoryIncome;
    }

    public long getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(long dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
