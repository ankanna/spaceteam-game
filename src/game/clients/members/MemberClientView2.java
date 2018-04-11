package game.clients.members;

import bean.CrewPanelBean;

import javax.swing.*;

public class MemberClientView2{
    private JPanel panel1;
    private CrewPanelBean bean;

    MemberClientView2(){
        bean.getComboBox1().addItem("D");
        bean.getComboBox1().addItem("E");
//        JFrame f = new JFrame("Captain");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setContentPane(panel1);
//
//        f.pack();
//        f.setLocationByPlatform(true);
//        f.setMinimumSize(f.getSize());
//        f.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public CrewPanelBean getBean() {
        return bean;
    }

    public void setBean(CrewPanelBean bean) {
        this.bean = bean;
    }
}
