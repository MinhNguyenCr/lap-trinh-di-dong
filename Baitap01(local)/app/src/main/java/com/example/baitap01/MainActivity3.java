package com.example.baitap01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edittext = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView2);
        Button btn = findViewById(R.id.buttonEnter);
        Button btnCP = findViewById(R.id.buttonSoChinhPhuong);
        ArrayList<Integer> numbers = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                numbers.clear();
                Random random = new Random();
                String num = edittext.getText().toString();
                int count = Integer.parseInt(num);
                for(int i=0 ; i<count ; i++){
                    int randomNum = random.nextInt(101);
                    numbers.add(randomNum);
                }


                textView.setText(numbers.toString());
                edittext.setText("");
            }
        });
        btnCP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StringBuilder text = new StringBuilder();
                for(int num:numbers) {

                    if (SoCP(num)) {
                        text.append(num+ "\t");

                    }
                }
                if(text.length() == 0) Toast.makeText(getApplicationContext(), "không có số chính phương", Toast.LENGTH_LONG).show();
                else Toast.makeText(getApplicationContext(), text + ": là số chính phương", Toast.LENGTH_LONG).show();
            }
        });


    }
    public boolean SoCP (int number){
        if (number < 0) {
            return false;
        }
        double sqrt = Math.sqrt(number);

        return sqrt == (int) sqrt;
    }
}