import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String url = "jdbc:mysql://localhost:3306/lightcity";
    private static final String user = "root";
    private static final String pass = "@Mm12345678";





    public static void pushChanges(String table, String label, String changer, int userId , long cityId) {
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = connection.prepareStatement("update " + table + " set "+ label +"=? where userId =? AND cityId =?");
            ps.setString(1,changer);
            ps.setInt(2, userId);
            ps.setLong(3, cityId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pushChanges(String table, String label, long changer, int userId , long cityId) {
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = connection.prepareStatement("update " + table + " set "+ label +"=? where userId =? AND cityId =?");
            ps.setLong(1,changer);
            ps.setInt(2, userId);
            ps.setLong(3, cityId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pushChanges(String table, String label, int changer, int userId , long cityId) {
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = connection.prepareStatement("update " + table + " set "+ label +"=? where userId =? AND cityId =?");
            ps.setInt(1,changer);
            ps.setInt(2, userId);
            ps.setLong(3, cityId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pushChanges(String table, String label, Boolean changer, int userId , long cityId) {
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = connection.prepareStatement("update " + table + " set "+ label +"=? where userId =? AND cityId =?");
            ps.setBoolean(1,changer);
            ps.setInt(2, userId);
            ps.setLong(3, cityId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteData(String table, long userId, long cityId) {

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " delete from " + table + " where id =? AND cityId =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, cityId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Avatar> popAvatars() {
        ArrayList<Avatar> avatars = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from avatar");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                boolean alive = resultSet.getBoolean(2);
                boolean employed = resultSet.getBoolean(3);
                long employerID = resultSet.getLong(4);
                long money = resultSet.getLong(5);
                int health = resultSet.getInt(6);
                int happiness = resultSet.getInt(7);
                int food = resultSet.getInt(8);
                int drink = resultSet.getInt(9);
                int userID = resultSet.getInt(10);
                long ID = resultSet.getLong(11);
                long cityID = resultSet.getLong(12);
                Gender gender = Gender.valueOf(resultSet.getString(13));
                Race race = Race.valueOf(resultSet.getString(14));

                avatars.add(new Avatar(name, alive, employed, employerID, money, health,
                        happiness, food, drink, userID, ID, cityID, gender, race));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatars;
    }

    public static ArrayList<LightCity> popLightCities() {
        ArrayList<LightCity> lightCities = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from lightcity");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String passWord = resultSet.getString(2);
                long ID = resultSet.getLong(3);
                long blockPrice = resultSet.getLong(4);
                long bankPrice = resultSet.getLong(5);
                long superMarketPrice = resultSet.getLong(6);
                long drugStorePrice = resultSet.getLong(7);
                long entertainmentPrice = resultSet.getLong(8);
                long restaurantPrice = resultSet.getLong(9);
                long casinoPrice = resultSet.getLong(10);
                long factoryPrice = resultSet.getLong(11);
                long bankIncome = resultSet.getLong(12);
                long supermarketIncome = resultSet.getLong(13);
                long drugStoreIncome = resultSet.getLong(14);
                long entertainmentIncome = resultSet.getLong(15);
                long restaurantIncome = resultSet.getLong(16);
                long casinoIncome = resultSet.getLong(17);
                long factoryIncome = resultSet.getLong(18);
                long dayNumber = resultSet.getLong(19);
                Timestamp startTime = resultSet.getTimestamp(20);

                lightCities.add(new LightCity(name, passWord, ID, blockPrice, bankPrice, superMarketPrice, drugStorePrice, entertainmentPrice,
                        restaurantPrice, casinoPrice, factoryPrice, bankIncome, supermarketIncome, drugStoreIncome, entertainmentIncome,
                        restaurantIncome, casinoIncome, factoryIncome, dayNumber, startTime));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lightCities;
    }

    public static ArrayList<Block> popBlocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from block");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);

                blocks.add(new Block(name, income, price, salary, ownerID, ID, cityID));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return blocks;
    }

    public static ArrayList<Factory> popFactories() {
        ArrayList<Factory> factories = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from factory");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);

                factories.add(new Factory(name, income, price, salary, ownerID, ID, cityID));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return factories;
    }

    public static ArrayList<Casino> popCasinos() {
        ArrayList<Casino> casinos = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from casino");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);

                casinos.add(new Casino(name, income, price, salary, ownerID, ID, cityID));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return casinos;
    }

    public static ArrayList<DrugStore> popDrugStores() {
        ArrayList<DrugStore> drugStores = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from drugstore");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);
                int item1price = resultSet.getInt(8);
                int item2price = resultSet.getInt(9);
                int item3price = resultSet.getInt(10);
                int item4price = resultSet.getInt(11);

                drugStores.add(new DrugStore(name, income, price, salary, ownerID, ID,
                        cityID, item1price, item2price, item3price , item4price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return drugStores;
    }

    public static ArrayList<Entertainment> popEntertainments() {
        ArrayList<Entertainment> entertainments = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from entertainment");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);
                int item1price = resultSet.getInt(8);
                int item2price = resultSet.getInt(9);
                int item3price = resultSet.getInt(10);
                int item4price = resultSet.getInt(11);

                entertainments.add(new Entertainment(name, income, price, salary, ownerID, ID,
                        cityID, item1price, item2price, item3price , item4price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entertainments;
    }


    public static ArrayList<Restaurant> popRestaurants() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from restaurant");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);
                int item1price = resultSet.getInt(8);
                int item2price = resultSet.getInt(9);
                int item3price = resultSet.getInt(10);
                int item4price = resultSet.getInt(11);

                restaurants.add(new Restaurant(name, income, price, salary, ownerID, ID,
                        cityID, item1price, item2price, item3price , item4price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public static ArrayList<SuperMarket> popSuperMarkets() {
        ArrayList<SuperMarket> superMarkets = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from supermarket");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                long income = resultSet.getLong(2);
                long price = resultSet.getLong(3);
                long salary = resultSet.getLong(4);
                long ownerID = resultSet.getLong(5);
                long ID = resultSet.getLong(6);
                long cityID = resultSet.getLong(7);
                int item1price = resultSet.getInt(8);
                int item2price = resultSet.getInt(9);
                int item3price = resultSet.getInt(10);
                int item4price = resultSet.getInt(11);

                superMarkets.add(new SuperMarket(name, income, price, salary, ownerID, ID,
                        cityID, item1price, item2price, item3price , item4price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return superMarkets;
    }

    public static ArrayList<User> popUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("select * from user");

            while (resultSet1.next()) {
                int ID = resultSet1.getInt(1);
                String username = resultSet1.getString(2);
                String password = Main.decode(resultSet1.getString(3));

                users.add(new User(ID, username, password));
            }

            List<Avatar> avatars = new ArrayList<>();

            for (User user_temp:users) {

                ResultSet resultSet = statement.executeQuery("select * from avatar where userId = " + user_temp.getID());
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    boolean alive = resultSet.getBoolean(2);
                    boolean employed = resultSet.getBoolean(3);
                    long employerID = resultSet.getLong(4);
                    long money = resultSet.getLong(5);
                    int health = resultSet.getInt(6);
                    int happiness = resultSet.getInt(7);
                    int food = resultSet.getInt(8);
                    int drink = resultSet.getInt(9);
                    int userID = resultSet.getInt(10);
                    long ID = resultSet.getLong(11);
                    long cityID = resultSet.getLong(12);
                    Gender gender = Gender.valueOf(resultSet.getString(13));
                    Race race = Race.valueOf(resultSet.getString(14));

                    for(LightCity city : Heaven.getCities()){
                        if(city.getID()==cityID) {
                            city.getAvatars().add(new Avatar(name, alive, employed, employerID, money, health,
                                    happiness, food, drink, userID, ID, cityID, gender, race));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }




    public static void insertData(Avatar avatar) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into avatar (name, alive, employed, employerId, money, health, happiness, food, drink, userId, id, cityId, gender, race)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, avatar.getName());
            ps.setBoolean(2, avatar.getAlive());
            ps.setBoolean(3, avatar.getEmployed());
            ps.setLong(4, avatar.getEmployerID());
            ps.setLong(5, avatar.getMoney());
            ps.setInt(6, avatar.getHealth());
            ps.setInt(7, avatar.getHappiness());
            ps.setInt(8, avatar.getFood());
            ps.setInt(9, avatar.getDrink());
            ps.setInt(10, avatar.getUserID());
            ps.setLong(11, avatar.getID());
            ps.setLong(12, avatar.getCityID());
            ps.setString(13, String.valueOf(avatar.getGender()));
            ps.setString(14, String.valueOf(avatar.getRace()));
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertData(Block block) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into block (name, income, price, salary, ownerId, id, cityId)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, block.getName());
            ps.setLong(2, block.getIncome());
            ps.setLong(3, block.getPrice());
            ps.setLong(4, block.getSalary());
            ps.setLong(5, block.getOwnerID());
            ps.setLong(6, block.getID());
            ps.setLong(7, block.getCityID());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertData(LightCity lightCity) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into lightcity (name, password, id, blockPrice, bankPrice, superMarketPrice, drugStorePrice," +
                    " entertainmentPrice , restaurantPrice, casinoPrice, factoryPrice, bankIncome, superMarketIncome, drugStoreIncome, " +
                    "entertainmentIncome,restaurantIncome, casinoIncome, factoryIncome, dayNumber, startTime)"
                    + " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, lightCity.getName());
            ps.setString(2, lightCity.getPassWord());
            ps.setLong(3, lightCity.getID());
            ps.setLong(4, lightCity.getBlockPrice());
            ps.setLong(5, lightCity.getBankPrice());
            ps.setLong(6, lightCity.getSuperMarketPrice());
            ps.setLong(7, lightCity.getDrugStorePrice());
            ps.setLong(8, lightCity.getEntertainmentPrice());
            ps.setLong(9, lightCity.getRestaurantPrice());
            ps.setLong(10, lightCity.getCasinoPrice());
            ps.setLong(11, lightCity.getFactoryPrice());
            ps.setLong(12, lightCity.getBankIncome());
            ps.setLong(13, lightCity.getSuperMarketIncome());
            ps.setLong(14, lightCity.getDrugStoreIncome());
            ps.setLong(15, lightCity.getEntertainmentIncome());
            ps.setLong(16, lightCity.getRestaurantIncome());
            ps.setLong(17, lightCity.getCasinoIncome());
            ps.setLong(18, lightCity.getFactoryIncome());
            ps.setLong(19, lightCity.getDayNumber());
            ps.setTimestamp(20, lightCity.getStartTime());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void insertData(Casino casino) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into casino (name, income, price, salary, ownerId, id, cityId, item1price, item2price, item3price, item4price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, casino.getName());
            ps.setLong(2, casino.getIncome());
            ps.setLong(3, casino.getPrice());
            ps.setLong(4, casino.getSalary());
            ps.setLong(5, casino.getOwnerID());
            ps.setLong(6, casino.getID());
            ps.setLong(7, casino.getCityID());
            ps.setLong(8, casino.getItem1Price());
            ps.setLong(9, casino.getItem2Price());
            ps.setLong(10, casino.getItem3Price());
            ps.setLong(11, casino.getItem4Price());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertData(DrugStore drugStore) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into drugstore (name, income, price, salary, ownerId, id, cityId, item1price, item2price, item3price, item4price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, drugStore.getName());
            ps.setLong(2, drugStore.getIncome());
            ps.setLong(3, drugStore.getPrice());
            ps.setLong(4, drugStore.getSalary());
            ps.setLong(5, drugStore.getOwnerID());
            ps.setLong(6, drugStore.getID());
            ps.setLong(7, drugStore.getCityID());
            ps.setLong(8, drugStore.getItem1Price());
            ps.setLong(9, drugStore.getItem2Price());
            ps.setLong(10, drugStore.getItem3Price());
            ps.setLong(11, drugStore.getItem4Price());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void insertData(Factory factory) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into factory (name, income, price, salary, ownerId, id, cityId)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, factory.getName());
            ps.setLong(2, factory.getIncome());
            ps.setLong(3, factory.getPrice());
            ps.setLong(4, factory.getSalary());
            ps.setLong(5, factory.getOwnerID());
            ps.setLong(6, factory.getID());
            ps.setLong(7, factory.getCityID());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void insertData(Entertainment entertainment) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into entertainment (name, income, price, salary, ownerId, id, cityId, item1price, item2price, item3price, item4price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, entertainment.getName());
            ps.setLong(2, entertainment.getIncome());
            ps.setLong(3, entertainment.getPrice());
            ps.setLong(4, entertainment.getSalary());
            ps.setLong(5, entertainment.getOwnerID());
            ps.setLong(6, entertainment.getID());
            ps.setLong(7, entertainment.getCityID());
            ps.setLong(8, entertainment.getItem1Price());
            ps.setLong(9, entertainment.getItem2Price());
            ps.setLong(10, entertainment.getItem3Price());
            ps.setLong(11, entertainment.getItem4Price());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void insertData(Restaurant restaurant) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into restaurant (name, income, price, salary, ownerId, id, cityId, item1price, item2price, item3price, item4price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, restaurant.getName());
            ps.setLong(2, restaurant.getIncome());
            ps.setLong(3, restaurant.getPrice());
            ps.setLong(4, restaurant.getSalary());
            ps.setLong(5, restaurant.getOwnerID());
            ps.setLong(6, restaurant.getID());
            ps.setLong(7, restaurant.getCityID());
            ps.setLong(8, restaurant.getItem1Price());
            ps.setLong(9, restaurant.getItem2Price());
            ps.setLong(10, restaurant.getItem3Price());
            ps.setLong(11, restaurant.getItem4Price());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertData(SuperMarket superMarket) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into supermarket (name, income, price, salary, ownerId, id, cityId, item1price, item2price, item3price, item4price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, superMarket.getName());
            ps.setLong(2, superMarket.getIncome());
            ps.setLong(3, superMarket.getPrice());
            ps.setLong(4, superMarket.getSalary());
            ps.setLong(5, superMarket.getOwnerID());
            ps.setLong(6, superMarket.getID());
            ps.setLong(7, superMarket.getCityID());
            ps.setLong(8, superMarket.getItem1Price());
            ps.setLong(9, superMarket.getItem2Price());
            ps.setLong(10, superMarket.getItem3Price());
            ps.setLong(11, superMarket.getItem4Price());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void insertData(User user_temp) {

        try {

            Connection connection = DriverManager.getConnection(url, user, pass);

            String sql = " insert into user (id, username, password)"
                    + " values (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, user_temp.getID());
            ps.setString(2, user_temp.getUsername());

            ps.setString(3, Main.encode(user_temp.getPassword()));
            ps.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
