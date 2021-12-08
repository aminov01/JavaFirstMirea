package ru.mirea.task21;
public class Info<T> {
    private final T info;

    public Info(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
}
