package ru.mirea.task16.opt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WelcomePage implements ActionListener {
    //--------------------------------------работа с файлами
    Messages messages = new Messages();
    Scanner scanner;
    //--------------------------------------
    Date date = new Date();
    JLabel time = new JLabel();
    JScrollPane scrollPane = new JScrollPane();
    JFrame frame = new JFrame("Social media");
    JButton button = new JButton("send");
    JTextField textField = new JTextField();
    final JTextArea messageField = new JTextArea(10,15);
    ImageIcon icon = new ImageIcon("C:/Users/shahboz/OneDrive/Документы/Images/app_image7.jpg");
    JLabel welcomeLable = new JLabel();
    JLabel image = new JLabel();
    WelcomePage(String userId){
        scrollPane = new JScrollPane(messageField);
        scrollPane.setBounds(40,40,320,360);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        welcomeLable.setBounds(0,0,270,35);
        image.setSize(400,500);
        textField.setBounds(40,400,250,35);
        button.setBounds(290,400, 70,35);
        button.setFocusable(false);
        messageField.setEditable(false);
        button.addActionListener(this);
        welcomeLable.setFont(new Font(null,Font.PLAIN, 22));
        textField.setFont(new Font(null,Font.PLAIN, 22));
        messageField.setFont(new Font(null,Font.PLAIN, 18));
        messageField.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font(null,Font.PLAIN, 14));
        welcomeLable.setText("Welcome " + userId);
        image.setIcon(icon);
        time.setBounds(270,0,95,35);
        time.setFont(new Font(null, Font.ITALIC,18));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        time.setText(simpleDateFormat.format(date));
        //-----------------------------------------------------------работа с файлами
        try {
            scanner = new Scanner(messages.file);
            scanner.useDelimiter("\\A");
            if (scanner.hasNext()) {
                messageField.setText(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(time);
        frame.add(scrollPane);
        frame.add(button);
        frame.add(welcomeLable);
        frame.add(image);
        frame.add(textField);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    String message;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            message = textField.getText();
            messageField.append(message);
            messageField.append("\n");
            //-------------------------------------------------------------
            messages.Information();
            String str;
            str = textField.getText();
            try {
                FileWriter writer = new FileWriter(messages.file, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(str);
                bufferWriter.write("\n");
                bufferWriter.close();
            }
            catch (IOException e2) {
                System.out.println(e2);
            }
            //-------------------------------------------------------------
            textField.setText("");
        }


    }

    public static void main(String[] args){
        WelcomePage welcomePage = new WelcomePage(" ");

    }

}
