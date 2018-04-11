package bean;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.beans.*;
import java.io.Serializable;

public class CrewPanelBean extends JPanel implements PropertyChangeListener, Serializable {

    private static final long serialVersionUID = 1L;
    private static final int XPREFSIZE = 500;
    private static final int YPREFSIZE = 300;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    private String panelTitle;
    private String name1;
    private String name2;
    private String name3;
    private String name4;

    private boolean enableTool1;
    private boolean enableTool2;
    private boolean enableTool3;
    private boolean enableTool4;

    private int textFieldValue;

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JSlider getSlider1() {
        return slider1;
    }

    public JRadioButton getRadioButton2() {
        return radioButton2;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public boolean isEnableTool1() {
        return enableTool1;
    }

    public int getTextFieldValue() {
        return textFieldValue;
    }

    public void setTextFieldValue(int newTextFieldValue) throws PropertyVetoException {
        int oldFieldValue = this.textFieldValue;
        this.textFieldValue = newTextFieldValue;
        this.vcs.fireVetoableChange("textFieldValue", oldFieldValue, newTextFieldValue);
    }

    public void setEnableTool1(boolean enableTool1) {
        boolean oldEnableTool1 = this.enableTool1;
        this.enableTool1 = enableTool1;
        this.pcs.firePropertyChange("enableTool1", oldEnableTool1, enableTool1);
    }

    public boolean isEnableTool2() {
        return enableTool2;
    }

    public void setEnableTool2(boolean enableTool2) {
        boolean oldEnableTool2 = this.enableTool2;
        this.enableTool2 = enableTool2;
        this.pcs.firePropertyChange("enableTool2", oldEnableTool2, enableTool2);
    }

    public boolean isEnableTool3() {
        return enableTool3;
    }

    public void setEnableTool3(boolean enableTool3) {
        boolean oldEnableTool3 = this.enableTool3;
        this.enableTool3 = enableTool3;
        this.pcs.firePropertyChange("enableTool3", oldEnableTool3, enableTool3);
    }

    public boolean isEnableTool4() {
        return enableTool4;
    }

    public void setEnableTool4(boolean enableTool4) {
        boolean oldEnableTool4 = this.enableTool4;
        this.enableTool4 = enableTool4;
        this.pcs.firePropertyChange("enableTool4", oldEnableTool4, enableTool4);
    }

    public String getPanelTitle() {
        return panelTitle;
    }

    public void setPanelTitle(String panelTitle) {
        this.panelTitle = panelTitle;
        title.setText(this.panelTitle);
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
        panel1.setBorder(new TitledBorder(this.name1));
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
        panel2.setBorder(new TitledBorder(this.name2));
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
        panel3.setBorder(new TitledBorder(this.name3));
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
        panel4.setBorder(new TitledBorder(this.name4));
    }

    public Dimension getPreferredSize() {
        return new Dimension(XPREFSIZE, YPREFSIZE);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public void addVetoableChangeListener(VetoableChangeListener listener) {
        this.vcs.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        this.vcs.addVetoableChangeListener(listener);
    }


    public CrewPanelBean() {
        addPropertyChangeListener(this);

        initProperties();
        initComponents();
    }

    void initProperties() {
        panelTitle = "panelTitle";
        name1 = "name1";
        name2 = "name2";
        name3 = "name3";
        name4 = "name4";
        enableTool1 = true;
        enableTool2 = true;
        enableTool3 = true;
        enableTool4 = true;

    }



    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Anna Cegla
        title = new JLabel();
        panel1 = new JPanel();
        slider1 = new JSlider();
        panel2 = new JPanel();
        radioButton2 = new JRadioButton();
        panel3 = new JPanel();
        textField1 = new JTextField();
        panel4 = new JPanel();
        comboBox1 = new JComboBox();
        panel5 = new JPanel();
        confirmButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(1000, 266));

        setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));

        //---- title ----
        title.setText("panelTitle");
        add(title, new GridConstraints(0, 0, 1, 3,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("name1"));
            panel1.setMinimumSize(new Dimension(240, 102));
            panel1.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));

            //---- slider1 ----
            slider1.setPaintLabels(true);
            slider1.setPaintTicks(true);
            slider1.setMaximum(3);
            slider1.setValue(0);
            slider1.setSnapToTicks(true);
            panel1.add(slider1, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panel1, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("name2"));
            panel2.setMinimumSize(new Dimension(240, 102));
            panel2.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));

            //---- radioButton2 ----
            radioButton2.setText("ON/OFF");
            panel2.add(radioButton2, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panel2, new GridConstraints(1, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("name3"));
            panel3.setMinimumSize(new Dimension(240, 102));
            panel3.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), 0, 0));

            //---- textField1 ----
            textField1.setMinimumSize(new Dimension(50, 28));
            panel3.add(textField1, new GridConstraints(1, 0, 1, 3,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, new Dimension(37, 0), null));
        }
        add(panel3, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel4 ========
        {
            panel4.setBorder(new TitledBorder("name4"));
            panel4.setMinimumSize(new Dimension(240, 102));
            panel4.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
            panel4.add(comboBox1, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panel4, new GridConstraints(2, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel5 ========
        {
            panel5.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));

            //---- confirmButton ----
            confirmButton.setText("confirm");
            panel5.add(confirmButton, new GridConstraints(0, 0, 1, 3,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        add(panel5, new GridConstraints(3, 0, 1, 3,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Anna Cegla
    private JLabel title;
    private JPanel panel1;
    private JSlider slider1;
    private JPanel panel2;
    private JRadioButton radioButton2;
    private JPanel panel3;
    private JTextField textField1;
    private JPanel panel4;
    private JComboBox comboBox1;
    private JPanel panel5;
    private JButton confirmButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new CrewPanelBean());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        System.out.println(propertyName);
        if (propertyName.equals("enableTool1")) {
            panel1.setEnabled(isEnableTool1());
            slider1.setEnabled(isEnableTool1());
        }
        if (propertyName.equals("enableTool2")) {
            panel2.setEnabled(isEnableTool2());
            radioButton2.setEnabled(isEnableTool2());
        }
        if (propertyName.equals("enableTool3")) {
            panel3.setEnabled(isEnableTool3());
            textField1.setEnabled(isEnableTool3());
        }
        if (propertyName.equals("enableTool4")) {
            panel4.setEnabled(isEnableTool4());
            comboBox1.setEnabled(isEnableTool4());

    }}}
