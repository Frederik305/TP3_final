package pack;

public class Food {
    //Les proprietes utilisee dans la class Food
    private String type;
    private int quantity;

    public Food(){}

    public Food(String typre, int quantity) {
        this.type = typre;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String typre) {
        this.type = typre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "typre='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
