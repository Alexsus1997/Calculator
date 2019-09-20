package com.example.calculator.presenter;

import com.example.calculator.view.CalculatorView;
import com.example.calculator.model.Display;

public class CalculatorPresenter implements Presenter
{
    private CalculatorView view;
    private Display model;

    public CalculatorPresenter(CalculatorView view)
    {
        this.view = view;
        this.model = new Display();
    }

    public void onCreate() {
        model = new Display();
    }

    public void onPause() {

    }

    public void onResume() {

    }

    public void onDestroy() {

    }

    public void onButtonClicked(String buttonTag)
    {
        //Perform tasks when buttons are clicked
        //Bridge between Model logic and View button setter
        String textToDisplay;

        textToDisplay = model.selectButton(buttonTag); //String


        if(buttonTag == "clearButton")
        {
            onClearClicked();
        }
        view.showDisplay(textToDisplay);



    }

    public void onClearClicked()
    {
        model.clear();
    }

}
