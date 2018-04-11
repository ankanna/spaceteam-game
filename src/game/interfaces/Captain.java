package game.interfaces;


import game.model_impl.Command;
import game.model_impl.Device;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Captain extends Remote {

    List<Member> getMembers()  throws RemoteException;

    Command generateCommand(List<Device> devices)  throws RemoteException;

    String writeCommand(String deviceName, String deviceValueName, String member)  throws RemoteException;

    Command getCommand()  throws RemoteException;

    int getCurrentMember() throws RemoteException;

    void setCurrentMember(int currentMember) throws RemoteException;

}
