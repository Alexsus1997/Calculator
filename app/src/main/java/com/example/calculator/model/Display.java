package com.example.calculator.model;
import java.math.*;

public class Display
{
    private double CurrentNumber;
    private double PreviousNumber;
    private double Result;
    private String CurrentDisplay = "";
    private String CurrentOperation = "";

    private Boolean PointFlag;
    private Boolean NegativeSignFlag;
    private Boolean OperatorFlag;

    
    //Button Variable initialization
    static final String NINE   = "number_9";
    static final String EIGHT  = "number_8";
    static final String SEVEN  = "number_7";
    static final String SIX    = "number_6";
    static final String FIVE   = "number_5";
    static final String FOUR   = "number_4";
    static final String THREE  = "number_3";
    static final String TWO    = "number_2";
    static final String ONE    = "number_1";
    static final String ZERO   = "number_0";

    static final String NEGATIVESIGN   = "negativeSign";
    static final String PERIOD         = "periodNotation";
    static final String EQUALSIGN      = "equalSign";

    static final String DIVISION       = "divisionSign" ;
    static final String MULTIPLICATION = "multiplicationSign" ;
    static final String ADDITION       = "plusSign";
    static final String SUBTRACTION    = "subtractSign";

    static final String DELETE = "deleteButton";
    
    TextDisplay textDisplay = new TextDisplay();


    public Display()
    {
        CurrentNumber       = 0;
        PreviousNumber      = 0;
        Result              = 0;
        PointFlag           = Boolean.FALSE;
        NegativeSignFlag    = Boolean.FALSE;
        OperatorFlag        = Boolean.FALSE;
    }


    public String performOperation(double firstNumber, double secondNumber, String Operation)
    {
        switch (Operation)
        {
            case ADDITION:
                Result = firstNumber + secondNumber;
                break;

            case SUBTRACTION:
                Result = firstNumber - secondNumber;
                break;

            case MULTIPLICATION:
                Result = firstNumber * secondNumber;
                break;

            case DIVISION:
                Result = firstNumber / secondNumber;
                break;

                default:
                break;
        }


        if(Result < 1000 && Result > 0.0001)
        {
            Result = BigDecimal.valueOf(Result)
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();
        }

       return (Double.toString(Result));

    }

    public TextDisplay selectButton(String buttonTag)
    {
        switch (buttonTag)
        {
            case NINE:
                CurrentDisplay = CurrentDisplay.concat("9");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case EIGHT:
                CurrentDisplay = CurrentDisplay.concat("8");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case SEVEN:
                CurrentDisplay = CurrentDisplay.concat("7");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case SIX:
                CurrentDisplay = CurrentDisplay.concat("6");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case FIVE:
                CurrentDisplay = CurrentDisplay.concat("5");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case FOUR:
                CurrentDisplay = CurrentDisplay.concat("4");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case THREE:
                CurrentDisplay = CurrentDisplay.concat("3");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case TWO:
                CurrentDisplay = CurrentDisplay.concat("2");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case ONE:
                CurrentDisplay = CurrentDisplay.concat("1");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();
                break;
            case ZERO:
                CurrentDisplay = CurrentDisplay.concat("0");
                CurrentNumber = Double.parseDouble(CurrentDisplay);
                checkForNegativeSign();

                break;

            case NEGATIVESIGN:
                //It will only add a negative sign if CurrentDisplay is empty since we want it to be added at the beginning
                if(CurrentDisplay.isEmpty())
                {
                    if(NegativeSignFlag == Boolean.FALSE)
                    {
                        NegativeSignFlag = Boolean.TRUE;
                    }
                }
                break;

            case PERIOD:
                if(!CurrentDisplay.isEmpty())
                {
                    //If CurrentDisplay already has a number
                    if(PointFlag == Boolean.FALSE)
                    {
                        CurrentDisplay = CurrentDisplay.concat(".");
                    }
                    CurrentNumber = Double.parseDouble(CurrentDisplay);
                    PointFlag = Boolean.TRUE;

                }
                else
                {
                    //If CurrentDisplay doesn't have a number. Add a zero
                    if(PointFlag == Boolean.FALSE)
                    {
                        CurrentDisplay = CurrentDisplay.concat("0.");
                    }
                    CurrentNumber = Double.parseDouble(CurrentDisplay);
                    PointFlag = Boolean.TRUE;
                }

                break;

            case DELETE:
                if(!CurrentDisplay.isEmpty())
                {
                    CurrentDisplay = CurrentDisplay.substring(0, CurrentDisplay.length() - 1);
                    if(!CurrentDisplay.isEmpty())
                    {
                        CurrentNumber = Double.parseDouble(CurrentDisplay);
                    }
                }
                break;


            case ADDITION:

                if(OperatorFlag == Boolean.FALSE)
                {
                    OperatorFlag = Boolean.TRUE;
                    PreviousNumber = CurrentNumber;
                    CurrentDisplay = "";
                }
                else
                {
                    CurrentDisplay = checkForIntegerNumber(performOperation(PreviousNumber, CurrentNumber, ADDITION));
                    PreviousNumber = Double.parseDouble(CurrentDisplay);
                    OperatorFlag   = Boolean.FALSE;
                }
                CurrentNumber = 0;
                CurrentOperation = ADDITION;
                PointFlag = Boolean.FALSE;

                break;


            case SUBTRACTION:

                if(OperatorFlag == Boolean.FALSE)
                {
                    OperatorFlag = Boolean.TRUE;
                    PreviousNumber = CurrentNumber;
                    CurrentDisplay = "";
                }
                else
                {
                    CurrentDisplay = checkForIntegerNumber(performOperation(PreviousNumber, CurrentNumber, SUBTRACTION));
                    PreviousNumber = Double.parseDouble(CurrentDisplay);
                    OperatorFlag   = Boolean.FALSE;
                }
                CurrentNumber = 0;
                CurrentOperation = SUBTRACTION;
                PointFlag = Boolean.FALSE;

                break;

            case MULTIPLICATION:

                if(OperatorFlag == Boolean.FALSE)
                {
                    OperatorFlag = Boolean.TRUE;
                    PreviousNumber = CurrentNumber;
                    CurrentDisplay = "";
                }
                else
                {
                    CurrentDisplay = checkForIntegerNumber(performOperation(PreviousNumber, CurrentNumber, MULTIPLICATION));
                    PreviousNumber = Double.parseDouble(CurrentDisplay);
                    OperatorFlag   = Boolean.FALSE;
                }
                CurrentNumber = 1;
                CurrentOperation = MULTIPLICATION;
                PointFlag = Boolean.FALSE;
                break;

            case DIVISION:

                if(OperatorFlag == Boolean.FALSE)
                {
                    OperatorFlag = Boolean.TRUE;
                    PreviousNumber = CurrentNumber;
                    CurrentDisplay = "";
                }
                else
                {
                    CurrentDisplay = checkForIntegerNumber(performOperation(PreviousNumber, CurrentNumber, DIVISION));
                    PreviousNumber = Double.parseDouble(CurrentDisplay);
                    OperatorFlag   = Boolean.FALSE;
                }
                CurrentNumber = 1;
                CurrentOperation = DIVISION;
                PointFlag = Boolean.FALSE;
                break;




            case EQUALSIGN:
                CurrentDisplay = performOperation(PreviousNumber, CurrentNumber, CurrentOperation);
                CurrentOperation = "";
                PointFlag = Boolean.FALSE;
                OperatorFlag = Boolean.FALSE;

                //If last two characters are '.0' then number is integer so it chops last two characters
                CurrentDisplay = checkForIntegerNumber(CurrentDisplay);

                break;

                default:
                    break;
        }

        textDisplay.CurrentDisplay      = this.CurrentDisplay;
        textDisplay.CurrentOperation    = this.CurrentOperation;

        return textDisplay;
    }
    public void clear()
    {
        CurrentDisplay      = "";
        CurrentNumber       = 0;
        CurrentOperation    = "";
        PreviousNumber      = 0;
        Result              = 0;
        PointFlag           = Boolean.FALSE;
        NegativeSignFlag    = Boolean.FALSE;
        OperatorFlag        = Boolean.FALSE;
    }

   public void checkForNegativeSign()
    {
        if(NegativeSignFlag == Boolean.TRUE)
        {
            CurrentDisplay = "-" + CurrentDisplay;
            NegativeSignFlag = Boolean.FALSE;
        }
    }

    public String checkForIntegerNumber(String NumberToCheck)
    {
        //If last two characters are '.0' then number is integer so it chops last two characters
        if (NumberToCheck.charAt(NumberToCheck.length() - 1) == '0' && NumberToCheck.charAt(NumberToCheck.length() - 2) == '.')
        {
            NumberToCheck = NumberToCheck.substring(0, NumberToCheck.length() - 2);
        }
        return NumberToCheck;
    }
}
