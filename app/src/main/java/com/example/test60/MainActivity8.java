package com.example.test60;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.Button;
import java.util.ResourceBundle;

public class MainActivity8 extends AppCompatActivity implements View.OnClickListener {

    TextView questionsTextview;
    Button ans1, ans2, ans3, ans4, heart, timer, hint;
    private Button countdownButton;
    private CountDownTimer countDownTimer;
    private int countdownValue = 10;
    ImageView title;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;

    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        title = findViewById(R.id.imageView19);
        questionsTextview = findViewById(R.id.questions);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        heart = findViewById(R.id.heart);
        timer = findViewById(R.id.timer);
        hint = findViewById(R.id.hint);
        countdownButton = findViewById(R.id.timer);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);

        startCountdown();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int counter = pref.getInt("counter", 0);
        currentQuestionIndex = counter;

        //level name
        if(counter == 0){
            title.setImageResource(R.drawable.level1title);
        }else if(counter == 1){
            title.setImageResource(R.drawable.level2title);
        }else if(counter == 2){
            title.setImageResource(R.drawable.level3title);
        }else if(counter == 3){
            title.setImageResource(R.drawable.level4title);
        }else if(counter == 4){
            title.setImageResource(R.drawable.level5title);
        }else if(counter == 5){
            title.setImageResource(R.drawable.level1title);
        }else if(counter == 6){
            title.setImageResource(R.drawable.level2title);
        }else if(counter == 7){
            title.setImageResource(R.drawable.level3title);
        }else if(counter == 8){
            title.setImageResource(R.drawable.level4title);
        }else if(counter == 9){
            title.setImageResource(R.drawable.level5title);
        }else if(counter == 10){
            title.setImageResource(R.drawable.level1title);
        }else if(counter == 11){
            title.setImageResource(R.drawable.level2title);
        }else if(counter == 12){
            title.setImageResource(R.drawable.level3title);
        }else if(counter == 13){
            title.setImageResource(R.drawable.level4title);
        }else if(counter == 14){
            title.setImageResource(R.drawable.level5title);
        }

        loadQuestion();


        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter == 0){
                    Toast.makeText(getApplicationContext(),"Hint: Uses println() to print a new line.",Toast.LENGTH_SHORT).show();
                }else if(counter==1){
                    Toast.makeText(getApplicationContext(),"Hint: In java, naming convention is to always start with a lowercase letter and then capitalize the first letter of every subsequent word.",Toast.LENGTH_SHORT).show();
                }else if(counter==2){
                    Toast.makeText(getApplicationContext(),"Hint: A sequence of characters that exists as an object of the class java.lang",Toast.LENGTH_SHORT).show();
                }else if(counter==3){
                    Toast.makeText(getApplicationContext(),"Hint: Always denoted with parenthesis.",Toast.LENGTH_SHORT).show();
                }else if(counter==4){
                    Toast.makeText(getApplicationContext(),"Hint: A file containing Java bytecode that can be executed on the Java Virtual Machine.",Toast.LENGTH_SHORT).show();
                }else if(counter == 5){
                    Toast.makeText(getApplicationContext(),"Hint: Object References.",Toast.LENGTH_SHORT).show();
                }else if(counter==6){
                    Toast.makeText(getApplicationContext(),"Hint: Create/Object Creation.",Toast.LENGTH_SHORT).show();
                }else if(counter==7){
                    Toast.makeText(getApplicationContext(),"Hint: Constant and Unchangeable.",Toast.LENGTH_SHORT).show();
                }else if(counter==8){
                    Toast.makeText(getApplicationContext(),"Hint: Abstract.",Toast.LENGTH_SHORT).show();
                }else if(counter==9){
                    Toast.makeText(getApplicationContext(),"Hint: Something subclass.",Toast.LENGTH_SHORT).show();
                } if(counter == 10){
                    Toast.makeText(getApplicationContext(),"Hint:  The switch statement in Java is used to test a variable against a series of constant values and execute different code blocks based on the value of the variable.",Toast.LENGTH_SHORT).show();
                }else if(counter==11){
                    Toast.makeText(getApplicationContext(),"Hint: The switch statement in Java is used to test a variable against a series of constant values and execute different code blocks based on the value of the variable.",Toast.LENGTH_SHORT).show();
                }else if(counter==12){
                    Toast.makeText(getApplicationContext(),"Hint: Trash",Toast.LENGTH_SHORT).show();
                }else if(counter==13){
                    Toast.makeText(getApplicationContext(),"Hint: EXCEPT IN STORE",Toast.LENGTH_SHORT).show();
                }else if(counter==14){
                    Toast.makeText(getApplicationContext(),"Hint: with s in the end of the word.",Toast.LENGTH_SHORT).show();
                }  if(counter == 15){
                    Toast.makeText(getApplicationContext(),"Hint:  something in the system.",Toast.LENGTH_SHORT).show();
                }else if(counter==16){
                    Toast.makeText(getApplicationContext(),"Hint:  b is v, d is a",Toast.LENGTH_SHORT).show();
                }else if(counter==17){
                    Toast.makeText(getApplicationContext(),"Hint: Remember the order of operations (PEMDAS).",Toast.LENGTH_SHORT).show();
                }else if(counter==18){
                    Toast.makeText(getApplicationContext(),"Hint: Evaluate each subexpression within the parentheses separately and use the appropriate logical operator.",Toast.LENGTH_SHORT).show();
                }else if(counter==19){
                    Toast.makeText(getApplicationContext(),"Hint: Remember that Strings are immutable in Java, meaning that the value of a String object cannot be changed once it is created.",Toast.LENGTH_SHORT).show();

                }else if(counter==20){
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void startCountdown() {
        countDownTimer = new CountDownTimer(countdownValue * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdownButton.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.putInt("lives", 1);
                editor.commit();

                liveCount();
            }
        };
        countDownTimer.start();
    }


    @Override
    public void onClick(View view) {
        ans1.setBackgroundColor(Color.DKGRAY);
        ans2.setBackgroundColor(Color.DKGRAY);
        ans3.setBackgroundColor(Color.DKGRAY);
        ans4.setBackgroundColor(Color.DKGRAY);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.ans1 || clickedButton.getId() == R.id.ans2 || clickedButton.getId() == R.id.ans3 || clickedButton.getId() == R.id.ans4) {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);

            SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            int counter = pref.getInt("counter", 0);

            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                int x = counter;
                x+=1;

                editor.putInt("counter",x);
                editor.commit();



                String diff = pref.getString("diff", null);

                currentQuestionIndex = x;

                if(diff.trim().equals("easy")){
                    if(counter == 0){

                        Intent intent = new Intent(getApplicationContext(), MainActivity9.class);
                        startActivity(intent);
                    }else if(counter==1){
                        Intent intent = new Intent(getApplicationContext(), MainActivity10.class);
                        startActivity(intent);
                    }else if(counter==2){
                        Intent intent = new Intent(getApplicationContext(), MainActivity11.class);
                        startActivity(intent);
                    }else if(counter==3){
                        Intent intent = new Intent(getApplicationContext(), MainActivity12.class);
                        startActivity(intent);
                    }else if(counter==4){
                        editor.putString("diff", "average");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), MainActivity14.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("average")){
                    if(counter == 5){

                        Intent intent = new Intent(getApplicationContext(), MainActivity15.class);
                        startActivity(intent);
                    }else if(counter==6){
                        Intent intent = new Intent(getApplicationContext(), MainActivity16.class);
                        startActivity(intent);
                    }else if(counter==7){
                        Intent intent = new Intent(getApplicationContext(), MainActivity17.class);
                        startActivity(intent);
                    }else if(counter==8){
                        Intent intent = new Intent(getApplicationContext(), MainActivity18.class);
                        startActivity(intent);
                    }else if(counter==9){
                        editor.putString("diff", "hard");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), MainActivity20.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("hard")){
                    if(counter == 10){

                        Intent intent = new Intent(getApplicationContext(), MainActivity20.class);
                        startActivity(intent);
                    }else if(counter==11){
                        Intent intent = new Intent(getApplicationContext(), MainActivity21.class);
                        startActivity(intent);
                    }else if(counter==12){
                        Intent intent = new Intent(getApplicationContext(), MainActivity22.class);
                        startActivity(intent);
                    }else if(counter==13){
                        Intent intent = new Intent(getApplicationContext(), MainActivity23.class);
                        startActivity(intent);
                    }else if(counter==14){
                        editor.putString("diff", "extreme");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), MainActivity24.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("extreme")){
                    if(counter == 15){

                        Intent intent = new Intent(getApplicationContext(), MainActivity25.class);
                        startActivity(intent);
                    }else if(counter==16){
                        Intent intent = new Intent(getApplicationContext(), MainActivity27.class);
                        startActivity(intent);
                    }else if(counter==17){
                        Intent intent = new Intent(getApplicationContext(), MainActivity28.class);
                        startActivity(intent);
                    }else if(counter==18){
                        Intent intent = new Intent(getApplicationContext(), MainActivity29.class);
                        startActivity(intent);
                    }else if(counter==19){
                        Intent intent = new Intent(getApplicationContext(), MainActivity30.class);
                        startActivity(intent);
                    }else if(counter==20){
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                    }
                }else if(diff.equals(null)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }
            }else{
                liveCount();

            }



        }
    }

    void liveCount(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int counter = pref.getInt("counter", 0);
        int livesCurrent = pref.getInt("lives",3);


        int x = livesCurrent;
        x-=1;

        editor.putInt("lives", x);
        editor.commit();

        if(x==2){
            heart.setText("\u2764\uFE0F\u2764\uFE0F");
        }else if(x==1){
            heart.setText("\u2764\uFE0F");
        }else if(x==0){
            editor.putInt("lives", 3);
            editor.commit();
            if(counter == 0){
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
            }else if(counter==1){
                Intent intent = new Intent(getApplicationContext(), MainActivity9.class);
                startActivity(intent);
            }else if(counter==2){
                Intent intent = new Intent(getApplicationContext(), MainActivity10.class);
                startActivity(intent);
            }else if(counter==3){
                Intent intent = new Intent(getApplicationContext(), MainActivity11.class);
                startActivity(intent);
            }else if(counter==4){
                Intent intent = new Intent(getApplicationContext(), MainActivity12.class);
                startActivity(intent);
            }else if(counter == 5){

                Intent intent = new Intent(getApplicationContext(), MainActivity14.class);
                startActivity(intent);
            }else if(counter==6){
                Intent intent = new Intent(getApplicationContext(), MainActivity15.class);
                startActivity(intent);
            }else if(counter==7){
                Intent intent = new Intent(getApplicationContext(), MainActivity16.class);
                startActivity(intent);
            }else if(counter==8){
                Intent intent = new Intent(getApplicationContext(), MainActivity17.class);
                startActivity(intent);
            }else if(counter==9){
                Intent intent = new Intent(getApplicationContext(), MainActivity18.class);
                startActivity(intent);
            } if(counter == 10){

                Intent intent = new Intent(getApplicationContext(), MainActivity20.class);
                startActivity(intent);
            }else if(counter==11){
                Intent intent = new Intent(getApplicationContext(), MainActivity21.class);
                startActivity(intent);
            }else if(counter==12){
                Intent intent = new Intent(getApplicationContext(), MainActivity22.class);
                startActivity(intent);
            }else if(counter==13){
                Intent intent = new Intent(getApplicationContext(), MainActivity23.class);
                startActivity(intent);
            }else if(counter==14){
                Intent intent = new Intent(getApplicationContext(), MainActivity24.class);
                startActivity(intent);
            }  if(counter == 15){

                Intent intent = new Intent(getApplicationContext(), MainActivity25.class);
                startActivity(intent);
            }else if(counter==16){
                Intent intent = new Intent(getApplicationContext(), MainActivity27.class);
                startActivity(intent);
            }else if(counter==17){
                Intent intent = new Intent(getApplicationContext(), MainActivity28.class);
                startActivity(intent);
            }else if(counter==18){
                Intent intent = new Intent(getApplicationContext(), MainActivity29.class);
                startActivity(intent);
            }else if(counter==19){
                Intent intent = new Intent(getApplicationContext(), MainActivity30.class);
                startActivity(intent);
            }else if(counter==20){
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        }
    }

    void loadQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        questionsTextview.setText(QuestionAnswer.question[currentQuestionIndex]);
        ans1.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ans2.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ans3.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ans4.setText(QuestionAnswer.choices[currentQuestionIndex][3]);


    }

    void finishQuiz() {
        String passed = "";
        if (score > totalQuestion * 0.50) {
            passed = "Passed";
        } else {
            passed = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passed)
                .setMessage("WELL DONE")
                .setPositiveButton("Finish", (dialogInterface, i) -> restartq())
                .setCancelable(false)
                .show();

    }

    void restartq() {

        score = 0;
        currentQuestionIndex = 0;
        restartq();
    }

    @Override
    public void onBackPressed() {

    }
}
