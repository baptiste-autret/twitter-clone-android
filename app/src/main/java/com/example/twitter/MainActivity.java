package com.example.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnConnexion;
    private EditText editText;
    private EditText editMdp;
    private String valueId;
    private String valueMdp;

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

        btnConnexion = findViewById(R.id.btnConnexion);
        editText = findViewById(R.id.textboxIdentifiant);
        editMdp = findViewById(R.id.textboxPassword);
        valueId = editText.getText().toString();
        valueMdp = editMdp.getText().toString();

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

        btnConnexion.setOnClickListener(v -> {

            String valueId = editText.getText().toString();
            String valueMdp = editMdp.getText().toString();

            if (valueId.equals("admin") && valueMdp.equals("admin")) {

                Intent intent = new Intent(MainActivity.this, pageAccueil.class);
                startActivity(intent);

            }

        });

    }
}