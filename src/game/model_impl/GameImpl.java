package game.model_impl;

import game.interfaces.Member;
import game.interfaces.Captain;
import game.interfaces.Game;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {


    List<Member> members;
    private Captain captain;

    public GameImpl(){
        members = new ArrayList<>();
    }


    @Override
    public int echoMessage(String str) throws RemoteException {
        System.out.println( "Got a message from the client: " + str );

        return str.length();
    }

    @Override
    public void addMember(Member newMember) throws RemoteException {
        Member member = newMember;
        members.add(member);
    }

    @Override
    public List<Member> getMembers() throws RemoteException {
        return this.members;
    }

    @Override
    public Captain getCaptain() throws RemoteException {
        return this.captain;
    }

    @Override
    public void kickMember(int id) throws RemoteException {
        members.remove(id);
        for(Member member : members){
            System.out.println(member.getId());
        }

    }

    @Override
    public void setCaptain(Captain newCaptain) throws RemoteException {
        this.captain = newCaptain;
    }
}
