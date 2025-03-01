package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public enum Ops {
        PLUS("+"),
        MOINS("-"),
        FOIS("*"),
        DIV("/");

        private String name = "";
        Ops(String name){this.name = name;}
        public String toString(){return name;}
    }


    private TextView screen;
    private int op1=0;
    private int op2=0;
    private Ops operator=null;
    private boolean isOp1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);

        Button btnEgal = (Button)findViewById(R.id.btnEgal);
        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
            }
        });

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn1);
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn2);
            }
        });

        Button btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn3);
            }
        });

        Button btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn4);
            }
        });

        Button btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn5);
            }
        });

        Button btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn6);
            }
        });

        Button btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn7);
            }
        });

        Button btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn8);
            }
        });

        Button btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumber(btn9);
            }
        });




    }

    private void updateDisplay() {
        int v=op1;
        if(!isOp1) {
            v=op2;
        }

        screen.setText(String.format("%9d",v));
    }


    public void compute() {
        if(isOp1) {
            // do nothing
        } else {
            switch(operator) {
                case PLUS  : op1 = op1 + op2; break;
                case MOINS : op1 = op1 - op2; break;
                case FOIS  : op1 = op1 * op2; break;
                case DIV   : op1 = op1 / op2; break;
                default : return; // do nothing if no operator
            }

            op2 = 0;
            isOp1 = true;
            updateDisplay();
        }
    }


    private void clear() {
        op1 = 0;
        op2 = 0;
        operator = null;
        isOp1 = true;
        updateDisplay();
    }

    public void setOperator(View v) {
        switch (v.getId()) {
            case R.id.btnPlus  : operator=Ops.PLUS;  break;
            case R.id.btnMoins : operator=Ops.MOINS; break;
            case R.id.btnFois  : operator=Ops.FOIS;  break;
            case R.id.btnDiv   : operator=Ops.DIV;   break;
            default :
                Toast.makeText(this, "Opérateur non reconnu",Toast.LENGTH_LONG);
                return; // do nothing if no operator
        }
        isOp1=false;
        updateDisplay();
    }


    public void addNumber(View v){
        try {
            int val = Integer.parseInt(((Button)v).getText().toString());
            if (isOp1) {
                op1 = op1 * 10 + val;
                updateDisplay();
            } else {
                op2 = op2 * 10 + val;
                updateDisplay();
            }
        }catch (NumberFormatException | ClassCastException e) {
            Toast.makeText(this, "Valeur erronée",Toast.LENGTH_LONG);
        }
    }
}