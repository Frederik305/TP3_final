package pack;

public enum EnclosType {
    CARNIVORE("CARNIVORE"),
    OMNIVORE("OMNIVORE"),
    HERBIVORE("HERBIVORE");

    private final String type;

    EnclosType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}