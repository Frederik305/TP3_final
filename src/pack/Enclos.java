package pack;

import java.util.ArrayList;
import java.util.List;

public class Enclos {
    //Les proprietes utilisee dans la class Enclos
    private EnclosType zone;
    private int numEnclos;
    private String confinement;
    private EnclosSize grandeurCage;
    private String espece;
    private ArrayList<Animaux> animauxList;

    public Enclos(){}

    public Enclos(EnclosType zone, int numEnclos, String confinement, EnclosSize grandeurCage, String espece) {
        this.zone = zone;
        this.numEnclos = numEnclos;
        this.confinement = confinement;
        this.grandeurCage = grandeurCage;
        this.espece = espece;
        this.animauxList = new ArrayList<>();
    }
    public EnclosType getZone() {return zone;}

    public int getNumEnclos() {
        return numEnclos;
    }

    public String getEspece() {
        return espece;
    }

    public void addAnimal(Animaux animal) {
        animauxList.add(animal);
    }

    public List<Animaux> getAnimauxList() {
        List<Animaux> allAnimals = new ArrayList<>();
        allAnimals.addAll(animauxList);
        allAnimals.addAll(Methodes.readAnimauxExotiqueData("src/pack/listeAnimauxExotiques"));
        allAnimals.addAll(Methodes.readAnimauxDomestiqueData("src/pack/listeAnimauxDomestiques"));
        return allAnimals;
    }

    @Override
    public String toString() {
        return "Enclos{" +
                "zone='" + zone + '\'' +
                ", numEnclos=" + numEnclos +
                ", confinement='" + confinement + '\'' +
                ", grandeurCage='" + grandeurCage + '\'' +
                ", espece='" + espece + '\'' +
                ", animauxList=" + animauxList +
                '}';
    }
}
