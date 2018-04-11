package game.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Game extends Remote {

    int echoMessage( String str ) throws RemoteException;

    void addMember(Member member) throws RemoteException;

    List<Member> getMembers() throws RemoteException;

    void setCaptain(Captain captain) throws RemoteException;

    Captain getCaptain() throws RemoteException;

    void kickMember(int id) throws RemoteException;


}
