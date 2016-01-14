package com.magicalboy.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        Set<String> names = System.getProperties().stringPropertyNames();

        StringBuilder sb = new StringBuilder(System.getProperties().toString().length());
        for (String name: names) {
            if (name.equals("line.separator"))
                sb.append(name + " = " + invisibleString(System.getProperties().getProperty(name)) + "\n");
            else
                sb.append(name + " = " + System.getProperties().getProperty(name) + "\n");
        }

        textView.setText(sb.toString());
    }

    private String invisibleString(String invisible) {
        StringBuilder newString = new StringBuilder(invisible.length());
        for (int i = 0; i < invisible.length(); i++) {
            char c = invisible.charAt(i);
            switch (c) {
                case '\t':
                    newString.append("\\t");
                    break;
                case '\r':
                    newString.append("\\r");
                    break;
                case '\n':
                    newString.append("\\n");
                    break;
                default:
                    newString.append(c);
                    break;
            }
        }

        return newString.toString();
    }


}
