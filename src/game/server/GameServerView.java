package game.server;

import javax.swing.*;

public class GameServerView {
    private JPanel panel1;
    private JList membersList;
    private JButton refreshButton;
    private JButton kickButton;
    private DefaultListModel dlmMembers;

    public GameServerView() {
        dlmMembers = new DefaultListModel();
        membersList.setModel(dlmMembers);

        JFrame f = new JFrame("Server");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(panel1);

        f.pack();
        f.setLocationByPlatform(true);
        f.setMinimumSize(f.getSize());
        f.setVisible(true);
    }

    public DefaultListModel getDlmMembers() {
        return dlmMembers;
    }

    public void setDlmMembers(DefaultListModel dlmMembers) {
        this.dlmMembers = dlmMembers;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(JButton refreshButton) {
        this.refreshButton = refreshButton;
    }

    public JButton getKickButton() {
        return kickButton;
    }

    public void setKickButton(JButton kickButton) {
        this.kickButton = kickButton;
    }

    public JList getMembersList() {
        return membersList;
    }


    private void createUIComponents() {
        dlmMembers = new DefaultListModel();
        membersList = new JList();
        membersList.setModel(dlmMembers);
    }
}
