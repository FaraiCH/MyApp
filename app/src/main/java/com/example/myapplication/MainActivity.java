package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button submit;
    private static EditText text;
    private static RatingBar rating;
    private static Button alertmessage;
    private CheckBox check, check2, check3;

    private EditText password;
    private Button button;
    private Button button2;
    private static RadioGroup radio_g;
    private static RadioButton radio_grocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clickListenerBaby();
        addListnerOnButton();
        addListenerToCheckBox();
        onListenMan();
        ratingListner();
        onButtongBoy();
        hereWeGo();
    }


    public void hereWeGo()
    {
        alertmessage = findViewById(R.id.button5);

        alertmessage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);


                        //Create alert message
                        alert.setMessage("You have rated this app. Thanks, man!")
                                //No cancel button
                                .setCancelable(false)

                                //Create yes dialog button
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                //Create no dialog button
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });

                        AlertDialog alertm = alert.create();

                        alertm.setTitle("Well, here we are!");

                        alertm.show();
                    }
                }
        );
    }

    public void onButtongBoy(){

        submit = findViewById(R.id.btnSubmit);
        rating = findViewById(R.id.ratingBar);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(rating.getRating()), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void ratingListner()
    {
        submit = findViewById(R.id.btnSubmit);
        text = findViewById(R.id.txtRate);
        rating = findViewById(R.id.ratingBar);

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text.setText(String.valueOf(rating));
                    }
                }
        );
    }

    public void onListenMan()
    {

        radio_g = findViewById(R.id.Radio_Group);
        button2 = findViewById(R.id.button3);

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selected_id = radio_g.getCheckedRadioButtonId();

                        radio_grocery = findViewById(selected_id);

                        Toast.makeText(MainActivity.this, radio_grocery.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    public void addListenerToCheckBox()
    {
        check = findViewById(R.id.chkFirst);
        check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((CheckBox) v).isChecked())
                        {
                            Toast.makeText(MainActivity.this, "You clicked on " + check.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void addListnerOnButton()
    {
        check = findViewById(R.id.chkFirst);
        check2 = findViewById(R.id.chkSecond);
        check3 = findViewById(R.id.chkThird);

        button = findViewById(R.id.btnClick);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          StringBuffer result = new StringBuffer();

                                          result.append("Banana: ").append(check.isChecked());
                                          result.append("\nLoaf: ").append(check2.isChecked());
                                          result.append("\nCarrot: ").append(check3.isChecked());

                                          Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

                                      }
                                  }

        );
    }

    public void clickListenerBaby()
    {



        //We create a button listener to deliver a message of the password content
        password = findViewById(R.id.editText);
        button = findViewById(R.id.btnClick);


        //Set the listener to the button
        //Always use getText to get the text value of an item

        button.setOnClickListener(
                //Attach a method to a View.
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        Toast.makeText(
                          MainActivity.this, password.getText(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
}
