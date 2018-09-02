package ru.gluschenko.stc12.ls4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectBox<T extends Number>{
    private List<T> list = new ArrayList<>();

    ObjectBox(){

    }

    void setList(Object[] initArray) throws NotNumberException{
        for(Object element : initArray){
            //почему тут не приводит к типу?
            this.addObject((T)element);
        }
    }

    Number summator(){
        Number result = BigDecimal.ZERO;
        for(Number e : this.list){
            result = result.doubleValue() + e.doubleValue();
        }
        return result;
    }

    ArrayList<Double> splitter(Integer divider){
        ArrayList<Double> splittedList = new ArrayList<>();
        if(divider == null || divider == 0) {
            for (Number e : this.list) {
                splittedList.add(null);
            }
            return splittedList;
        }

        double ddivider = (double) divider;
        for (Number e : this.list) {
            // почему здесь не работает (double)e ?
            splittedList.add(e.doubleValue()/ddivider);
        }
        return splittedList;
    }

    boolean addObject(Object element) throws NotNumberException{
        if(element == null){
            return false;
        }
        if (!(element instanceof Number)){
            throw new NotNumberException(element.toString());
        }
        // почему тут не приводит к типу T? из-за этого в тестах на double мы не удаляем 24.0
        // хотя с точки зрения пользователся 24 и 24.0 одинаковые числа
        if(this.list.contains((T)element)){
            return false;
        }
        this.list.add((T)element);
        return true;
    }

    boolean deleteObject(Object element) throws NotNumberException{
        if(element == null){
            return false;
        }
        if (!(element instanceof Number)){
            throw new NotNumberException(element.toString());
        }

        if(this.list.contains(element)){
            this.list.remove(element);
            return true;
        }
        return false;
    }

    public String dump(){
        return this.toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.list.toArray());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (T e : this.list)
            hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
        return hashCode;
    }

    public final boolean equals(ObjectBox o) {
        if (o == null)
            return false;

        if (o == this)
            return true;

        return this.toString().equals(o.toString());
    }

}
