package com.example.applyarchitecturepatterns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.applyarchitecturepatterns.databinding.ActivityMainBinding;
import com.example.applyarchitecturepatterns.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,NumberView {

    private ActivityMainBinding binding;
    private DataBase getDataObj;
    private NumberModel numberModelObj;
    private NumberPresenter presenter;
    private NumbersViewModel numbersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Using ViewBinding
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        binding.mulButton.setOnClickListener(this);


        presenter = new NumberPresenter(this);


        //Using ViewModel
        numbersViewModel = new NumbersViewModel();
        numbersViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.mulResultTextView.setText(s);
            }
        });


    }

    //Using MVC (Model View Controller) Architecture Pattern
    //I used it only with summation process
    public void getDataFromDatabase()
    {
        getDataObj = new DataBase();
        numberModelObj = getDataObj.getNumbers();
    }
    public void plusOperationAndSetValue()
    {
        getDataFromDatabase();
        int plusResult = numberModelObj.getFirstNum() + numberModelObj.getSecondNum();
        binding.plusResultTextView.setText(String.valueOf(plusResult));
    }

    //Using MVP (Model View Presenter) Architecture Pattern
    //I used it only with division process
    //By NumberPresenter class and NumberView interface
    @Override
    public void onGetNumbers(String result) {
        binding.divResultTextView.setText(result);
    }

    @Override
    public void onClick(View view) {

       if (view.getId() == binding.divButton.getId())
       {
           presenter.getDiv();
       }
       else if(view.getId() == binding.plusButton.getId())
       {
           plusOperationAndSetValue();
       }else if(view.getId() == binding.mulButton.getId())
       {
           numbersViewModel.getResult();
       }
    }


}