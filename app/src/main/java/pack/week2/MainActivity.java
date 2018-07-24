package pack.week2;

import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    Button B0, B1, B2, B3, B4, B5, B6, B7, B8, B9;
    Button BReset, BChange, BPercent, BDivide, BTimes, BMinus, BPlus, BPoint, BEqual;
    TextView TExpression, TResult;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInit();

    }

    void ViewInit()
    {
        //找到元件位置Start
        TExpression = findViewById(R.id.TExpression);
        TResult = findViewById(R.id.TResult);
        B0 = findViewById(R.id.B0);
        B1 = findViewById(R.id.B1);
        B2 = findViewById(R.id.B2);
        B3 = findViewById(R.id.B3);
        B4 = findViewById(R.id.B4);
        B5 = findViewById(R.id.B5);
        B6 = findViewById(R.id.B6);
        B7 = findViewById(R.id.B7);
        B8 = findViewById(R.id.B8);
        B9 = findViewById(R.id.B9);
        BReset = findViewById(R.id.BReset);
        BChange = findViewById(R.id.BChange);
        BPercent = findViewById(R.id.BPercent);
        BDivide = findViewById(R.id.BDivide);
        BTimes = findViewById(R.id.BTimes);
        BMinus = findViewById(R.id.BMinus);
        BPlus = findViewById(R.id.BPlus);
        BPoint = findViewById(R.id.BPoint);
        BEqual = findViewById(R.id.BEqual);
        //找到元件位置End

        //設定監聽Start
        B0.setOnClickListener(Button_Click);
        B1.setOnClickListener(Button_Click);
        B2.setOnClickListener(Button_Click);
        B3.setOnClickListener(Button_Click);
        B4.setOnClickListener(Button_Click);
        B5.setOnClickListener(Button_Click);
        B6.setOnClickListener(Button_Click);
        B7.setOnClickListener(Button_Click);
        B8.setOnClickListener(Button_Click);
        B9.setOnClickListener(Button_Click);
        BReset.setOnClickListener(Button_Click);
        BChange.setOnClickListener(Button_Click);
        BPercent.setOnClickListener(Button_Click);
        BDivide.setOnClickListener(Button_Click);
        BTimes.setOnClickListener(Button_Click);
        BMinus.setOnClickListener(Button_Click);
        BPlus.setOnClickListener(Button_Click);
        BPoint.setOnClickListener(Button_Click);
        BEqual.setOnClickListener(Button_Click);
        //設定監聽End
        TExpression.setText("11+22÷2+7×3");
        //TExpression.setText("0");
        TResult.setText("0");
    }
    private static final int FIRST=0;
    private static final int NUMBER=1;
    private static final int OPERATORS=2;
    private static final int POINT=3;

    //int OldClickFlag=FIRST;
    int OldClickFlag=NUMBER;
    boolean IsPoint=false;

    int CalculatorVaule(String Expresion)
    {
        int i;
        try
        {

            for (i = 0; i < Expresion.length(); i++)    //Step 1
            {
                if (Expresion.charAt(i) == '÷' || Expresion.charAt(i) == '×')   //Step 1 找到了
                {
                    String Left = "", Right = "";
                    int j, k;
                    for (j = i - 1; j >= 0; j--)    //Step 2 11+22÷2+7×3  i 在÷的位置 所以j=4 ÷左邊的位置
                    {
                        if (Expresion.charAt(j) != '+' && Expresion.charAt(j) != '-' && Expresion.charAt(j) != '÷' && Expresion.charAt(j) != '×')
                        {
                            Left = Expresion.charAt(j) + Left;
                        }
                        else
                            break;
                    }

                    for (k = i + 1; k < Expresion.length(); k++)        //Step 2 11+22÷2+7×3  i 在÷的位置 所以k=6 ÷ 右邊的位置
                    {
                        if (Expresion.charAt(k) != '+' && Expresion.charAt(k) != '-' && Expresion.charAt(k) != '÷' && Expresion.charAt(k) != '×')
                        {
                            Right = Right + Expresion.charAt(k);
                        }
                        else
                            break;
                    }
                    float temp;
                    if (Expresion.charAt(i) == '×')     //Step 3 運算  22÷2 temp = 11
                        temp = Float.parseFloat(Left) * Float.parseFloat(Right);
                    else
                        temp = Float.parseFloat(Left) / Float.parseFloat(Right);
                    Expresion = Expresion.substring(0, j+1) + temp + Expresion.substring(k, Expresion.length()); //Step 3 取代 11+22÷2+7×3 左邊是0~2 j=2 所以 要取substring(0~3)
                    i=j;
                    Log.e("temp1", ""+Expresion); //取代完變 11+11.0+7×3
                }
            }


            float Ans=0;
            for(i=0; i<Expresion.length(); i++)         //Step 4
            {
                if(Expresion.charAt(i) == '+' || Expresion.charAt(i)=='-')  //Step 4 找到了
                {
                    String Left = "", Right = "";
                    int k;
                    Left = Expresion.substring(0, i);       //Step5 取得 +左邊的完整數: 11
                    for(k=i+1; k<Expresion.length(); k++)   //Step5 取得 +右邊的完整數: 11.0 k等於+右邊的字 = 1
                    {
                        if(Expresion.charAt(k) != '+' && Expresion.charAt(k) != '-')
                        {
                            Right=Right+Expresion.charAt(k);
                        }
                        else
                            break;
                    }
                    if(Expresion.charAt(i) == '+')      //Step6 運算
                        Ans=Float.parseFloat(Left)+Float.parseFloat(Right);
                    else
                        Ans=Float.parseFloat(Left)-Float.parseFloat(Right);
                    Expresion=Ans+Expresion.substring(k, Expresion.length());   //Step6 取代
                    Log.e("temp2", "Left "+Left +" Right "+Right+" result "+Expresion);
                    i=0; //回到Step4
                }
            }
            DecimalFormat df = new DecimalFormat("#.#######################");
            String Result=df.format(Float.parseFloat(Expresion));
            TResult.setText(Result);
        }
        catch (Exception e)
        {

        }
        return 0;
    }

    private Button.OnClickListener Button_Click = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String NewExpression="";
            if(OldClickFlag!=FIRST)
                NewExpression = TExpression.getText().toString();

            switch (view.getId())
            {
                case R.id.B0 :
                    if(OldClickFlag!=FIRST)
                        NewExpression += "0";
                    else
                        NewExpression = "0";
                    break;
                case R.id.B1 :
                    NewExpression += "1";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B2 :
                    NewExpression += "2";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B3 :
                    NewExpression += "3";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B4 :
                    NewExpression += "4";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B5 :
                    NewExpression += "5";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B6 :
                    NewExpression += "6";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B7 :
                    NewExpression += "7";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B8 :
                    NewExpression += "8";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.B9 :
                    NewExpression += "9";
                    OldClickFlag=NUMBER;
                    break;
                case R.id.BReset :
                    NewExpression="0";
                    OldClickFlag=FIRST;
                    IsPoint=false;
                    break;
                case R.id.BChange :
                    break;
                case R.id.BPercent :
                    break;
                case R.id.BDivide :
                    if(OldClickFlag==NUMBER)
                    {
                        NewExpression += "÷";
                        OldClickFlag=OPERATORS;
                        IsPoint=false;
                    }
                    else if(OldClickFlag==OPERATORS)
                    {
                        NewExpression = NewExpression.substring(0, NewExpression.length()-1) + "÷";
                        IsPoint=false;
                    }
                    break;
                case R.id.BTimes :
                    if(OldClickFlag==NUMBER)
                    {
                        NewExpression += "×";
                        OldClickFlag=OPERATORS;
                        IsPoint=false;
                    }
                    else if(OldClickFlag==OPERATORS)
                    {
                        NewExpression = NewExpression.substring(0, NewExpression.length()-1) + "×";
                        IsPoint=false;
                    }

                    break;
                case R.id.BMinus :
                    if(OldClickFlag==NUMBER)
                    {
                        NewExpression += "-";
                        OldClickFlag=OPERATORS;
                        IsPoint=false;
                    }
                    else if(OldClickFlag==OPERATORS)
                    {
                        NewExpression = NewExpression.substring(0, NewExpression.length()-1) + "-";
                        IsPoint=false;
                    }
                    break;
                case R.id.BPlus :
                    if(OldClickFlag==NUMBER)
                    {
                        NewExpression += "+";
                        OldClickFlag=OPERATORS;
                        IsPoint=false;
                    }
                    else if(OldClickFlag==OPERATORS)
                    {
                        NewExpression = NewExpression.substring(0, NewExpression.length()-1) + "+";
                        IsPoint=false;
                    }
                    break;
                case R.id.BPoint :
                    if(!IsPoint)
                    {
                        if (OldClickFlag == NUMBER)
                        {
                            NewExpression += ".";
                            IsPoint = true;
                            OldClickFlag=POINT;
                        }
                        else if (OldClickFlag == FIRST)
                        {
                            NewExpression = "0.";
                            IsPoint = true;
                            OldClickFlag=POINT;
                        }
                    }
                    break;
                case R.id.BEqual :
                    CalculatorVaule(TExpression.getText().toString());
                    OldClickFlag=FIRST;
                    break;
            }
//            Log.e("OldClickFlag", ""+OldClickFlag);
            TExpression.setText(NewExpression);
        }
    };
}
