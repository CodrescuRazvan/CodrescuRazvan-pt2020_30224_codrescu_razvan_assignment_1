import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
    protected Frame frame;

    public Controller(Frame frame){
        this.frame = frame;
        frame.setDualPolActionListener(new CheckBoxActionListener());
        frame.setButtonAddActionListener(new AddButtonActionListener());
        frame.setButtonSubActionListener(new SubButtonActionListener());
        frame.setButtonMulActionListener(new MulButtonActionListener());
        frame.setButtonDerActionListener(new DerButtonActionListener());
        frame.setButtonIntActionListener(new IntButtonActionListener());
        frame.setButtonDivActionListener(new DivButtonActionListener());
        frame.setVisible(true);
    }

    private class CheckBoxActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(Frame.getDualPol().isSelected()){
                Frame.getButtonInt().setVisible(false);
                Frame.getButtonDer().setVisible(false);
                Frame.getButtonAdd().setVisible(true);
                Frame.getButtonSub().setVisible(true);
                Frame.getButtonMul().setVisible(true);
                Frame.getButtonDiv().setVisible(true);
                Frame.getLabelPol2().setVisible(true);
                Frame.getTextField2().setVisible(true);
                Frame.getTextFieldRez().setVisible(false);
                Frame.getLabelRez().setVisible(false);
                Frame.getTextFieldRez().setText("");
                Frame.getLabelRem().setVisible(false);
                Frame.getTextFieldRem().setVisible(false);
            }
            else{
                Frame.getButtonInt().setVisible(true);
                Frame.getButtonDer().setVisible(true);
                Frame.getButtonAdd().setVisible(false);
                Frame.getButtonSub().setVisible(false);
                Frame.getButtonMul().setVisible(false);
                Frame.getButtonDiv().setVisible(false);
                Frame.getLabelPol2().setVisible(false);
                Frame.getTextField2().setVisible(false);
                Frame.getTextField2().setText("");
                Frame.getTextFieldRez().setText("");
                Frame.getTextFieldRez().setVisible(false);
                Frame.getLabelRez().setVisible(false);
                Frame.getLabelRem().setVisible(false);
                Frame.getTextFieldRem().setVisible(false);
            }
        }
    }

    private class AddButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent){
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getTextFieldRez().setText("");
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            if(Frame.getButtonAdd().isEnabled()){
                if(Frame.getTextField1In().isEmpty() || Frame.getTextField2In().isEmpty()){
                    Frame.getError().setText("Polinom neintrodus");
                    Frame.getError().setVisible(true);
                    Frame.getLabelRez().setVisible(false);
                    Frame.getTextFieldRez().setVisible(false);
                }
                else{
                    try {
                        Polinom p1 = new Polinom(Frame.getTextField1In());
                        Polinom p2 = new Polinom(Frame.getTextField2In());
                        Frame.getTextFieldRez().setText(Operatii.add(p1, p2).toString());
                        Frame.getTextFieldRez().setVisible(true);
                        Frame.getLabelRez().setVisible(true);
                        Frame.getError().setVisible(false);
                    }catch (Exception e){
                        Frame.getError().setText("Polinom introdus incorect");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    }
                }
            }
        }
    }

    private class SubButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getTextFieldRez().setText("");
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            if(Frame.getButtonSub().isEnabled()){
                if(Frame.getTextField1In().isEmpty() || Frame.getTextField2In().isEmpty()){
                    Frame.getError().setText("Polinom neintrodus");
                    Frame.getError().setVisible(true);
                    Frame.getLabelRez().setVisible(false);
                    Frame.getTextFieldRez().setVisible(false);
                }
                else{
                    try {
                        Polinom p1 = new Polinom(Frame.getTextField1In());
                        Polinom p2 = new Polinom(Frame.getTextField2In());
                        Frame.getTextFieldRez().setText(Operatii.sub(p1, p2).toString());
                        Frame.getTextFieldRez().setVisible(true);
                        Frame.getLabelRez().setVisible(true);
                        Frame.getError().setVisible(false);
                    }catch (Exception e){
                        Frame.getError().setText("Polinom introdus incorect");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    }
                }
            }
        }
    }

    private class MulButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            Frame.getTextFieldRez().setText("");
            if(Frame.getButtonMul().isEnabled()) {
                if (Frame.getTextField1In().isEmpty() || Frame.getTextField2In().isEmpty()) {
                    Frame.getError().setText("Polinom neintrodus");
                    Frame.getError().setVisible(true);
                    Frame.getLabelRez().setVisible(false);
                    Frame.getTextFieldRez().setVisible(false);
                } else {
                    try {
                        Polinom p1 = new Polinom(Frame.getTextField1In());
                        Polinom p2 = new Polinom(Frame.getTextField2In());
                        Frame.getTextFieldRez().setText(Operatii.mul(p1, p2).toString());
                        Frame.getTextFieldRez().setVisible(true);
                        Frame.getLabelRez().setVisible(true);
                        Frame.getError().setVisible(false);
                    }catch (Exception e){
                        Frame.getError().setText("Polinom introdus incorect");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    }
                }
            }
        }
    }
    private class DivButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getTextFieldRez().setText("");
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            if(Frame.getButtonDiv().isEnabled()){
                if (Frame.getTextField1In().isEmpty() || Frame.getTextField2In().isEmpty()) {
                    Frame.getError().setText("Polinom neintrodus");
                    Frame.getError().setVisible(true);
                    Frame.getLabelRez().setVisible(false);
                    Frame.getTextFieldRez().setVisible(false);
                } else {
                    try {
                        Polinom p1 = new Polinom(Frame.getTextField1In());
                        Polinom p2 = new Polinom(Frame.getTextField2In());
                        ResDiv res = Operatii.div(p1, p2);
                        Frame.getTextFieldRez().setText(res.getResult().toString());
                        Frame.getTextFieldRem().setText(res.getRemainder().toString());
                        Frame.getTextFieldRez().setVisible(true);
                        Frame.getTextFieldRem().setVisible(true);
                        Frame.getLabelRez().setVisible(true);
                        Frame.getLabelRem().setVisible(true);
                        Frame.getError().setVisible(false);
                }catch(Exception e){
                        Frame.getError().setText("Polinom introdus incorect");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    }
                }
            }
        }
    }

    private class DerButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getTextFieldRez().setText("");
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            if(Frame.getButtonDer().isEnabled()) {
                if (Frame.getTextField1In().isEmpty()) {
                    Frame.getError().setText("Polinom neintrodus");
                    Frame.getError().setVisible(true);
                    Frame.getLabelRez().setVisible(false);
                    Frame.getTextFieldRez().setVisible(false);
                } else {
                    try {
                        Polinom p1 = new Polinom(Frame.getTextField1In());
                        Frame.getTextFieldRez().setText(Operatii.derivate(p1).toString());
                        Frame.getTextFieldRez().setVisible(true);
                        Frame.getLabelRez().setVisible(true);
                        Frame.getError().setVisible(false);
                    }catch (Exception e){
                        Frame.getError().setText("Polinom introdus incorect");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    }
                }
            }
        }
    }

    private class IntButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Frame.getLabelRez().setVisible(false);
            Frame.getTextFieldRez().setVisible(false);
            Frame.getTextFieldRez().setText("");
            Frame.getLabelRem().setVisible(false);
            Frame.getTextFieldRem().setVisible(false);
            if(Frame.getButtonInt().isEnabled()) {
                    if (Frame.getTextField1In().isEmpty()) {
                        Frame.getError().setText("Polinom neintrodus");
                        Frame.getError().setVisible(true);
                        Frame.getLabelRez().setVisible(false);
                        Frame.getTextFieldRez().setVisible(false);
                    } else {
                        try {
                            Polinom p1 = new Polinom(Frame.getTextField1In());
                            Frame.getTextFieldRez().setText(Operatii.integrate(p1).toString());
                            Frame.getTextFieldRez().setVisible(true);
                            Frame.getLabelRez().setVisible(true);
                            Frame.getError().setVisible(false);
                        }catch (Exception e){
                            Frame.getError().setText("Polinom introdus incorect");
                            Frame.getError().setVisible(true);
                            Frame.getLabelRez().setVisible(false);
                            Frame.getTextFieldRez().setVisible(false);
                        }
                    }
                }
            }
        }
    }
