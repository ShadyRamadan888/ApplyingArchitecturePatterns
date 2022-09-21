package com.example.applyarchitecturepatterns.ui;

import com.example.applyarchitecturepatterns.pojo.NumberModel;

public class NumberPresenter {

    private NumberModel numberModelObj;
    private DataBase getDataObj = new DataBase();
    NumberView view;

    public NumberPresenter(NumberView view) {
        this.view = view;
    }

    public String getNumbersFromDatabase()
    {
        numberModelObj = getDataObj.getNumbers();
        int divResult = numberModelObj.getFirstNum() / numberModelObj.getSecondNum();
        return String.valueOf(divResult);
    }

    public void getDiv()
    {
        String s = getNumbersFromDatabase();
        view.onGetNumbers(s);
    }
}
