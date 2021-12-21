package ru.mirea.task16.opt2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class IDandPasswords implements Serializable {
    HashMap<String, String> loginInfo1 = new HashMap<String,String>();
    IDandPasswords(){
        loginInfo1.put("Shahboz", "aminov");
    }
    HashMap getLoginInfo(){
        return loginInfo1;
    }
}
