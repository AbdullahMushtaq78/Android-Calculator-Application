package com.example.mycalculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Equation;
    private TextView Result;
    private int ModPressed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Finding The TextViews
        Equation = (TextView)findViewById(R.id.Equation);
        Result = (TextView)findViewById(R.id.Result);
        //endregion

        //region Declaring and Finding All The Buttons
        Button btnOne = (Button) findViewById(R.id.bONE);
        Button btnTan = (Button) findViewById(R.id.bTAN);
        Button btnTwo = (Button) findViewById(R.id.bTWO);
        Button btnFact = (Button) findViewById(R.id.bFACTORIAL);
        Button btnThree = (Button) findViewById(R.id.bTHREE);
        Button btnCubeRoot = (Button) findViewById(R.id.bCUBEROOT);
        Button btnFour = (Button) findViewById(R.id.bFOUR);
        Button btnSqrt = (Button) findViewById(R.id.bSQUAREROOT);
        Button btnFive = (Button) findViewById(R.id.bFIVE);
        Button btnPow = (Button) findViewById(R.id.bPOWER);
        Button btnSix = (Button) findViewById(R.id.bSIX);
        Button btnMod = (Button) findViewById(R.id.bMOD);
        Button btnSeven = (Button) findViewById(R.id.bSEVEN);
        Button btnDiv = (Button) findViewById(R.id.bDIVIDE);
        Button btnEight = (Button) findViewById(R.id.bEIGHT);
        Button btnMul = (Button) findViewById(R.id.bMULTIPLY);
        Button btnNine = (Button) findViewById(R.id.bNINE);
        Button btnSub = (Button) findViewById(R.id.bSUBTRACT);
        Button btnZero = (Button) findViewById(R.id.bZERO);
        Button btnPlus = (Button) findViewById(R.id.bPLUS);
        Button btnAC = (Button) findViewById(R.id.bAC);
        Button btnC = (Button) findViewById(R.id.bC);
        Button btnBracOpen = (Button) findViewById(R.id.bBRACKETOPEN);
        Button btnBracClose = (Button) findViewById(R.id.bBRACKETCLOSE);
        Button btnSin = (Button) findViewById(R.id.bSIN);
        Button btnCos = (Button) findViewById(R.id.bCOS);
        Button btnEqual = (Button) findViewById(R.id.bEQUAL);
        Button btnPoint = (Button) findViewById(R.id.bPOINT);
        //endregion

        //region All Click Listeners
        btnOne.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnFact.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnCubeRoot.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBracOpen.setOnClickListener(this);
        btnBracClose.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        //endregion

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.bPOINT){
            String s = Equation.getText().toString();
            if(s.charAt(s.length()-1) >='0' && s.charAt(s.length()-1) <='9'){
                s += ".";
                Equation.setText(s);
            }
        }
        else if(viewId == R.id.bONE){
            String s = Equation.getText().toString() + "1";
            Equation.setText(s);
        }
        else if(viewId == R.id.bTWO){
            String s = Equation.getText().toString() + "2";
            Equation.setText(s);
        }
        else if(viewId == R.id.bTHREE){
            String s = Equation.getText().toString() + "3";
            Equation.setText(s);
        }
        else if(viewId == R.id.bFOUR){
            String s = Equation.getText().toString() + "4";
            Equation.setText(s);
        }
        else if(viewId == R.id.bFIVE){
            String s = Equation.getText().toString() + "5";
            Equation.setText(s);
        }
        else if(viewId == R.id.bSIX){
            String s = Equation.getText().toString() + "6";
            Equation.setText(s);
        }
        else if(viewId == R.id.bSEVEN){
            String s = Equation.getText().toString() + "7";
            Equation.setText(s);
        }
        else if(viewId == R.id.bEIGHT){
            String s = Equation.getText().toString() + "8";
            Equation.setText(s);
        }
        else if(viewId == R.id.bNINE){
            String s = Equation.getText().toString() + "9";
            Equation.setText(s);
        }
        else if(viewId == R.id.bZERO){
            String s = Equation.getText().toString() + "0";
            Equation.setText(s);
        }
        else if(viewId == R.id.bPLUS){
            String s = Equation.getText().toString();
            if(s.length()>0) {
                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') || (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == ')') || s.charAt(s.length() - 1) == '!') {
                    s += "+";
                    Equation.setText(s);
                }
            }
        }
        else if(viewId == R.id.bSUBTRACT){
            String s = Equation.getText().toString();
            if(s.length()>0)
            {
                if((s.charAt(s.length()-1) >='0' && s.charAt(s.length()-1) <='9') || (s.charAt(s.length()-1) =='(' || s.charAt(s.length()-1) ==')')|| s.charAt(s.length()-1) =='!'){
                    s += "-";
                    Equation.setText(s);
                }
            }

        }
        else if(viewId == R.id.bMULTIPLY){
            String s = Equation.getText().toString();
            if(s.length()>0) {
                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') || (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == ')') || s.charAt(s.length() - 1) == '!') {
                    s += "*";
                    Equation.setText(s);
                }
            }
        }
        else if(viewId == R.id.bDIVIDE){
            String s = Equation.getText().toString();
            if(s.length()>0) {
                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') || (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == ')') || s.charAt(s.length() - 1) == '!') {
                    s += "÷";
                    Equation.setText(s);
                }
            }
        }
        else if(viewId == R.id.bMOD){
            String s = Equation.getText().toString();
            if(s.length()>0) {


                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') || (s.charAt(s.length() - 1) == '(' || s.charAt(s.length() - 1) == ')') || s.charAt(s.length() - 1) == '!') {
                    Equation.setText(s + "%");
                    ModPressed += 1;
                }
            }
        }
        else if(viewId == R.id.bFACTORIAL){
            String s = Equation.getText().toString();
            if(s.length()>0) {
                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9'))
                    Equation.setText(s + "!");
            }
        }
        else if(viewId == R.id.bPOWER) {
            String s = Equation.getText().toString();
            if (s.length() > 0) {


                if ((s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9'))
                    Equation.setText(s + "^");

            }
        }
        else if(viewId == R.id.bSIN){
            String s = Equation.getText().toString() + "sin";
            Equation.setText(s);
        }
        else if(viewId == R.id.bCOS){
            String s = Equation.getText().toString() + "cos";
            Equation.setText(s);
        }
        else if(viewId == R.id.bTAN){
            String s = Equation.getText().toString() + "tan";
            Equation.setText(s);
        }
        else if(viewId == R.id.bSQUAREROOT){
            String s = Equation.getText().toString() + "√";
            Equation.setText(s);
        }
        else if(viewId == R.id.bCUBEROOT){
            String s = Equation.getText().toString() + "∛";
            Equation.setText(s);
        }
        else if(viewId == R.id.bBRACKETCLOSE){
            String s = Equation.getText().toString() + ")";
            Equation.setText(s);
        }
        else if(viewId == R.id.bBRACKETOPEN){
            String s = Equation.getText().toString() + "(";
            Equation.setText(s);
        }
        else if(viewId == R.id.bAC){
            String s = "";
            Equation.setText(s);
            Result.setText(s);
        }
        else if(viewId == R.id.bC){
            String s = Equation.getText().toString();
            if(s.length()>0)
            {
                s = s.substring(0,s.length()-1);
                Equation.setText(s);
            }

        }
//Equation Evaluation Starts Here:
        else if(viewId == R.id.bEQUAL) {
            String S = Equation.getText().toString();
            if(ModPressed > 0)
            {
                S = ModExpression(S);
            }
            String result = EqualButtonCalcualtion(S);
            if(!result.equals("SYNTAX ERROR!"))
            {
                double Dres = Double.parseDouble(result);
                if(Dres%1 == 0)
                {
                    int IntResult;
                    IntResult = (int)Math.round(Dres);
                    Result.setText(Integer.toString(IntResult));
                }
                else{
                    Result.setText(Double.toString(Dres));
                }
            }
            else
                Result.setText(result);
            ModPressed = 0;
            //region Equals Button Implementation with my own expression evaluator
//            String Trigno = "";
//            if (S.length() >= 3) {
//                Trigno = S.substring(0, 3);
//            }
//            //Edge Cases for SIN COS TAN These can  only work when entered separately, there should not be any other number in equation to work properly.
//            if(Trigno.equals("sin") || Trigno.equals("cos") || Trigno.equals("tan"))
//            {
//                S = S.substring(3);
//                double val = Double.parseDouble(S);
//                switch (Trigno) {
//                    case "sin":
//                        double sinVal = (Math.sin(Math.toRadians(val)));
//                        Result.setText(Double.toString(sinVal));
//                        break;
//                    case "cos":
//                        double cosVal = Math.cos(Math.toRadians(val));
//                        Result.setText(Double.toString(cosVal));
//                        break;
//                    case "tan":
//                        if (val == 90 || val == 270)
//                            Result.setText("Undefined");
//                        else {
//                            double tanVal = Math.tan(Math.toRadians(val));
//                            Result.setText(Double.toString(tanVal));
//                        }
//                        break;
//                }
//            }
//            else{
//
//                try
//                {
//                    double result = CalculatorMain(S);
//                    if(result%1 == 0){
//                        int IntResult;
//                        IntResult = (int)Math.round(result);
//                        Result.setText(Integer.toString(IntResult));
//                    }
//                    else
//                        Result.setText(Double.toString(result));
//                }
//                catch (Exception e)
//                {
//                    Result.setText("Syntax Error!");
//                }
//            }
//            Call the calculation Method here
            //endregion
        }
    }



    @NonNull
    private String EqualButtonCalcualtion(String Expression){
        Expression = Expression.replaceAll("÷", "/");
        Expression CalculatedExp = new Expression(Expression);
        String result = String.valueOf(CalculatedExp.calculate());
        if(result.toLowerCase().equals("nan"))
            result = "SYNTAX ERROR!";
        return result;
    }
    private String ModE(@NonNull String Exp){
        for(int i =0; i<Exp.length(); i++)
        {
            if(Exp.charAt(i)=='%')
            {
                String num1S = ""; String num2S = "";
                int n1 = i-1;
                int n2 = i+1;
                for(;n1>=0;n1--)
                {
                    if((Exp.charAt(n1) >='0' && Exp.charAt(n1)<='9') || Exp.charAt(n1) == '.')
                    {
                        num1S = Exp.charAt(n1)+ num1S;
                    }
                    else break;
                }
                for(;n2<Exp.length();n2++)
                {
                    if((Exp.charAt(n2) >='0' && Exp.charAt(n2)<='9') || Exp.charAt(n2) == '.')
                    {
                        num2S+=Exp.charAt(n2);
                    }
                    else break;
                }
                double num1 = Double.parseDouble(num1S);
                double num2 = Double.parseDouble(num2S);
                double Res = num1%num2;

                String start = Exp.substring(0,n1+1);
                start+= Double.toString(Res);
                String End = Exp.substring(n2,Exp.length());
                start+=End;
                return start;
            }
        }
        return Exp;
    }
    private String ModExpression(String Expression){
        for(int m = 0; m<ModPressed; m++) {
                Expression = ModE(Expression);
        }
        return Expression;
    }





//region My Own Calculator expression evaluator for more than two number
    private int loc = 0;
    @NonNull
    private String PostfixBrackets(@NonNull String cal) {
        String Pfs;
        Stack<Character> op = new Stack<>();
        StringBuilder PfsBuilder = new StringBuilder();
        for (int i = 0; i < cal.length(); i++)
        {
            if ((cal.charAt(i) >= '0' && cal.charAt(i) <= '9') || cal.charAt(i) == '.')
                PfsBuilder.append(cal.charAt(i));
            else if(cal.charAt(i) == ' ')
                PfsBuilder.append('_');
            else {

                if (cal.charAt(i) == '(')
                {
                    op.push(cal.charAt(i));
                    continue;
                }
                else if (cal.charAt(i) == ')')
                {
                    while ('(' != op.peek())
                    {
                        char b = op.peek();
                        op.pop();
                        PfsBuilder.append(b);
                    }
                    op.pop();
                    continue;
                }
                else{
                    PfsBuilder.append('_');
                }
                if (!op.empty() && precedence(cal.charAt(i), op.peek()))
                {
                    while (!op.empty() && precedence(cal.charAt(i), op.peek()))
                    {
                        char c = op.peek();
                        op.pop();
                        PfsBuilder.append(c);
                    }
                    op.push(cal.charAt(i));
                }
                else
                    op.push(cal.charAt(i));
            }
        }
        while (!op.empty())
        {
            PfsBuilder.append(op.peek());
            op.pop();
        }
        Pfs = PfsBuilder.toString();
        return Pfs;
    }
    private boolean precedence(char a, char b) {
        if (b == '(')
            return false;
        String p = "!%÷*+-√∛";
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < p.length(); i++)
        {
            if (p.charAt(i) == a)
                ai = i;
            if (p.charAt(i) == b)
                bi = i;
        }
        return ai >= bi;
    }
    private double math(char op, double num1, double num2) {
        if (op == '+')
            return num1 + num2;
        if (op == '-')
            return num1 - num2;
        if (op == '*')
            return num1 * num2;
        if (op == '÷')
            return num1 / num2;
        if(op=='%')
            return num1%num2;
        if(op == '^')
            return (int)Math.pow(num1,num2);
        if(op=='!')
            return factorial(num1);
        if(op=='∛')
            return (int)Math.cbrt(num2);
        if(op == '√')
            return (int)Math.sqrt(num2);
        return 0;
    }
    private  double StringToInteger(@NonNull String exp) {
        StringBuilder SBuilder;
        SBuilder = new StringBuilder();
        while ((exp.charAt(loc) >= '0' && exp.charAt(loc) <= '9') || exp.charAt(loc) == '.')
        {
            SBuilder.append( exp.charAt(loc));
            loc++;
        }
        loc--;
        return Double.parseDouble(SBuilder.toString());
    }
    private double PostFixMath(@NonNull String exp) {
        Stack <Double> val = new Stack <> ();
        for (loc = 0; loc < exp.length(); loc++)
        {
            if (exp.charAt(loc) >= '0' && exp.charAt(loc) <= '9')
            {
                val.push(StringToInteger(exp));
            }
            else if (exp.charAt(loc) == '_') {
                continue;
            }
            else
            {
                if (!val.empty())
                {
                    double num2 = val.peek(); val.pop();
                    double num1 = val.peek(); val.pop();
                    val.push(math(exp.charAt(loc), num1, num2));
                }
            }
        }
        return val.peek();
    }
    private  double CalculatorMain(String Expression) {

        String PFExp = PostfixBrackets(Expression);
        return PostFixMath(PFExp);
    }
    private double factorial(double num)
    {
        if (num == 0 || num == 1)
            return 1;
        return num * factorial(num - 1);
    }
//endregion





}