package com.example.calculator.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.calculator.R;
import com.example.calculator.presenter.CalculatorPresenter;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView
{

    private TextView numberDisplay;
    private ViewGroup buttonGrid;

    CalculatorPresenter presenter = new CalculatorPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.calculatorlayout);
        numberDisplay = (TextView) findViewById(R.id.textdisplay);
        buttonGrid = (ViewGroup) findViewById(R.id.gridLayout);

        presenter.onCreate();
    }
    @Override
    protected void onPause() {

        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void onButtonClicked(View v)
    {
        String button_name = v.getTag().toString();

        presenter.onButtonClicked(button_name);
    }

    public void showDisplay(String textToBeDisplayed)
    {
        TextView textView = (TextView) findViewById(R.id.textdisplay);
        textView.setText(textToBeDisplayed);
        textView.setVisibility(View.VISIBLE);
    }

    public void onClearDisplay(View v)
    {
        presenter.onClearClicked();
        numberDisplay.setText("");
    }
}
