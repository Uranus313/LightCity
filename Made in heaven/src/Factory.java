public class Factory extends  Block{
    public Factory(String name, long income, long price, long salary, long ownerID, long ID, long cityID) {
        super(name, income, price, salary, ownerID, ID, cityID);
    }
    public void addIncome(){
            this.setIncome((long)(this.getIncome()*1.05));
    }
    public void lowerIncome(){
        this.setIncome((long)(this.getIncome()/1.05));
    }

    @Override
    public void customerMenu(Avatar avatar) {
    }

    @Override
    public void OwnerMenu(Avatar avatar) {
    }
}
