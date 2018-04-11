package game.clients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CaptainClientView {
    private JTable memberTable;
    private JTextPane commandTextPane;
    private JButton startButton;
    private JButton stopButton;
    private JPanel mainPanel;
    private JButton refreshButton;
    private JPanel buttonPanel;
    private DefaultTableModel model;

    CaptainClientView(){
        JFrame f = new JFrame("Captain");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(mainPanel);

        f.pack();
        f.setLocationByPlatform(true);
        f.setMinimumSize(f.getSize());
        f.setVisible(true);
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(JButton refreshButton) {
        this.refreshButton = refreshButton;
    }

    public JTable getMemberTable() {
        return memberTable;
    }

    public void setMemberTable(JTable memberTable) {
        this.memberTable = memberTable;
    }

    public JTextPane getCommandTextPane() {
        return commandTextPane;
    }

    public void setCommandTextPane(JTextPane commandTextPane) {
        this.commandTextPane = commandTextPane;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    private void createUIComponents() {

        model = new DefaultTableModel();
        memberTable = new JTable(model);

        model.addColumn("Member ID");
        model.addColumn("Points");

        memberTable.setFillsViewportHeight(true);
    }

//    public static void main(String[] args) {
//        CaptainClientView captainClientView = new CaptainClientView();
//    }
}

