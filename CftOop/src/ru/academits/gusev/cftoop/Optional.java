package ru.academits.gusev.cftoop;


public class Optional<T> {
    private T value;
    private boolean hasValue;

    public Optional(){
    }

    public Optional(T value){
        this.value = value;
        hasValue = true;
    }

    public T get(){
        if (!hasValue){
            throw new MyException("Не введен тип");
        }
        return value;
    }


}
