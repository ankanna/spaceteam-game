package game.model_impl;

import java.io.Serializable;
import java.util.List;

public class Device implements Serializable {

    private int number;
    private boolean enable;
    private int range;
    private String name;
    private List<String> valueNames;

    public Device(int number, boolean enable, int range, String name, List<String> valueNames) {
        this.number = number;
        this.enable = enable;
        this.range = range;
        this.name = name;
        this.valueNames = valueNames;
    }

    public List<String> getValueNames() {
        return valueNames;
    }

    public int getNumber() {
        return number;
    }

    public boolean isEnable() {
        return enable;
    }

    public int getRange() {
        return range;
    }

    public String getName() {
        return name;
    }

}
