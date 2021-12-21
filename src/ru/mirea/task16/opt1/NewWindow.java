package ru.mirea.task16.opt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class NewWindow implements ActionListener {
    JFrame frame;
    JTextField textField;
    JTextField textField1;
    JButton[] convertButtons = new JButton[5];
    boolean text = false;
    double result = 0;
    String temp = "";
    String[] str = new String[]{"фут", "ярд","метр","миля","дюйм"};
    JButton clrButton, delButton,equButton;
    Font myFont = new Font("Serif", Font.ITALIC, 16);
    Font myFont1 = new Font("Serif", Font.ITALIC, 26);
    JPanel panel;

    NewWindow(){
        frame = new JFrame("NewWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 510);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(46,30,250,45);
        textField1 = new JTextField();
        textField1.setBounds(46,75,250,40);

        textField.setFont(myFont1);
        textField1.setFont(myFont);
        textField1.setEditable(false);

        delButton = new JButton("del");
        clrButton = new JButton("clr");
        equButton = new JButton("=");

        for(int i = 0; i < 5; i++){
            convertButtons[i] = new JButton(str[i]);
            convertButtons[i].addActionListener(this);
            convertButtons[i].setFont(myFont);
            convertButtons[i].setFocusable(false);
        }
        clrButton.addActionListener(this);
        delButton.addActionListener(this);
        equButton.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(70,250,200,200);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.cyan);
        for(int i = 0; i < 5; i++){
            panel.add(convertButtons[i]);
        }
        delButton.setFont(myFont);
        delButton.setFocusable(false);
        clrButton.setFont(myFont);
        clrButton.setFocusable(false);
        equButton.setFont(myFont1);
        equButton.setFocusable(false);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(equButton);

        frame.add(panel);
        frame.add(textField);
        frame.add(textField1);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        NewWindow myWindow = new NewWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == equButton){

        }
        if(e.getSource() == delButton){
            String str = textField.getText();
            textField.setText("");
            for(int i = 0; i < str.length()-1; i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }



        if(e.getSource() == convertButtons[0] && temp == ""){
            result = Double.parseDouble(textField.getText());
            temp = "фут";
        }
        if(e.getSource() == convertButtons[1] && temp == ""){
            result = Double.parseDouble(textField.getText());
            temp = "ярд";
        }
        if(e.getSource() == convertButtons[2] && temp == ""){
            result = Double.parseDouble(textField.getText());
            temp = "метр";
        }
        if(e.getSource() == convertButtons[3] && temp == ""){
            result = Double.parseDouble(textField.getText());
            temp = "миля";
        }
        if(e.getSource() == convertButtons[4] && temp == ""){
            result = Double.parseDouble(textField.getText());
            temp  = "дюйм";
        }



        if(e.getSource() == convertButtons[2] && textField.getText() != ""){
            //-----------------------длина в метрах
            if(temp == "фут"){
                //result = result*0.3048;
                textField1.setText(String.valueOf(result*0.3048));
                textField.setText("");
            }
            if(temp == "дюйм"){
                //result = result*39.37;
                textField1.setText(String.valueOf(result*39.37));
                textField.setText("");
            }
            if(temp == "ярд"){
                //result = result*1.09361;
                textField1.setText(String.valueOf(result*1.09361));
                textField.setText("");
            }
            if(temp == "миля"){
                //result = result*0.000621371;
                textField1.setText(String.valueOf(result*0.000621371));
                textField.setText("");
            }

        }
        if(e.getSource() == convertButtons[3] && textField.getText() != ""){
            //--------------длина в милях
            if(temp == "метр"){
                //result = result/0.000621371;
                textField1.setText(String.valueOf(result/0.000621371));
                textField.setText("");
            }
            if(temp == "фут"){
                //result = result*0.000189394;
                textField1.setText(String.valueOf(result*0.000189394));
                textField.setText("");
            }
            if(temp == "дюйм"){
                //result = result*1.57828;
                textField1.setText(String.valueOf(result*1.57828));
                textField.setText("");
            }
            if(temp == "ярд"){
                //result = result*0.000568182;
                textField1.setText(String.valueOf(result*0.000568182));
                textField.setText("");
            }
        }
        if(e.getSource() == convertButtons[4]&& textField.getText() != ""){
            //-----------длина в дюймах
            if(temp == "метр"){
                //result = result/39.37;
                textField1.setText(String.valueOf(result/39.37));
                textField.setText("");
            }
            if(temp == "фут"){
                //result = result*12;
                textField1.setText(String.valueOf(result*12));
                textField.setText("");
            }
            if(temp == "миля"){
                //result = result*63360;
                textField1.setText(String.valueOf(result*63360));
                textField.setText("");
            }
            if(temp == "ярд"){
                //result = result*36;
                textField1.setText(String.valueOf(result*36));
                textField.setText("");
            }
        }
        if(e.getSource() == convertButtons[1] && textField.getText() != ""){
            //----------длина в ярдах
            if(temp == "метр"){
                //result = result/1.09361;
                textField1.setText(String.valueOf(result/1.09361));
                textField.setText("");
            }
            if(temp == "фут"){
                //result = result*0.333333;
                textField1.setText(String.valueOf(result*0.333333));
                textField.setText("");
            }
            if(temp == "миля"){
                //result = result*1760;
                textField1.setText(String.valueOf(result*1760));
                textField.setText("");
            }
            if(temp == "дюйм"){
                //result = result*0.0277778;
                textField1.setText(String.valueOf(result*0.0277778));
                textField.setText("");
            }
        }
        if(e.getSource() == convertButtons[0] && textField.getText() != ""){
            //--------------длина в футах
            if(temp == "метр"){
                //result = result/0.3048;
                textField1.setText(String.valueOf(result/0.3048));
                textField.setText("");
            }
            if(temp == "дюйм"){
                //result = result*0.0833333;
                textField1.setText(String.valueOf(result*0.0833333));
                textField.setText("");
            }
            if(temp == "миля"){
                //result = result*5280;
                textField1.setText(String.valueOf(result*5280));
                textField.setText("");
            }
            if(temp == "ярд"){
                //result = result*3;
                textField1.setText(String.valueOf(result*3));
                textField.setText("");
            }
        }
    }
    void mousePressed(MouseEvent e){
        if(e.getSource() == textField){
            text = true;
        }

    }
}
