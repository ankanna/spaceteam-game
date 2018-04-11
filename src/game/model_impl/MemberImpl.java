package game.model_impl;

import game.interfaces.Captain;
import game.interfaces.Member;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MemberImpl extends UnicastRemoteObject implements Member {

    int id;
    int points;
    Captain captain;
    Command command;
    boolean correctAnswer = false;

    List<Device> devices;

    public MemberImpl() throws RemoteException {
    }

    @Override
    public int getPoints() throws RemoteException {
        return points;
    }

    @Override
    public void addPoint() throws RemoteException {
        this.points++;

    }

    @Override
    public boolean getCorrectAnswer() throws RemoteException {
        return this.correctAnswer;
    }

    @Override
    public void setCorrectAnswer(boolean correctAnswer) throws RemoteException {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public Command getCommand() throws RemoteException {
        return this.command;
    }

    @Override
    public void setPoints(int points) throws RemoteException {
        this.points = points;
    }

    @Override
    public List<Device> getDevices() throws RemoteException {
        return this.devices;
    }

    @Override
    public void setDevices(List<Device> devices) throws RemoteException {
        this.devices = devices;

    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setCaptain(Captain newCaptain) {
        captain = newCaptain;

    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void isKicked() {

    }
}
