package com.example.calculator.presenter;

import com.example.calculator.model.TextDisplay;
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
       TextDisplay display = new TextDisplay();
       display =   model.selectButton(buttonTag);

        //textToDisplay       = model.selectButton(buttonTag).CurrentDisplay; //String

        //display.CurrentDisplay   = model.selectButton(buttonTag).CurrentOperation; //String

        switch(display.CurrentOperation)
        {
            case "divisionSign":
                display.CurrentOperation = "/";
                break;
            case "multiplicationSign":
                display.CurrentOperation= "x";
                break;
            case "plusSign":
                display.CurrentOperation = "+";
                break;
            case "subtractSign":
                display.CurrentOperation = "-";
                break;
            default:
                display.CurrentOperation = "";
                break;
        }
        view.showDisplay(display.CurrentDisplay, display.CurrentOperation);

    }

    public void onClearClicked()
    {
        model.clear();
    }

}
