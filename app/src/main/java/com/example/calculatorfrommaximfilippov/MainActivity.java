package com.example.calculatorfrommaximfilippov;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;Button Plus;Button Minus;Button Division;Button Multiplication;Button Equal;Button Credits;Button Clear;int Outcome;String number;int firstNumber;int secondNumber;int action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText=(EditText) findViewById(R.id.editTextNumber);
        Plus=(Button) findViewById(R.id.button2);
        Minus=(Button) findViewById(R.id.button);
        Division=(Button) findViewById(R.id.button3);
        Multiplication=(Button) findViewById(R.id.button4);
        Equal=(Button) findViewById(R.id.button5);
        Credits=(Button) findViewById(R.id.button7);
        Clear=(Button) findViewById(R.id.button6);
        firstNumber=0;
        secondNumber=0;
        action=0;

        Plus.setText("+");
        Minus.setText("-");
        Division.setText("/");
        Multiplication.setText("*");
        Equal.setText("=");
        Credits.setText("credits");
        Clear.setText("A/C");
    }
    public void PlusFunction(View view) {
        number=editText.getText().toString();
        if(action==0){
            firstNumber=Integer.parseInt(number);
        }
        else if (action==1) {
            firstNumber=firstNumber+Integer.parseInt(number);}
        else if (action==2) {
            firstNumber=firstNumber-Integer.parseInt(number);}
        else if (action==3) {
            secondNumber=secondNumber/Integer.parseInt(number);}
        else{
            secondNumber=secondNumber*Integer.parseInt(number);
        }
        editText.setText("");
        action=1;}
    public void MinusFunction(View view) {
        number=editText.getText().toString();
        if(action==0){
            firstNumber=Integer.parseInt(number);
        }
        else if (action==1) {
            firstNumber=firstNumber+Integer.parseInt(number);}
        else if (action==2) {
            firstNumber=firstNumber-Integer.parseInt(number);}
        else if (action==3) {
            secondNumber=secondNumber/Integer.parseInt(number);}
        else{
            secondNumber=secondNumber*Integer.parseInt(number);
        }
        editText.setText("");
        action=2;}
    public void DivisionFunction(View view) {
        number=editText.getText().toString();
        if(action==0){
            firstNumber=Integer.parseInt(number);
            action=3;
        }
        else if (action==1) {
            secondNumber=secondNumber/Integer.parseInt(number);}
        else if (action==2) {
            secondNumber=secondNumber/Integer.parseInt(number);}
        else if (action==3) {
            firstNumber=firstNumber/Integer.parseInt(number);}
        else{
            action=3;
            firstNumber=firstNumber/Integer.parseInt(number);}

        editText.setText("");
    }
    public void MultiplicationFunction(View view) {
        number=editText.getText().toString();
        if(action==0){
            action=4;
            firstNumber=Integer.parseInt(number);
        }
        else if (action==1) {
            secondNumber=secondNumber*Integer.parseInt(number);}
        else if (action==2) {
            secondNumber=secondNumber*Integer.parseInt(number);}
        else if (action==3) {
            action=4;
            firstNumber=firstNumber*Integer.parseInt(number);}
        else{
            firstNumber=firstNumber*Integer.parseInt(number);}

        editText.setText("");
        action=3;}
    public void EqualFunction(View view) {
        number=editText.getText().toString();
        if(action==0){
            firstNumber=Integer.parseInt(number);
            editText.setText("");
            Outcome=firstNumber;
        }
        else if (action==1) {
            firstNumber=firstNumber+Integer.parseInt(number);}
        else if (action==2) {
            firstNumber=firstNumber-Integer.parseInt(number);}
        else if (action==3) {
            secondNumber=secondNumber/(Integer.parseInt(number));}
        else{
            secondNumber=secondNumber*Integer.parseInt(number);
        }
        Outcome=firstNumber+secondNumber;
        firstNumber=Outcome;
        secondNumber=0;
        editText.setText(Outcome);
        action=0;
    }
    public void clearFunction(View view) {
        action=0;
        editText.setText("");
        secondNumber=0;}
    public void creditsFunction(View view) {
        Intent si = new Intent(this, SecondActivity.class);
        si.putExtra("n", Outcome);
        startActivity(si);
    }

}