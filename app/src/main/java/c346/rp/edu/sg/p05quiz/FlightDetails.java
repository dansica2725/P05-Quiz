package c346.rp.edu.sg.p05quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {

    TextView displayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        displayTv = findViewById(R.id.displayTv);

        Intent getIntent = getIntent();

        double price = getIntent.getDoubleExtra("Price", 0);

        String type = getIntent.getStringExtra("Type");

        String displayText = String.format("You have selected %s. Your air ticket costs $%.1f", type, price);

        displayTv.setText(displayText);

    }
}
