package ru.gluschenko.stc12.ls4.part2;

import java.math.BigDecimal;
import java.util.ArrayList;

class MathBox<T extends Number> extends ObjectBox{

    Number summator(){
        Number result = BigDecimal.ZERO;
        // в классе-наследнике java не видит что у нас T extends Number
        for(Object e : this.list){
            result = result.doubleValue() + ((Number)e).doubleValue();
        }
        return result;
    }

    ArrayList<Double> splitter(Integer divider){
        ArrayList<Double> splittedList = new ArrayList<>();
        if(divider == null || divider == 0) {
            for (Object e : this.list) {
                splittedList.add(null);
            }
            return splittedList;
        }

        double ddivider = (double) divider;
        for (Object e : this.list) {
            // почему здесь не работает (double)e ?
            splittedList.add(((Number)e).doubleValue()/ddivider);
        }
        return splittedList;
    }
}
