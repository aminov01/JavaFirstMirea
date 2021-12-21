package ru.mirea.task16.opt1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyTime {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println(calendar.getTime());
        int year = 2001;
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.minusYears(year).getYear());
        System.out.println(localDate.getYear());
        int a = 10;
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        String s = "";
        try{
            a = a / b;
        }catch (ArithmeticException e){
            s = "на ноль делить делить нельзя!";
        }
        System.out.println(s);
        System.out.println(s.length());
    }
}
