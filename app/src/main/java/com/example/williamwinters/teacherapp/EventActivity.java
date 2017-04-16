package com.example.williamwinters.teacherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class EventActivity extends AppCompatActivity {

    ListView studentList;
    String qrCode; // set this from firebase

    static final String[] studentsArray = new String[] {

            "Afghanistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctica",
            "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
            "Australia", "Austria", "Azerbaijan", "Bahrain",
            "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
            "Benin", "Bermuda", "Bhutan", "Bolivia",
            "Bosnia and Herzegovina", "Botswana", "Bouvet Island",
            "Brazil", "British Indian Ocean Territory"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Bundle bundle = getIntent().getExtras();

        qrCode = bundle.getString("qr");

        // populate studentArray

        studentList = (ListView) findViewById(R.id.list_students);
        //studentList.setAdapter(new ArrayAdapter<>(EventActivity.this, android.R.layout.simple_list_item_1, studentsArray));
        studentList.setAdapter(new ArrayAdapter<>(EventActivity.this, R.layout.student_detail, R.id.student_name, studentsArray));
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                *
                * Here, upload additional points to selected student
                *
                *
                *
                *
                * */


                Toast.makeText(EventActivity.this,
                        "ListView: " + parent.toString() + "\n" +
                                "View: " + view.toString() + "\n" +
                                "position: " + String.valueOf(position) + "\n" +
                                "id: " + String.valueOf(id),
                        Toast.LENGTH_LONG).show();
            }
        });

        TextView tShowCode = (TextView) findViewById(R.id.show_code);
        tShowCode.setText(qrCode);

        Button bShowCode = (Button) findViewById(R.id.button_show_qr);
        bShowCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventActivity.this,
                        "ShowCode Listens",
                        Toast.LENGTH_LONG).show();
                Intent CreateEventIntent = new Intent(EventActivity.this, QrGenActivity.class);
                CreateEventIntent.putExtra("qr", qrCode);
                EventActivity.this.startActivity(CreateEventIntent);
            }
        });


        /*
        *
        * This function is optional
        *
        * */
        Button bAddStudentMan = (Button) findViewById(R.id.button_add_student);
        bAddStudentMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventActivity.this,
                        "AddStudentMan Listens",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}