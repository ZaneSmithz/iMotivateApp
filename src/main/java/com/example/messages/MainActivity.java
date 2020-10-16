package com.example.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Random rand = new Random();
    private ArrayList<String> textArr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textArr = new ArrayList<String>();
        textArr.add("“Keep your face always toward the sunshine—and shadows will fall behind you.” —Walt Whitman");
        textArr.add("“It is always the simple that produces the marvelous.” —Amelia Barr");
        textArr.add("“Let us make our future now, and let us make our dreams tomorrow’s reality.” —Malala Yousafzai");
        textArr.add("“All you need is the plan, the road map, and the courage to press on to your destination.” —Earl Nightingale");
        textArr.add("“The glow of one warm thought is to me worth more than money.” —Thomas Jefferson");


    }

    public void textChange(View v) {
        TextView myView = findViewById(R.id.mainText);
        int index = rand.nextInt(textArr.size());
        myView.setText(textArr.get(index));
    }

    public void launchMoreText(View v) {
        Intent launchMore = new Intent(this, WriteText.class);
        startActivity(launchMore);
    }

    public void retrieve(View v) throws IOException {
        TextView myView = findViewById(R.id.mainText);
        FileInputStream fiS = null;
        fiS = openFileInput(WriteText.FILE_NAME);
        InputStreamReader isR = new InputStreamReader(fiS);
        BufferedReader br = new BufferedReader(isR);
        String text;

        while ((text = br.readLine()) != null) {
            textArr.add(text);
            myView.setText(text);
        }
        Log.d("print", Arrays.toString(textArr.toArray()));

        if (fiS != null) {
            fiS.close();
        }

        br.close();

    }
}