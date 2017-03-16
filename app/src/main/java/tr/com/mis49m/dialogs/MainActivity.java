package tr.com.mis49m.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnOpenDialog, btnOpenCustom, btnOpenDate, btnOpenTime;
    TextView tvTime, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- Open Dialog
        btnOpenDialog = (Button) findViewById(R.id.btnOpenDialog);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setMessage("Dialog Message").setTitle("Title");
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.setIcon(R.mipmap.ic_launcher);
                alert.show();
            }
        });


        //-- Open Custom Dialog
        btnOpenCustom = (Button) findViewById(R.id.btnOpenCustom);
        btnOpenCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);
                Button btn = (Button) dialog.findViewById(R.id.btn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        //-- Open DatePicker Dialog
        tvDate = (TextView) findViewById(R.id.tvDate);
        btnOpenDate = (Button) findViewById(R.id.btnOpenDate);
        btnOpenDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-- Read current date
                Calendar calToday = Calendar.getInstance();
                int currentYear = calToday.get(Calendar.YEAR);
                int currentMonth = calToday.get(Calendar.MONTH);
                int currentDay = calToday.get(Calendar.DAY_OF_MONTH);

                //-- Create Date Picker
                Dialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        //-- Set selected date
                        tvDate.setText( selectedDay + "/" + selectedMonth + "/" + selectedYear);
                    }
                },currentYear, currentMonth, currentDay);
                datePicker.show();
            }
        });

        //-- Open TimePicker Dialog
        tvTime = (TextView) findViewById(R.id.tvTime);
        btnOpenTime = (Button) findViewById(R.id.btnOpenTime);
        btnOpenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-- Read current time
                Calendar calToday = Calendar.getInstance();
                int currentHour = calToday.get(Calendar.HOUR);
                int currentMin = calToday.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMin) {
                        //-- Set selected time
                        tvTime.setText( selectedHour + ":" + selectedMin);
                    }
                },currentHour, currentMin, true);
                timePickerDialog.show();

            }
        });


    }
}
