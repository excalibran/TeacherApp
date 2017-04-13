package com.example.williamwinters.teacherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class CreateEventActivity extends AppCompatActivity {

    String[] qrCode = {"Enter Code..."};
    int endHour;
    int endMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        final String[] randomWords = {
                "razzamatazz", "weltschmerz", "razzmatazz", "gigahertz", "kilohertz", "krummholz", "megahertz", "petahertz", "rheumatiz", "slivovitz", "slivowitz", "terahertz", "barometz", "exahertz", "razmataz", "schmaltz",
                "solonetz", "spetsnaz", "spetznaz", "strelitz", "alferez", "bezzazz", "chalutz", "chametz", "chometz", "fahlerz", "humbuzz", "kibbitz", "kibbutz", "kolkhoz", "laydeez", "pazzazz",
                "pizzazz", "schmalz", "schmelz", "schmooz", "schnozz", "shegetz", "shmaltz", "showbiz", "sovkhoz", "staretz", "tendenz", "bazazz", "bezazz", "bizazz", "blintz", "chintz",
                "entrez", "ersatz", "halutz", "kameez", "kibitz", "kolhoz", "kolkoz", "krantz", "kuvasz", "pazazz", "pizazz", "pizzaz", "quartz", "schnoz",
                "speltz", "spritz", "suivez", "abuzz", "assez", "blitz", "bortz", "capiz", "chizz", "fritz", "frizz", "glitz", "grenz", "grosz", "hafiz", "hertz",
                "klutz", "kranz", "miltz", "nertz", "plotz", "pzazz", "scuzz", "soyuz", "spazz", "spitz", "squiz", "swizz", "topaz", "trooz", "waltz",
                "warez", "whizz", "wootz", "buzz", "chez", "chiz", "ditz", "fizz", "friz", "futz", "fuzz", "geez", "gizz", "hizz", "jazz", "jeez",
                "lezz", "lutz", "mezz", "mizz", "mozz", "muzz", "oyez", "phiz", "pozz", "prez", "putz", "quiz", "razz", "ritz", "sitz", "spaz",
                "swiz", "tizz", "trez", "tuzz", "whiz", "yutz", "zizz", "adz", "bez", "biz", "caz", "coz", "cuz", "fez", "fiz", "jiz",
                "lez", "luz", "miz", "moz", "poz", "rez", "riz", "saz", "sez", "wiz", "ziz", "zuz", "zzz"};

        final EditText eInputCode = (EditText) findViewById(R.id.input_code);
        eInputCode.setText(qrCode[0]);

        final Button bRandomCode = (Button) findViewById(R.id.button_randCode);
        bRandomCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eInputCode.setText(randomWords[new Random().nextInt(randomWords.length)]);
            }
        });

        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        Button bConfirmCode = (Button) findViewById(R.id.button_confirm);
        bConfirmCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eInputCode.getText().length() > 0 && !eInputCode.getText().toString().equals("Enter code...")){
                    qrCode[0] = eInputCode.getText().toString();
                    endHour = timePicker.getCurrentHour();
                    endMinute = timePicker.getCurrentMinute();

                    Toast.makeText(CreateEventActivity.this,
                            "Code: " + qrCode[0] + "\nEndTime: "+ endHour +":"+ endMinute,
                            Toast.LENGTH_LONG).show();
                    // send qrCode to database
                    Intent CreateEventIntent = new Intent(CreateEventActivity.this, EventActivity.class);
                    CreateEventIntent.putExtra("qr", qrCode[0]);
                    CreateEventIntent.putExtra("hour", endHour);
                    CreateEventIntent.putExtra("minute", endMinute);
                    CreateEventActivity.this.startActivity(CreateEventIntent);
                }
            }
        });
    }
}
