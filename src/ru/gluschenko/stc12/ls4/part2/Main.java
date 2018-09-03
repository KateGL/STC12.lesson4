package ru.gluschenko.stc12.ls4.part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //тут берем инициализирующий массив одного типа
        Number[] initArrayInteger = new Integer[10];
        initArrayInteger[0] = 7;
        initArrayInteger[1] = 1;
        initArrayInteger[2] = 2;
        initArrayInteger[3] = 2;
        initArrayInteger[4] = 19;
        initArrayInteger[6] = 72;
        initArrayInteger[7] = 67;
        initArrayInteger[8] = null;
        initArrayInteger[9] = -3;
        System.out.println("------------------------");
        System.out.println("Integer------------------------");
        System.out.println("initArrayInteger for intOnlyBox:"+ Arrays.toString(initArrayInteger));
        System.out.println("------------------------");
        MathBox intOnlyBox = new MathBox<Integer>();
        intOnlyBox.setList(initArrayInteger);
        System.out.println("intOnlyBox.dump():"+intOnlyBox.dump());
        System.out.println("try to delete object 2");
        intOnlyBox.deleteObject(2);
        System.out.println("intOnlyBox.dump():"+intOnlyBox.dump());
        System.out.println("intOnlyBox.summator():"+intOnlyBox.summator());
        System.out.println("intOnlyBox.splitter(2):"+intOnlyBox.splitter(2));
        System.out.println("intOnlyBox.splitter(3):"+intOnlyBox.splitter(3));

        Number[] initArrayDouble = new Double[10];
        initArrayDouble[0] = 7.0;
        initArrayDouble[1] = 1.0;
        initArrayDouble[2] = 2.0;
        initArrayDouble[3] = 2.0;
        initArrayDouble[4] = 19.0;
        initArrayDouble[6] = 72.0;
        initArrayDouble[7] = 67.0;
        initArrayDouble[8] = null;
        initArrayDouble[9] = -3.0;
        System.out.println("------------------------");
        System.out.println("Double------------------------");
        System.out.println("initArrayDouble for dblOnlyBox:"+ Arrays.toString(initArrayDouble));
        System.out.println("------------------------");
        MathBox dblOnlyBox = new MathBox<Double>();
        dblOnlyBox.setList(initArrayDouble);
        System.out.println("dblOnlyBox.dump():"+dblOnlyBox.dump());
        System.out.println("try to delete object 2");
        dblOnlyBox.deleteObject(2);
        System.out.println("dblOnlyBox.dump():"+dblOnlyBox.dump());
        System.out.println("dblOnlyBox.summator():"+dblOnlyBox.summator());
        System.out.println("dblOnlyBox.splitter(2):"+dblOnlyBox.splitter(2));
        System.out.println("dblOnlyBox.splitter(3):"+dblOnlyBox.splitter(3));


        System.out.println("------------------------");
        System.out.println("Number------------------------");
        //----------тут эксперименты с Number когда в коллекции могут идти вперемешку integer и double, например.
        // в этом случае много проблем
        Number[] initArray = new Number[10];
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
        intBox.setList(initArray);


        //intBox.addObject("a25");
        System.out.println("intBox.dump():"+intBox.dump());


        System.out.println("try to delete object 2");
        intBox.deleteObject(2);

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

        doubleBox.setList(initArray);

        //doubleBox.addObject("a25");

        System.out.println("intBox.dump():"+doubleBox.dump());


        System.out.println("try to delete object 19");
        doubleBox.deleteObject(19);

        System.out.println("doubleBox.dump():"+doubleBox.dump());

        //тест дает не то что хочется из-за того что не приводим к нужному типу
        System.out.println("try to delete object 24.0");
        doubleBox.deleteObject(24.0);

        System.out.println("doubleBox.dump():"+doubleBox.dump());
        System.out.println("doubleBox.summator():"+doubleBox.summator());
        System.out.println("doubleBox.splitter(2):"+doubleBox.splitter(2));
        System.out.println("doubleBox.splitter(3):"+doubleBox.splitter(3));
    }
}
