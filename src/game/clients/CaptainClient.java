package game.clients;

import game.interfaces.Captain;
import game.interfaces.Game;
import game.interfaces.Member;
import game.model_impl.CaptainImpl;
import game.model_impl.Command;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * Main class for a client.
 *
 */
public class CaptainClient {

    public static final String registryName = "RMI-spaceteam";
    private JTable memberTable;
    private JTextPane commandTextPane;
    private JButton startButton;
    private JButton stopButton;
    private DefaultTableModel model;
    private JButton refreshButton;

    private Captain captain;
    private Game game;

    public CaptainClient(){

        try {

            setRegistry();

            captain = new CaptainImpl();
            game.setCaptain(captain);


        } catch (Exception e) {
            System.err.println("Exception while trying to set up captain:");
            e.printStackTrace();
        }
        CaptainClientView captainClientView = new CaptainClientView();
        initComponents(captainClientView);
        initListeners();

        try {
            refreshMembers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    void setRegistry() throws RemoteException, NotBoundException {

        System.setProperty("java.rmi.server.hostname", "localhost");
        Registry registry = LocateRegistry.getRegistry("localhost", 50000);
        game = (Game) registry.lookup(registryName);

        System.out.println("Everything's ok!");

    }

    void initComponents(CaptainClientView captainClientView) {
        memberTable = captainClientView.getMemberTable();
        commandTextPane = captainClientView.getCommandTextPane();
        startButton = captainClientView.getStartButton();
        stopButton = captainClientView.getStopButton();
        model = captainClientView.getModel();
        refreshButton = captainClientView.getRefreshButton();
    }


    void initListeners() {

        refreshButton.addActionListener(actionEvent -> {
            try {
                refreshMembers();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        startButton.addActionListener(actionEvent -> {
            try {

                if(game.getMembers().get(game.getCaptain().getCurrentMember()).getCorrectAnswer()){
                    game.getMembers().get(game.getCaptain().getCurrentMember()).addPoint();
                    game.getMembers().get(game.getCaptain().getCurrentMember()).setCorrectAnswer(false);
                }

                setCurrentPlayer(game.getCaptain().getCurrentMember());

                commandTextPane.setText(writeCommand());

                refreshMembers();

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        stopButton.addActionListener(actionEvent -> {
            try {
                resetGame();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    void refreshMembers() throws RemoteException {

        model.setRowCount(0);

        for (Member member : game.getMembers()) {
            model.addRow(new Object[]{"Member #" + member.getId(), member.getPoints()});
        }
    }

    private void setCurrentPlayer(int currentPlayer) throws RemoteException {
        if ((currentPlayer == game.getMembers().size()-1)
                || (startButton.getText() == "Start")) {

            game.getCaptain().setCurrentMember
                    (game.getMembers().get(0).getId()-1);
            startButton.setText("Next player");

        } else {
            game.getCaptain().setCurrentMember
                    (currentPlayer+1);
        }
    }

    private String writeCommand() throws RemoteException {
        Command command = game.getCaptain()
                .generateCommand(game.getMembers().get(game
                        .getCaptain()
                        .getCurrentMember())
                        .getDevices());

        return game.getCaptain().writeCommand(command.getDeviceName(),
                command.getDeviceValueName(),
                String.valueOf(game.getMembers().get(game.getCaptain().getCurrentMember()).getId()));

    }

    void resetGame() throws RemoteException {
        for(Member member : game.getMembers() ) {
            member.setCorrectAnswer(false);
            member.setPoints(0);
        }
            commandTextPane.setText("");
            game.getCaptain().setCurrentMember(0);

        }

    public static void main(String[] args) {

        CaptainClient captainClient = new CaptainClient();
    }
}

