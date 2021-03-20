import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends UniversalFrame {

    private static JCheckBox dualPol;

    private static JButton buttonAdd;
    private static JButton buttonSub;
    private static JButton buttonMul;
    private static JButton buttonDiv;
    private static JButton buttonInt;
    private static JButton buttonDer;

    private static JTextField textField1;
    private static JTextField textField2;
    private static JTextField textFieldRez;
    private static JTextField textFieldRem;

    private static JLabel labelPol1;
    private static JLabel labelPol2;
    private static JLabel labelRez;
    private static JLabel labelRem;
    private static JLabel error;

    public Frame(String title){
        super(title);

        contentPanel.setLayout(null);
//Labels
        labelPol1 = new JLabel("Polinomul 1: ");
        labelPol1.setBounds(25, 75, 150, 25);
        labelPol1.setFont(writing);
        labelPol1.setVisible(true);
        contentPanel.add(labelPol1);

        labelPol2 = new JLabel("Polinomul 2: ");
        labelPol2.setBounds(25, 125, 150, 25);
        labelPol2.setFont(writing);
        labelPol2.setVisible(false);
        contentPanel.add(labelPol2);

        labelRez = new JLabel("Rezultat: ");
        labelRez.setBounds(25, 175, 150, 25);
        labelRez.setFont(writing);
        labelRez.setVisible(false);
        contentPanel.add(labelRez);

        error = new JLabel("");
        error.setBounds(25, 225, 180, 25);
        error.setFont(writing);
        error.setVisible(false);
        contentPanel.add(error);

        labelRem = new JLabel("Rest: ");
        labelRem.setBounds(25, 225, 180, 25);
        labelRem.setFont(writing);
        labelRem.setVisible(false);
        contentPanel.add(labelRem);
//TextFields
        textField1 = new JTextField();
        textField1.setBounds(150, 75, 175, 25);
        textField1.setFont(writing);
        textField1.setVisible(true);
        contentPanel.add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(150, 125, 175, 25);
        textField2.setFont(writing);
        textField2.setVisible(false);
        contentPanel.add(textField2);

        textFieldRez = new JTextField();
        textFieldRez.setBounds(150, 175, 300, 25);
        textFieldRez.setFont(writing);
        textFieldRez.setVisible(false);
        contentPanel.add(textFieldRez);

        textFieldRem = new JTextField();
        textFieldRem.setBounds(150, 225, 300, 25);
        textFieldRem.setFont(writing);
        textFieldRem.setVisible(false);
        contentPanel.add(textFieldRem);
//CheckBox
        dualPol = new JCheckBox("Operatii pe doua polinoame");
        dualPol.setBackground(background);
        dualPol.setBounds(25, 25, 185, 25);
        contentPanel.add(dualPol);
//Buttons
        buttonAdd = new JButton("+");
        buttonAdd.setBounds(375, 75, 45, 25);
        buttonAdd.setBackground(background);
        buttonAdd.setFont(writing);
        buttonAdd.setVisible(false);
        contentPanel.add(buttonAdd);

        buttonDer = new JButton("'");
        buttonDer.setBounds(375, 75, 45, 25);
        buttonDer.setBackground(background);
        buttonDer.setFont(writing);
        buttonDer.setVisible(true);
        contentPanel.add(buttonDer);

        buttonSub = new JButton("-");
        buttonSub.setBounds(450, 75, 45, 25);
        buttonSub.setBackground(background);
        buttonSub.setFont(writing);
        buttonSub.setVisible(false);
        contentPanel.add(buttonSub);

        buttonInt = new JButton("∫");
        buttonInt.setBounds(450, 75, 45, 25);
        buttonInt.setBackground(background);
        buttonInt.setFont(writing);
        buttonInt.setVisible(true);
        contentPanel.add(buttonInt);

        buttonMul = new JButton("*");
        buttonMul.setBounds(375, 125, 45, 25);
        buttonMul.setBackground(background);
        buttonMul.setFont(writing);
        buttonMul.setVisible(false);
        contentPanel.add(buttonMul);

        buttonDiv = new JButton(":");
        buttonDiv.setBounds(450, 125, 45, 25);
        buttonDiv.setBackground(background);
        buttonDiv.setFont(writing);
        buttonDiv.setVisible(false);
        contentPanel.add(buttonDiv);
    }

    public void setDualPolActionListener(ActionListener actionListener){
        dualPol.addActionListener(actionListener);
    }

    public void setButtonAddActionListener(ActionListener actionListener){
        buttonAdd.addActionListener(actionListener);
    }

    public void setButtonSubActionListener(ActionListener actionListener){
        buttonSub.addActionListener(actionListener);
    }

    public void setButtonMulActionListener(ActionListener actionListener){
        buttonMul.addActionListener(actionListener);
    }

    public void setButtonDivActionListener(ActionListener actionListener){
        buttonDiv.addActionListener(actionListener);
    }

    public void setButtonDerActionListener(ActionListener actionListener){
        buttonDer.addActionListener(actionListener);
    }

    public void setButtonIntActionListener(ActionListener actionListener){
        buttonInt.addActionListener(actionListener);
    }

    public static JCheckBox getDualPol() {
        return dualPol;
    }

    public static JButton getButtonAdd() {
        return buttonAdd;
    }

    public static JButton getButtonSub() {
        return buttonSub;
    }

    public static JButton getButtonMul() {
        return buttonMul;
    }

    public static JButton getButtonDiv() {
        return buttonDiv;
    }

    public static JButton getButtonInt() {
        return buttonInt;
    }

    public static JButton getButtonDer() {
        return buttonDer;
    }

    public static JTextField getTextField1() {
        return textField1;
    }

    public static JTextField getTextField2() {
        return textField2;
    }

    public static JTextField getTextFieldRez() {
        return textFieldRez;
    }

    public static JLabel getLabelPol1() {
        return labelPol1;
    }

    public static JLabel getLabelPol2() {
        return labelPol2;
    }

    public static JLabel getLabelRez() {
        return labelRez;
    }

    public static JLabel getError() {
        return error;
    }

    public static String getTextField1In(){
        return textField1.getText();
    }

    public static String getTextField2In(){
        return textField2.getText();
    }

    public static JTextField getTextFieldRem() {
        return textFieldRem;
    }

    public static void setTextFieldRem(JTextField textFieldRem) {
        Frame.textFieldRem = textFieldRem;
    }

    public static JLabel getLabelRem() {
        return labelRem;
    }
}
