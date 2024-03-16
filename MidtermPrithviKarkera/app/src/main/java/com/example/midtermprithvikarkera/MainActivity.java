package com.example.midtermprithvikarkera;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.midtermprithvikarkera.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText litreInput;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputLiters = findViewById(R.id.inputLiters);
        Button convertButton = findViewById(R.id.convertButton);
        final TextView resultGallons = findViewById(R.id.resultGallons);

        litreInput = findViewById(R.id.inputLiters);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultGallons);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meterStr = litreInput.getText().toString().trim();
                if (!meterStr.isEmpty()) {
                    double liters = Double.parseDouble(inputLiters.getText().toString());
                    double gallons = liters * 0.219; // Conversion rate
                    resultGallons.setText(String.format("%.2f gallons", gallons));

                } else {
                    resultGallons.setText("Please enter a value");
                }
            }
        });
    }
}
