package com.example.akurian.lumos;

import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText employeeIdInputBox;
    Button submitButton;
    int employeeId;
    private TextToSpeech tts;
    Handler handler = new Handler();
    final myAsync myasync=new myAsync();

//    private Runnable runnableCode = new Runnable() {
//        @Override
//        public void run() {
////            new myAsync().execute();
//            handler.postDelayed(runnableCode, (5000));
//        }
//    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeIdInputBox = (EditText) findViewById(R.id.employeeId);
        submitButton = (Button) findViewById(R.id.submitButton);
        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                    myasync.execute();
                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                employeeId=Integer.parseInt(employeeIdInputBox.getText().toString());
                checkIfEmployeeHasFilledTimeSheet(employeeId);

            }
        });

//        handler.post(runnableCode);


    }

    void checkIfEmployeeHasFilledTimeSheet(int employeeId){
        String[] missingMessages={"missing","time to fill","hello"};
        String[] filledSheets={"good job","bingo","lays"};
        if(myasync.idName.containsKey(employeeId+"")) {
            String toSpeak=missingMessages[(int)(Math.random()*missingMessages.length)];
            speakOut(toSpeak);
        }
        else {
            String toSpeak=filledSheets[(int)(Math.random()*filledSheets.length)];
            speakOut(toSpeak);
        }
    }

    private void speakOut(String toSpeak) {
        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

    }
}
