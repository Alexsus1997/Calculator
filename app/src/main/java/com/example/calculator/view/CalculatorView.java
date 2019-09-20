package com.example.calculator.view;

import android.view.View;

public interface CalculatorView
{
    void onButtonClicked(View v);
    void showDisplay(String textToBeDisplayed, String operatorToBeDisplayed);
    void onClearDisplay(View v);
}
