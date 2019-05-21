package c346.rp.edu.sg.p05quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button minus, plus, submit;
    CheckBox one, two;
    TextView pax;
    int paxNum;
    String tixType;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minus = findViewById(R.id.minusBtn);
        plus = findViewById(R.id.plusBtn);
        submit = findViewById(R.id.submitBtn);

        one = findViewById(R.id.oneCB);
        two = findViewById(R.id.twoCB);

        pax = findViewById(R.id.paxTv);

        paxNum = Integer.parseInt(pax.getText().toString());

        price = 0;

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tixType = "One Way Trip";
                Log.i("TIXTYPE", tixType);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tixType = "Round Trip";
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paxNum == 1) {
                    Toast.makeText(MainActivity.this, "Pax cannot be less than 1", Toast.LENGTH_SHORT).show();
                } else {
                    paxNum = paxNum - 1;
                    pax.setText(String.valueOf(paxNum));
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paxNum++;
                pax.setText(String.valueOf(paxNum));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tixType.equals("One Way Trip")) {
                    price = 100 * paxNum;
                    startActivity(new Intent(MainActivity.this, FlightDetails.class).putExtra("Type", tixType).putExtra("Price", price));
                } else if (tixType.equals("Round Trip")) {
                    price = (100 * paxNum) * 2;
                    startActivity(new Intent(MainActivity.this, FlightDetails.class).putExtra("Type", tixType).putExtra("Price", price));
                }
            }
        });
    }
}
