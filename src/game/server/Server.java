package game.server;

import game.interfaces.Game;
import game.model_impl.GameImpl;
import game.interfaces.Member;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static final String registryName = "RMI-spaceteam";

    private JList membersList;
    private JButton refreshButton;
    private JButton kickButton;
    private DefaultListModel dlmMembers;

    private Game game;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        GameImpl implementation = new GameImpl();

        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            game = (Game) UnicastRemoteObject.exportObject(implementation, 50000);
            Registry registry = LocateRegistry.createRegistry(50000);
            registry.rebind(registryName, game);

        } catch (RemoteException ex) {
            ex.printStackTrace();
            return;
        }
        System.out.println("Server is ready!");
        GameServerView gameServerView = new GameServerView();
        initComponents(gameServerView);
        initListeners();
    }

    void initComponents(GameServerView gameServerView) {
        this.refreshButton = gameServerView.getRefreshButton();
        this.kickButton = gameServerView.getKickButton();
        this.dlmMembers = gameServerView.getDlmMembers();
        this.membersList = gameServerView.getMembersList();

    }

    void initListeners() {
        refreshButton.addActionListener(e -> {
            refreshMemberList();
        });

        kickButton.addActionListener(e -> {
            try {
                kickMember();
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        });
    }

    void refreshMemberList() {
        dlmMembers.clear();
        try {
            for (Member member : game.getMembers()) {
                dlmMembers.addElement("Member #" + member.getId());
            }
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }

    void kickMember() throws RemoteException {
        System.out.println(membersList.getSelectedIndex());
        dlmMembers.remove(membersList.getSelectedIndex());
        game.kickMember(membersList.getSelectedIndex());
    }
}
