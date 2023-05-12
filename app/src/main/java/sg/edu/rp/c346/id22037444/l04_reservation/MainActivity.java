package sg.edu.rp.c346.id22037444.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    Button btnConfirm;
    CheckBox smokeEnabled;
    TextView tvDisplay;
    EditText nameText;
    EditText phoneNo;
    EditText sizeNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayTime = findViewById(R.id.timeButton);
        btnDisplayDate = findViewById(R.id.dateButton);
        btnReset = findViewById(R.id.resetButton);
        btnConfirm = findViewById(R.id.confirmButton);
        smokeEnabled = findViewById(R.id.smokeBox);
        tvDisplay = findViewById(R.id.textViewDisplay);
        nameText = findViewById(R.id.editTextName);
        phoneNo = findViewById(R.id.editTextPhone);
        sizeNo = findViewById(R.id.editTextNumber);

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = "Today is " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear();
                tvDisplay.setText(date);
            }
        });

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "Time is " + tp.getCurrentHour().toString() + ":" + tp.getCurrentMinute().toString();
                tvDisplay.setText(time);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2023, 0, 1);
                tvDisplay.setText("");
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String said = "";
                if(smokeEnabled.isChecked()){
                    btnConfirm.setEnabled(true);
                    tvDisplay.setText("Name: " + nameText.getText().toString() + "\nPhone No.: " + phoneNo.getText().toString() + "\nSize: " + sizeNo.getText().toString() + "\nSmoking Area" +
                            "\nDate: " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear() + "\nTime: " + tp.getCurrentHour().toString() + ":" + tp.getCurrentMinute().toString());
                }
                else {
                    btnConfirm.setEnabled(false);
                    tvDisplay.setText("Name: " + nameText.getText().toString() + "\nPhone No.: " + phoneNo.getText().toString() + "\nSize: " + sizeNo.getText().toString() + "\nNon-Smoking Area" +
                            "\nDate: " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear() + "\nTime: " + tp.getCurrentHour().toString() + ":" + tp.getCurrentMinute().toString());
                }
                Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_LONG).show();
            }
        });
    }
}