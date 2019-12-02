package com.example.taxactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView show;

    EditText salary;
    Button mybutton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        salary = findViewById(R.id.editText);
        mybutton = findViewById(R.id.button);
        show = findViewById(R.id.mytextTax);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tax = getprovTax(Double.parseDouble(salary.getText().toString()));
                show.setText(String.valueOf(tax));


            }
        });
    }

    public Double getprovTax (Double grossincome)
    {
        double tax = 0.0;

        if(grossincome > 0.0 && grossincome <= 10582.0)
        {
            tax = 0.0;
        }
        else if(grossincome >= 10582.1 && grossincome <= 43906.0)
        {
            grossincome = grossincome-10582;
            tax = (grossincome * 5.05)/100;
        }
        else if(grossincome >= 43906.0 && grossincome <= 87813.0)
        {

            grossincome = grossincome-43906;
            double backtax = ((43906-10582)*5.05)/100;
            double temptax = (grossincome * 9.15)/100;
            tax = backtax + temptax;
        }
        else if(grossincome >= 87813.0 && grossincome <= 150000.0)
        {

            grossincome = grossincome-87813.0;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double temptax = (grossincome * 11.16)/100;

            tax = backtax + backtax2 + temptax;
        }
        else if(grossincome >= 150000.0 && grossincome <= 220000.0)
        {

            grossincome = grossincome-150000.0;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double backtax3 = ((150000-87813)*11.16)/100;
            double temptax = (grossincome * 12.16)/100;

            tax = backtax + backtax2 + backtax3 + temptax;
        }
        else if(grossincome >= 220000.0)
        {

            grossincome = grossincome-220000;
            double backtax = ((43906-10582)*5.05)/100;
            double backtax2 = ((87813-43906)*9.15)/100;
            double backtax3 = ((150000-87813)*11.16)/100;
            double backtax4 = ((220000-150000)*12.16)/100;

            double temptax = (grossincome * 13.16)/100;

            tax = backtax + backtax2 + backtax3 + backtax4 + temptax;
        }



        return tax;
    }
}
