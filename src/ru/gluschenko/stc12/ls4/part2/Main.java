package ru.gluschenko.stc12.ls4.part2;

import ru.gluschenko.stc12.ls4.NotNumberException;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] initArray = new Object[10];
        initArray[0] = 7;
        initArray[1] = 1;
        initArray[2] = 2;
        initArray[3] = 2;
        initArray[4] = 19;
        // для проверки NotNumberException раскомментировать строку ниже
        // initArray[5] = "24";
        initArray[6] = 72;
        initArray[7] = 67;
        initArray[8] = null;
        initArray[9] = -3;

        System.out.println("initArray for intBox:"+ Arrays.toString(initArray));
        System.out.println("------------------------");
        MathBox intBox = new MathBox<Integer>();
        try {
            intBox.setList(initArray);
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }

        try {
            intBox.addObject("a25");
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }
        System.out.println("intBox.dump():"+intBox.dump());

        try {
            System.out.println("try to delete object 2");
            intBox.deleteObject(2);
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }
        System.out.println("intBox.dump():"+intBox.dump());
        System.out.println("intBox.summator():"+intBox.summator());
        System.out.println("intBox.splitter(2):"+intBox.splitter(2));
        System.out.println("intBox.splitter(3):"+intBox.splitter(3));


        System.out.println("------------------------");
        System.out.println("------------------------");
        initArray[1] = 1.09;
        initArray[2] = 2.567;
        initArray[3] = 2.567;
        initArray[5] = 24.0;
        initArray[6] = 24;
        System.out.println("initArray for doubleBox:"+ Arrays.toString(initArray));
        System.out.println("------------------------");
        MathBox doubleBox = new MathBox<Double>();
        try {
            doubleBox.setList(initArray);
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }

        try {
            doubleBox.addObject("a25");
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }
        System.out.println("intBox.dump():"+doubleBox.dump());

        try {
            System.out.println("try to delete object 19");
            doubleBox.deleteObject(19);
        }
        catch (ru.gluschenko.stc12.ls4.NotNumberException e){
            System.out.println(e.getMessage());
        }
        System.out.println("doubleBox.dump():"+doubleBox.dump());

        //тест дает не то что хочется из-за того что не приводим к нужному типу
        try {
            System.out.println("try to delete object 24.0");
            doubleBox.deleteObject(24.0);
        }
        catch (NotNumberException e){
            System.out.println(e.getMessage());
        }
        System.out.println("doubleBox.dump():"+doubleBox.dump());
        System.out.println("doubleBox.summator():"+doubleBox.summator());
        System.out.println("doubleBox.splitter(2):"+doubleBox.splitter(2));
        System.out.println("doubleBox.splitter(3):"+doubleBox.splitter(3));
    }
}
