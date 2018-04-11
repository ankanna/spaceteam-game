package game.clients.members;

import bean.CrewPanelBean;
import game.interfaces.Game;
import game.interfaces.Member;
import game.model_impl.Device;
import game.model_impl.MemberImpl;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/*
 * Main class for a member.
 *
 */
public class MemberClient{

    public static final String registryName = "RMI-spaceteam";
    public static final int textFieldToolRange = 1000;

    private MemberClientView memberClientView = new MemberClientView();
    private MemberClientView2 memberClientView2 = new MemberClientView2();
    private Game game;
    private CrewPanelBean bean;
    private Member member;

    MemberClient() {

        try {
            setRegistry();

            createView();

            game.addMember(setMember());

            initListeners();

        } catch (Exception e) {
            System.err.println("Exception while trying to echo:");
            e.printStackTrace();
        }
    }

    void setRegistry() throws RemoteException, NotBoundException {

        System.setProperty("java.rmi.server.hostname", "localhost");
        Registry registry = LocateRegistry.getRegistry("localhost", 50000);
        game = (Game) registry.lookup(registryName);

        System.out.println("Member is wainting!");

    }

    Member setMember() throws RemoteException {

        List<String> deviceValueNames = new ArrayList<>();
        for (int i = 0; i < bean.getComboBox1().getItemCount(); i++) {
            deviceValueNames.add(bean.getComboBox1().getItemAt(i).toString());
        }

        List<Device> devices = asList(new Device(1,
                        bean.isEnableTool1(),
                        bean.getSlider1().getMaximum(),
                        bean.getName1(),
                        null),

                new Device(2,
                        bean.isEnableTool2(),
                        2,
                        bean.getName2(),
                        asList("\"OFF\"", "\"ON\"")),

                new Device(3,
                        bean.isEnableTool3(),
                        textFieldToolRange,
                        bean.getName3(),
                        null),

                new Device(4,
                        bean.isEnableTool4(),
                        bean.getComboBox1().getItemCount(),
                        bean.getName4(),
                        deviceValueNames));

        //creating member and setting properties
        member = new MemberImpl();
        member.setId(game.getMembers().size() + 1);
        member.setCaptain(game.getCaptain());
        member.setDevices(devices);

        return member;
    }


    void createView() {
        try {
            JFrame f = new JFrame("Member " + (game.getMembers().size() + 1));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //setting member panel
            if (game.getMembers().size() % 2 == 0) {

                memberClientView = new MemberClientView();
                f.setContentPane(memberClientView.getPanel1());
                this.bean = memberClientView.getBean();

            } else if (game.getMembers().size() % 2 == 1) {

                memberClientView2 = new MemberClientView2();
                f.setContentPane(memberClientView2.getPanel1());
                this.bean = memberClientView2.getBean();
            }

            f.pack();
            f.setLocationByPlatform(true);
            f.setMinimumSize(f.getSize());
            f.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void initListeners() {
        bean.getConfirmButton().addActionListener(actionEvent -> {

            try {

                if(member.getId() == game.getCaptain().getCurrentMember()+1) {
                        game.getMembers().get(game.getCaptain().getCurrentMember())
                                .setCorrectAnswer(checkCommand
                                        (game.getCaptain()
                                        .getCommand()
                                        .getDeviceNum(),
                                game.getCaptain()
                                        .getCommand()
                                        .getDeviceValue()));


                    if (game.getCaptain()
                            .getCommand()
                            .getDeviceNum() == 3) {
                        bean.setTextFieldValue(Integer.parseInt(bean.getTextField1().getText()));
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        });
        bean.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                if(evt.getPropertyName() == "textFieldValue"){
                    if(Integer.parseInt(bean.getTextField1().getText()) > textFieldToolRange){
                        JOptionPane.showMessageDialog(new Frame(),
                                "It is waaay too much!!",
                                "Too much",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    boolean checkCommand(int deviceNum, int deviceValue) throws RemoteException {

        switch (deviceNum) {
            case 1: {
                if (deviceValue == bean.getSlider1().getValue()) {
                    return true;
                }
                break;
            }
            case 2: {
                if ((deviceValue == 1 &&
                        bean.getRadioButton2().isSelected()) ||
                        (deviceValue == 0 &&
                        !bean.getRadioButton2().isSelected())) {

                    return true;
                }
                break;
            }
            case 3: {
                if (deviceValue == Integer.valueOf(bean.getTextField1().getText())) {
                    return true;
                }
                break;
            }
            case 4: {
                if (deviceValue == bean.getComboBox1().getSelectedIndex()) {
                    return true;
                }
                break;
            }
            default: {
                return false;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        MemberClient memberClient = new MemberClient();
    }

}

