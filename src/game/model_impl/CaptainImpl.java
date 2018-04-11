package game.model_impl;

import game.interfaces.Captain;
import game.interfaces.Member;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;

public class CaptainImpl extends UnicastRemoteObject implements Captain {

    List<Member> members;
    Command command;
    int currentMember;

    public CaptainImpl() throws RemoteException {
    }

    @Override
    public Command getCommand() {
        return this.command;
    }

    @Override
    public int getCurrentMember() throws RemoteException {
        return this.currentMember;
    }

    @Override
    public void setCurrentMember(int currentMember) throws RemoteException {
        this.currentMember = currentMember;
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }

    @Override
    public Command generateCommand(List<Device> devices) {

        command = new Command();

        Random random = new Random(System.currentTimeMillis());

        //random number of device
        int deviceNum = random.nextInt(devices.size());
        while (!devices.get(deviceNum).isEnable()) {
            deviceNum = random.nextInt(devices.size());
        }

        //random value of device
        int deviceValue = random.nextInt(devices.get(deviceNum).getRange());

        command.setDeviceNum(deviceNum+1);
        command.setDeviceValue(deviceValue);
        command.setDeviceName(devices.get(deviceNum).getName());
        if (devices.get(deviceNum).getValueNames() != null) {
            command.setDeviceValueName(devices
                    .get(deviceNum)
                    .getValueNames()
                    .get(deviceValue));
        } else {
            command.setDeviceValueName(Integer.toString(deviceValue));
        }
        return command;
    }


    @Override
    public String writeCommand(String deviceName, String deviceValueName, String member) {
        return "Set " + deviceName + " to " + deviceValueName + ", Member #" + member +"!";}

}
