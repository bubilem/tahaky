package graphapp;

public final class IntItem implements Item {

    private String name;
    private int value;

    public IntItem(String name, int value) {
        setName(name);
        setValue(value);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getValueString() {
        /*return Integer.toString(getValue());*/
        return String.valueOf(getValue());
    }

}
