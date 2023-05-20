package pack;

public class Animaux{
    //Les proprietes utilisee dans la class Animaux
    private String Name;
    private String Gender;
    private String type;
    private String SocialGroup;
    private String Species;
    private int frequence;
    private int quantite;
    private EnclosType zone;

    public Animaux(){}

    public Animaux(String name, String gender, String type, String socialGroup, String species, int frequence, int quantite, EnclosType zone) {
        Name = name;
        Gender = gender;
        this.type = type;
        SocialGroup = socialGroup;
        Species = species;
        this.frequence = frequence;
        this.quantite = quantite;
        this.zone = zone;
    }

    public EnclosType getZone() {
        return zone;
    }

    public void setZone(EnclosType zone) {
        this.zone = zone;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSocialGroup() {
        return SocialGroup;
    }

    public void setSocialGroup(String socialGroup) {
        SocialGroup = socialGroup;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    @Override
    public String toString() {
        return "Animaux{" +
                "Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", type='" + type + '\'' +
                ", SocialGroup='" + SocialGroup + '\'' +
                ", Species='" + Species + '\'' +
                ", frequence=" + frequence +
                ", quantite=" + quantite +
                '}';
    }
}
