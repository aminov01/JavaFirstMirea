package ru.mirea.task16.opt2;

import java.io.*;
import java.util.Scanner;

public class Messages {
    File file = new File("Messages.txt");
    //WelcomePage welcomePage = new WelcomePage("");
    void Information(){
        try {
            if(!file.exists())
                file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
