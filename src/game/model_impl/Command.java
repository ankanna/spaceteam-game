package game.model_impl;

import java.io.Serializable;

public class Command implements Serializable {

    private int deviceNum;
    private int deviceValue;
    private String deviceName;
    private String deviceValueName;

    public Command(){
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceValueName() {
        return deviceValueName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceValueName(String deviceValueName) {
        this.deviceValueName = deviceValueName;
    }

    public int getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(int deviceNum) {
        this.deviceNum = deviceNum;
    }

    public int getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(int deviceValue) {
        this.deviceValue = deviceValue;
    }
}
