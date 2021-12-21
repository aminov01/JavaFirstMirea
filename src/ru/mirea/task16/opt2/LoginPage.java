package ru.mirea.task16.opt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("userId:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();
    JLabel image = new JLabel();
    ImageIcon icon = new ImageIcon("C:/Users/shahboz/OneDrive/Документы/Images/app_image3.jpg");
    HashMap<String,String> logInInfo = new HashMap<String,String>();

    LoginPage(HashMap<String,String> loginInfoOriginal){
        logInInfo = loginInfoOriginal;

        loginButton.setFocusable(false);
        resetButton.setFocusable(false);

        image.setSize(350,300);
        image.setIcon(icon);

        userIdLabel.setBounds(40,100,90,25);
        userIdLabel.setFont(new Font(null,Font.PLAIN,18));
        userPasswordLabel.setBounds(20,150,90,25);
        userPasswordLabel.setFont(new Font(null,Font.PLAIN,18));

        messageLabel.setBounds(105,250,250,25);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIdField.setBounds(105,100,200,25);
        userPasswordField.setBounds(105,150,200,25);

        loginButton.setBounds(105,200,100,25);
        loginButton.addActionListener(this);
        resetButton.setBounds(205,200,100,25);
        resetButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(image);
        frame.setSize(350, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Information info = new Information();

        if(e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource() == loginButton){
            IDandPasswords iDandPasswords = new IDandPasswords();
            try {
                FileReader fr = new FileReader(info.file);
                BufferedReader reader = new BufferedReader(fr);
                String line0 = reader.readLine();
                String line1 = reader.readLine();
                String line2 = reader.readLine();
                iDandPasswords.loginInfo1.put(line1, line2);
                while (line1 != null && line2 != null) {
                    iDandPasswords.loginInfo1.put(line1, line2);
                    line1 = reader.readLine();
                    line2 = reader.readLine();
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            String userId = userIdField.getText();
            String password = String.copyValueOf(userPasswordField.getPassword());
            if(iDandPasswords.loginInfo1.containsKey(userId)){
                if(iDandPasswords.loginInfo1.get(userId).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userId);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password!");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found!");
            }
        }

    }
    public static void main(String[] args){
        IDandPasswords iDandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());
    }
}
