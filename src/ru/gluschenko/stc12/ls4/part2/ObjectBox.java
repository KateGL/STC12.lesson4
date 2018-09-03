package ru.gluschenko.stc12.ls4.part2;

import java.util.*;

public class ObjectBox<T extends Number>{
    //почему здесь пишет Warning:(9, 5) Access can be package-private ?
    protected List<T> list = new ArrayList<>();

    ObjectBox(){

    }

    void setList(T[] initArray){
        for(T element : initArray){
            this.addObject(element);
        }
        Collections.sort(this.list, new NumberComparator());
    }

    boolean addObject(T element){
        if(element == null){
            return false;
        }

        if(this.list.contains(element)){
            return false;
        }
        this.list.add(element);
        return true;
    }

    boolean deleteObject(T element){
        if(element == null){
            return false;
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


class NumberComparator<T extends Number> implements Comparator<T> {

    public int compare(T a, T b){
        if (a instanceof Comparable) {
            return ((Comparable<T>) a).compareTo(b);
        }
        throw new UnsupportedOperationException();
    }
}