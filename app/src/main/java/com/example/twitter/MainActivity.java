package com.example.twitter;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton play;

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

        editText = findViewById(R.id.textboxIdentifiant);

        String blockedChars = " @#$/&é'(èçà)=,;:!<>&²³¹+*[]%ù€\"^×÷?";

        editText.setFilters(new InputFilter[]{
                (source, start, end, dest, dstart, dend) -> {
                    StringBuilder filtered = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        char c = source.charAt(i);
                        if (blockedChars.indexOf(c) == -1) {
                            filtered.append(c);
                        }
                    }
                    return filtered.toString();
                }
        });

    }
}