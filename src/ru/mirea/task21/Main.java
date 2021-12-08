package ru.mirea.task21;
public class Main {
    public static void main (String [] args){
        final Info<String> name1=new Info<>("Аминзода Шахбоз Бахром");
        final Info<Integer> data1=new Info<>(1979);
        final Info<String> name2=new Info<>("Аминов Саидамин");
        final Info<Integer> data2=new Info<>(1996);
        System.out.println("Данные обслуживающего сотрудника:\n"+name1.getInfo()+" "+data1.getInfo()+"г.");
        System.out.println("Данные пользователя:\n"+name2.getInfo()+" "+data2.getInfo()+"г.");
    }
}