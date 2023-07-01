import java.util.ArrayList;

public class Avatar {
    private String name;
    private Boolean Alive= true;
    private Boolean employed= false;
    private long employerID=0;
    private long money=1000;
    private int health=80;
    private int happiness=80;
    private int food=100;
    private int drink=100;
    private int userID;
    private long ID;
    private static long IDCreator=1;
    private long cityID;
    private Gender gender;
    private Race race;


    public Avatar(String name, int userID,long cityID,Gender gender,Race race) {
        this.name = name;
        this.userID = userID;
        this.cityID= cityID;
        this.gender = gender;
        this.race = race;
        this.ID = IDCreator;
        IDCreator++;
    }

    public Avatar(String name, Boolean alive, Boolean employed, long employerID, long money,
                  int health, int happiness, int food, int drink, int userID, long ID,
                  long cityID, Gender gender, Race race) {
        this.name = name;
        Alive = alive;
        this.employed = employed;
        this.employerID = employerID;
        this.money = money;
        this.health = health;
        this.happiness = happiness;
        this.food = food;
        this.drink = drink;
        this.userID = userID;
        this.ID = ID;
        this.cityID = cityID;
        this.gender = gender;
        this.race = race;
    }

    public LightCity getCity(){
        for(LightCity city: Heaven.getCities()){
            if(city.getID()==this.getCityID()){
                return city;
            }
        }
        return null;
    }
    public Block getEmployer(){
        for(Block block: this.getCity().getBlocks()){
            if(block.getID()==this.getEmployerID()){
                return block;
            }
        }
        return null;
    }
    public ArrayList<Block> getAssets(){
        ArrayList<Block> assets = new ArrayList<>();
        for(Block block: this.getCity().getBlocks()) {
            if (block.getOwnerID() == this.getEmployerID()) {
                assets.add(block);
            }
        }
        return assets;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAlive() {
        return Alive;
    }

    public void setAlive(Boolean alive) {
        Alive = alive;
    }

    public Boolean getEmployed() {
        return employed;
    }

    public void setEmployed(Boolean employed) {
        this.employed = employed;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public long getID() {
        return ID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public static long getIDCreator() {
        return IDCreator;
    }

    public static void setIDCreator(long IDCreator) {
        Avatar.IDCreator = IDCreator;
    }

    public long getEmployerID() {
        return employerID;
    }

    public void setEmployerID(long employerID) {
        this.employerID = employerID;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }
}
