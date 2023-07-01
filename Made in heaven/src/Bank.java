public class Bank extends Block {
    public Bank(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }

    public Bank(String name, long price, long cityID) {
        super(name, price, cityID);
    }

    public static boolean checkMoney(Avatar customer, Avatar owner, long price) {
        try {
            if (customer.getMoney() >= price) {
                customer.setMoney(customer.getMoney() - price);
                owner.setMoney(owner.getMoney() + price);
                return true;
            } else {
                AlertBox.display("fail", "you don't have enough money");
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
