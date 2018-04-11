package game.clients.members;

import bean.CrewPanelBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MemberClientView{
    private JPanel panel1;
    private CrewPanelBean bean;

    MemberClientView(){
        bean.getComboBox1().addItem("A");
        bean.getComboBox1().addItem("B");
        bean.getComboBox1().addItem("C");
        bean.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                evt.getPropertyName();
            }
        });
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
