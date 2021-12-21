package ru.mirea.task16.opt2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;

public class SignUpPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton signUpButton = new JButton("SignUp");
    JButton resetButton = new JButton("reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("userId:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();
    JLabel image = new JLabel();
    ImageIcon icon = new ImageIcon("C:/Users/shahboz/OneDrive/Документы/Images/app_image4.jpg");
    HashMap<String,String> logInInfo = new HashMap<String,String>();

    SignUpPage(HashMap<String,String> loginInfoOriginal){
        logInInfo = loginInfoOriginal;

        signUpButton.setFocusable(false);
        resetButton.setFocusable(false);

        image.setSize(350,270);
        image.setIcon(icon);

        userIdLabel.setBounds(30,100,95,25);
        userIdLabel.setFont(new Font(null,Font.PLAIN,18));
        userPasswordLabel.setBounds(30,150,95,25);
        userPasswordLabel.setFont(new Font(null,Font.PLAIN,18));

        messageLabel.setBounds(125,250,250,25);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        signUpButton.setBounds(125,200,100,25);
        signUpButton.addActionListener(this);
        resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(signUpButton);
        frame.add(resetButton);
        frame.add(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
        }
        String s = userIdField.getText();
        String s1 = String.copyValueOf(userPasswordField.getPassword());
        Information info = new Information();
        //-----------------------------------------
        try {
            FileWriter writer = new FileWriter(info.file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(s);
            bufferWriter.write("\n");
            bufferWriter.write(s1);
            bufferWriter.write("\n");
            bufferWriter.close();
        }
        catch (IOException e2) {
            System.out.println(e2);
        }
        //--------------------------------------------------------
        if(e.getSource() == signUpButton){
            IDandPasswords iDandPasswords = new IDandPasswords();
            info.Reading();
            if(userIdField.getText() != "" && String.copyValueOf(userPasswordField.getPassword()) != ""){
                frame.dispose();
                LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());
            }

        }

    }

    public static void main(String[] args){
        IDandPasswords iDandPasswords = new IDandPasswords();

        SignUpPage signUpPage = new SignUpPage(iDandPasswords.getLoginInfo());
    }
}

