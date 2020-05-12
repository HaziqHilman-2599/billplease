package sg.edu.rp.c346.id19023980.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText etamount;
    EditText etpax;
    EditText etdiscount;
    TextView tvbill;
    TextView tvsplit;
    ToggleButton tbsvscheck;
    ToggleButton tbgstcheck;
    Button btnsplit;
    Button btnreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etamount = findViewById(R.id.editTextAmount);
        etpax = findViewById(R.id.editTextPax);
        etdiscount = findViewById(R.id.editTextDiscount);

        tvbill = findViewById(R.id.textViewTtlBill);
        tvsplit = findViewById(R.id.textViewEchPay);

        tbgstcheck = findViewById(R.id.toggleButtonGST);
        tbsvscheck = findViewById(R.id.toggleButtonSVS);

        btnreset = findViewById(R.id.buttonReset);
        btnsplit = findViewById(R.id.buttonsplit);

        double amount = Double.parseDouble(etamount.getText().toString());
        final int pax = Integer.parseInt(etpax.getText().toString());
        int discount = Integer.parseInt(etdiscount.getText().toString());

        tbsvscheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbsvscheck.isChecked() == true){
                    double amount = Double.parseDouble(etamount.getText().toString());
                     amount = amount * 110/100;
                } else{
                    double amount = Double.parseDouble(etamount.getText().toString());
                    amount = amount;
                }
            }
        });

        tbgstcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbgstcheck.isChecked() == true){
                    double amount = Double.parseDouble(etamount.getText().toString());
                    amount = amount * 107/100;
                } else{
                    double amount = Double.parseDouble(etamount.getText().toString());
                    amount = amount;
                }
            }
        });
        btnsplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(etamount.getText().toString());
                final int pax = Integer.parseInt(etpax.getText().toString());
                int discount = Integer.parseInt(etdiscount.getText().toString());
                double total = amount - (amount * (discount/100));
                String totaldisplay = String.format("%.2f",total);
                tvbill.setText(totaldisplay);
                double totalpax = total/pax;
                tvsplit.setText((int)totalpax);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String empty = " ";
                etamount.setText(empty);
                etdiscount.setText(empty);
                etpax.setText(empty);

                tvsplit.setText(empty);
                tvbill.setText(empty);

                tbgstcheck.setTextOff("GST Disabled");
                tbsvscheck.setTextOff("SVS Disabled");
            }
        });

    }
}
