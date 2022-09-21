package com.example.applyarchitecturepatterns.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applyarchitecturepatterns.pojo.NumberModel;

public class NumbersViewModel extends ViewModel {

    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
    private NumberModel numberModelObj;
    private DataBase getDataObj = new DataBase();

    private String getNumbersFromDatabase()
    {
        numberModelObj = getDataObj.getNumbers();
        int divResult = numberModelObj.getFirstNum() * numberModelObj.getSecondNum();
        return String.valueOf(divResult);
    }
    public void getResult()
    {
        mutableLiveData.setValue(getNumbersFromDatabase());
    }
}
