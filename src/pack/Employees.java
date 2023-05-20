package pack;

public class Employees {
    //Les proprietes utilisee dans la class Employees
    private int Badge;
    private String Name;
    private String Role;

    public Employees() {}

    public Employees(int badge, String name, String role) {
        Badge = badge;
        Name = name;
        Role = role;
    }

    public int getBadge() {
        return Badge;
    }

    public void setBadge(int badge) {
        Badge = badge;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "Badge=" + Badge +
                ", Name='" + Name + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
