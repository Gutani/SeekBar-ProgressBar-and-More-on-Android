package com.example.testingcomponents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private int increaseProgressBarByFive = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.switchOne = findViewById(R.id.switch1);
        this.mViewHolder.switchTwo = findViewById(R.id.switch2);
        this.mViewHolder.toggleButton = findViewById(R.id.toggleButton);
        this.mViewHolder.toggleButton2 = findViewById(R.id.toggleButton2);
        this.mViewHolder.buttonValidate = findViewById(R.id.buttonValidate);
        this.mViewHolder.result = findViewById(R.id.result);

        this.mViewHolder.buttonValidate.setOnClickListener(this);
        listenerCheck();
        //ProgressBar
        this.mViewHolder.progressBarCircle = findViewById(R.id.progressBarCircle);
        this.mViewHolder.progressBarLine = findViewById(R.id.progressBarLine);
        this.mViewHolder.buttonProgressBar = findViewById(R.id.buttonProgressBar);

        //SickBar... ops seekBar
        this.mViewHolder.seekBar = findViewById(R.id.seekBar);
        this.mViewHolder.seekBar2 = findViewById(R.id.seekBar2);
        this.mViewHolder.result2 = findViewById(R.id.result2);
        mViewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Click and move
                //mViewHolder.result2.setText("onProgressChanged");
                mViewHolder.result2.setText("Progress: "+ i +" / "+ seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //When clicked
                //mViewHolder.result2.setText("onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //When clicking and stop clicking
                //mViewHolder.result2.setText("onStopTrackingTouch");

            }
        });

    }
    public void listenerCheck(){
        mViewHolder.switchOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mViewHolder.result.setText("Switch One is Checked");
                }else{
                    mViewHolder.result.setText("Switch One is NOT Checked");
                }
            }
        });
        
        mViewHolder.switchTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "SWITCH TWO ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        mViewHolder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "ToggleButton 1 is ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        if(mViewHolder.switchTwo.isChecked()){
            mViewHolder.result.setText("Switch Two is Checked");
        }else if(mViewHolder.switchOne.isChecked()){
            mViewHolder.result.setText("Switch One is Checked");
        }else if(mViewHolder.toggleButton.isChecked()){
            mViewHolder.result.setText("ToggleButton One is Checked");
        }else if(mViewHolder.toggleButton2.isChecked()){
            mViewHolder.result.setText("ToggleButton Two is Checked");
        }
        testingDialog();
    }
    public void buttonProgressBar(View v){
        this.increaseProgressBarByFive = this.increaseProgressBarByFive+5;
        mViewHolder.progressBarLine.setProgress(this.increaseProgressBarByFive);
    }

    public void testingDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("yahoo");
        dialogBuilder.setMessage("Message");
        dialogBuilder.setCancelable(false);//If true user can click outside the box to close it
        dialogBuilder.setIcon(android.R.drawable.star_on);
        dialogBuilder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "YOU HAVE ACCEPTED", Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.setNegativeButton("DISAGREE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "YOU HAVE NOT ACCEPTED", Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.create();
        dialogBuilder.show();
    }

    public static class ViewHolder{
        Switch switchOne, switchTwo;
        ToggleButton toggleButton, toggleButton2;
        TextView result, result2;
        Button buttonValidate, buttonProgressBar;
        ProgressBar progressBarCircle, progressBarLine;
        SeekBar seekBar, seekBar2;
    }
}