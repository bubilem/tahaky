package graphapp;

public final class StringItem implements Item {

    private String name;
    private String value;

    public StringItem(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        try {
            return Integer.valueOf(value.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public String getValueString() {
        return value;
    }

}
