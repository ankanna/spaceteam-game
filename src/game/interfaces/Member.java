package game.interfaces;

import game.model_impl.Command;
import game.model_impl.Device;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Member extends Remote {

    void setId(int id)  throws RemoteException;

    int getId()  throws RemoteException;

    void setCaptain(Captain captain)  throws RemoteException;

    void isKicked()  throws RemoteException;

    int getPoints()  throws RemoteException;

    void addPoint()  throws RemoteException;

    boolean getCorrectAnswer() throws RemoteException;

    void setCorrectAnswer(boolean correctAnswer) throws RemoteException;

    Command getCommand()  throws RemoteException;

    void setPoints(int points)  throws RemoteException;

    List<Device> getDevices() throws RemoteException;

    void setDevices(List<Device> devices) throws RemoteException;
}
