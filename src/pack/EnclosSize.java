package pack;

public enum EnclosSize {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String size;

    EnclosSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}