import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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


    public LightCity(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
        blocks= new ArrayList<>();
        users= new ArrayList<>();
        avatars = new ArrayList<>();
        this.ID=IDCreator;
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


    }

    public void menu(Stage window,Avatar avatar){
        Button[] buttons = new Button[48];
        for(int i =0;i<48;i++){
            final int j = i;
            buttons[i]= new Button("button "+i);
            buttons[i].setMinHeight(50);
            Block block1 = this.getBlocks().get(j);

            if(block1.getClass()==Bank.class){
            }
            if(block1.getClass()==Casino.class){
            }
            if(block1.getClass()==DrugStore.class){
            }
            if(block1.getClass()==Factory.class){
            }
            if(block1.getClass()==Restaurant.class){
            }
            if(block1.getClass()==SuperMarket.class){
            }
            if(block1.getClass()==Entertainment.class){
            }

                buttons[i].setOnAction(e ->{
                    Block block = this.getBlocks().get(j);
                    if(block.getClass()==Bank.class){
                        block = (Bank)block;
                    }
                    if(block.getClass()==Casino.class){
                        block = (Casino)block;
                    }
                    if(block.getClass()==DrugStore.class){
                        block = (DrugStore)block;
                    }
                    if(block.getClass()==Factory.class){
                        block = (Factory)block;
                    }
                    if(block.getClass()==Restaurant.class){
                        block = (Restaurant)block;
                    }
                    if(block.getClass()==SuperMarket.class){
                        block = (SuperMarket)block;
                    }
                    if(block.getClass()==Entertainment.class){
                        block = (Entertainment)block;
                    }
                    if(avatar.getUserID()==block.getOwnerID()){
                        block.OwnerMenu(avatar);
                    }else{
                        block.customerMenu(avatar);
                    }
                });

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
        Scene scene = new Scene(layout);
        window.setScene(scene);



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
