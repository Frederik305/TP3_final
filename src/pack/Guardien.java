package pack;

public class Guardien extends Employees {
    //Les proprietes utilisee dans la class Guardien
    private String type;

    public Guardien(){}
    public Guardien(int badge, String name, String role, String type) {
        super(badge, name, role);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Guardien{" +
                "badge=" + getBadge() +
                ", name='" + getName() + '\'' +
                ", role='" + getRole() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
