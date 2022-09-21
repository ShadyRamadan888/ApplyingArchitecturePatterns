package com.example.applyarchitecturepatterns.ui;

import com.example.applyarchitecturepatterns.pojo.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
