package pack;

import java.util.ArrayList;

public class Caretaker extends Employees {
    //Les proprietes utilisee dans la class Caretaker
    private ArrayList<Enclos> enclosList;
    private int caretakerId;
    private EnclosType zone;
    public Caretaker(){}

    public Caretaker(int badge, String name, String role, EnclosType zone) {
        super(badge, name, role);
        this.zone = zone;
    }
    public Caretaker(int badge, String name, String role) {
        super(badge, name, role);
    }

    public void setEnclosList(ArrayList<Enclos> enclosList) {
        this.enclosList = enclosList;
    }

    public int getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(int caretakerId) {
        this.caretakerId = caretakerId;
    }

    public EnclosType getZone() {
        return zone;
    }

    public void setZone(EnclosType zone) {
        this.zone = zone;
    }

    public void addEnclos(Enclos enclos) {
        enclosList.add(enclos);
    }

    public ArrayList<Enclos> getEnclosList() {
        return enclosList;
    }

    @Override
    public String toString() {
        return "Caretaker{" +
                "enclosList=" + enclosList +
                ", caretakerId=" + caretakerId +
                ", zone=" + zone +
                ", Badge=" + getBadge() +
                ", Name='" + getName() + '\'' +
                '}';
    }
}