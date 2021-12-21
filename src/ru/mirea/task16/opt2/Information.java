package ru.mirea.task16.opt2;

import java.io.*;

public class Information {
    File file = new File("Information.txt");
    //String str = "hello";
    void Information(){
        try {
            if(!file.exists())
                file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------
    void Reading(){
        IDandPasswords iDandPasswords = new IDandPasswords();
        try {
            FileReader fr = new FileReader(file);
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
    }
    //--------------------------------

    public static void main(String[] args){
        Information info = new Information();
        info.Information();
        info.Reading();
    }
}
