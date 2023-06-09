package com.example.test60.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import com.example.test60.Average.ActivityAverageLevelSelector;
import com.example.test60.Easy.ActivityEasyLevelSelector;
import com.example.test60.Easy.EasyLevel3;
import com.example.test60.Easy.EasyLevel4;
import com.example.test60.Easy.EasyLevel5;
import com.example.test60.Average.AverageLevel1;
import com.example.test60.Average.AverageLevel2;
import com.example.test60.Average.AverageLevel3;
import com.example.test60.Average.AverageLevel4;
import com.example.test60.Average.AverageLevel5;
import com.example.test60.Extreme.ActivityExtremeLevelSelector;
import com.example.test60.Hard.ActivityHardLevelSelector;
import com.example.test60.Hard.HardLevel1;
import com.example.test60.Hard.HardLevel2;
import com.example.test60.Hard.HardLevel3;
import com.example.test60.Hard.HardLevel4;
import com.example.test60.Hard.HardLevel5;
import com.example.test60.Extreme.ExtremeLevel1;
import com.example.test60.Extreme.ExtremeLevel2;
import com.example.test60.Extreme.ExtremeLevel3;
import com.example.test60.Extreme.ExtremeLevel4;
import com.example.test60.Extreme.ExtremeLevel5;
import com.example.test60.Easy.EasyLevel1;
import com.example.test60.Easy.EasyLevel2;
import com.example.test60.Utilities.DifficultiesAndLevels;
import com.example.test60.Utilities.EasyAverageQuestions;
import com.example.test60.Utilities.GlobalApplication;
import com.example.test60.Utilities.HardQuestions;
import com.example.test60.Utilities.MusicService;
import com.example.test60.Utilities.QuestionAnswer;
import com.example.test60.R;
import com.example.test60.Utilities.SoundPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ActivityQuestions extends AppCompatActivity implements View.OnClickListener {

    private DifficultiesAndLevels gameProgress;

    public SoundPlayer sound;
    TextView questionsTextview,txtLevel;
    Button ans1, ans2, ans3, ans4, timer, hint;

    ImageView heart1, heart2, heart3;
    private Button countdownButton;
    private CountDownTimer countDownTimer;
    private int countdownValue;
    ImageView title;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;

    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    private EasyAverageQuestions[] easyAverageQuizData;
    private HardQuestions[] hardQuizData;
    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    private String rightAnswer;
    int livesCurrent;

    private boolean isHintClicked = false;

    private ImageView questions_img;

    private int star_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        sound = ((GlobalApplication) getApplication()).getSoundPlayer();
        title = findViewById(R.id.imageView19);
        questionsTextview = findViewById(R.id.questions);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        heart1 = findViewById(R.id.heart1);
        heart2 = findViewById(R.id.heart2);
        heart3 = findViewById(R.id.heart3);
        timer = findViewById(R.id.timer);
        hint = findViewById(R.id.hint);
        countdownButton = findViewById(R.id.timer);
        txtLevel = findViewById(R.id.txtLevel);
        questions_img = findViewById(R.id.questions_img);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);

        gameProgress = new DifficultiesAndLevels(ActivityQuestions.this);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int counter = pref.getInt("counter", 0);
        currentQuestionIndex = counter;

        //level name
        if(counter == 0){
            title.setImageResource(R.drawable.easy_text);
            txtLevel.setText("LEVEL 1");
            countdownValue = 20;
            easyAverageQuizData = QuestionAnswer.easyQuestions;
            star_layout = R.layout.activity_congrats_2;
        }else if(counter == 1){
            title.setImageResource(R.drawable.easy_text);
            txtLevel.setText("LEVEL 2");
            countdownValue = 20;
            easyAverageQuizData = QuestionAnswer.easyQuestions;
            star_layout = R.layout.activity_congrats_2;
        }else if(counter == 2){
            title.setImageResource(R.drawable.easy_text);
            txtLevel.setText("LEVEL 3");
            countdownValue = 20;
            easyAverageQuizData = QuestionAnswer.easyQuestions;
            star_layout = R.layout.activity_congrats_2;
        }else if(counter == 3){
            title.setImageResource(R.drawable.easy_text);
            txtLevel.setText("LEVEL 4");
            countdownValue = 20;
            easyAverageQuizData = QuestionAnswer.easyQuestions;
            star_layout = R.layout.activity_congrats_2;
        }else if(counter == 4){
            title.setImageResource(R.drawable.easy_text);
            txtLevel.setText("LEVEL 5");
            countdownValue = 20;
            easyAverageQuizData = QuestionAnswer.easyQuestions;
            star_layout = R.layout.activity_congrats_2;
        }else if(counter == 5){
            title.setImageResource(R.drawable.average_text);
            txtLevel.setText("LEVEL 1");
            countdownValue = 30;
            easyAverageQuizData = QuestionAnswer.averageQuestions;
            star_layout = R.layout.activity_congrats_3;
        }else if(counter == 6){
            title.setImageResource(R.drawable.average_text);
            txtLevel.setText("LEVEL 2");
            countdownValue = 30;
            easyAverageQuizData = QuestionAnswer.averageQuestions;
            star_layout = R.layout.activity_congrats_3;
        }else if(counter == 7){
            title.setImageResource(R.drawable.average_text);
            txtLevel.setText("LEVEL 3");
            countdownValue = 30;
            easyAverageQuizData = QuestionAnswer.averageQuestions;
            star_layout = R.layout.activity_congrats_3;
        }else if(counter == 8){
            title.setImageResource(R.drawable.average_text);
            txtLevel.setText("LEVEL 4");
            countdownValue = 30;
            easyAverageQuizData = QuestionAnswer.averageQuestions;
            star_layout = R.layout.activity_congrats_3;
        }else if(counter == 9){
            title.setImageResource(R.drawable.average_text);
            txtLevel.setText("LEVEL 5");
            countdownValue = 30;
            easyAverageQuizData = QuestionAnswer.averageQuestions;
            star_layout = R.layout.activity_congrats_3;
        }else if(counter == 10){
            title.setImageResource(R.drawable.hard_text);
            txtLevel.setText("LEVEL 1");
            countdownValue = 40;
            hardQuizData = QuestionAnswer.hardQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_4;
        }else if(counter == 11){
            title.setImageResource(R.drawable.hard_text);
            txtLevel.setText("LEVEL 2");
            countdownValue = 40;
            hardQuizData = QuestionAnswer.hardQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_4;
        }else if(counter == 12){
            title.setImageResource(R.drawable.hard_text);
            txtLevel.setText("LEVEL 3");
            countdownValue = 40;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_4;
        }else if(counter == 13){
            title.setImageResource(R.drawable.hard_text);
            txtLevel.setText("LEVEL 4");
            countdownValue = 40;
            hardQuizData = QuestionAnswer.hardQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_4;
        }else if(counter == 14){
            title.setImageResource(R.drawable.hard_text);
            txtLevel.setText("LEVEL 5");
            countdownValue = 40;
            hardQuizData = QuestionAnswer.hardQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_4;
        }else if(counter == 15){
            title.setImageResource(R.drawable.extreme_text);
            txtLevel.setText("LEVEL 1");
            countdownValue = 50;
            hardQuizData = QuestionAnswer.extremeQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_5;
        }else if(counter == 16){
            title.setImageResource(R.drawable.extreme_text);
            txtLevel.setText("LEVEL 2");
            countdownValue = 50;
            hardQuizData = QuestionAnswer.extremeQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_5;
        }else if(counter == 17){
            title.setImageResource(R.drawable.extreme_text);
            txtLevel.setText("LEVEL 3");
            countdownValue = 50;
            hardQuizData = QuestionAnswer.extremeQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_5;
        }else if(counter == 18){
            title.setImageResource(R.drawable.extreme_text);
            txtLevel.setText("LEVEL 4");
            countdownValue = 50;
            hardQuizData = QuestionAnswer.extremeQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_5;
        }else if(counter == 19){
            title.setImageResource(R.drawable.extreme_text);
            txtLevel.setText("LEVEL 5");
            countdownValue = 50;
            hardQuizData = QuestionAnswer.extremeQuestions;
            questions_img.setVisibility(View.VISIBLE);
            star_layout = R.layout.activity_congrats_5;
        }


        if(easyAverageQuizData != null){
            for (EasyAverageQuestions quizDatum : easyAverageQuizData) {
                //prepare Array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizDatum.getQuestion()); //question
                tmpArray.add(quizDatum.getCorrectAnswer()); //right answer
                tmpArray.add(quizDatum.getChoice1()); //choice1
                tmpArray.add(quizDatum.getChoice2()); //choice2
                tmpArray.add(quizDatum.getChoice3()); //choice3

                //add tmpArray to quizArray
                quizArray.add(tmpArray);
            }
        }

        if(hardQuizData != null){
            for (HardQuestions quizDatum : hardQuizData) {
                //prepare Array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizDatum.getQuestion()); //question
                tmpArray.add(quizDatum.getCorrectAnswer()); //right answer
                tmpArray.add(quizDatum.getChoice1()); //choice1
                tmpArray.add(quizDatum.getChoice2()); //choice2
                tmpArray.add(quizDatum.getChoice3()); //choice3
                tmpArray.add(String.valueOf(quizDatum.getImageId())); //int img

                //add tmpArray to quizArray
                quizArray.add(tmpArray);
            }
        }

        startCountdown();
        loadQuestion();

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isHintClicked){
                    isHintClicked = true;
                    sound.playClick();

                    ans1.setAlpha(1.0f);
                    ans2.setAlpha(1.0f);
                    ans3.setAlpha(1.0f);
                    ans4.setAlpha(1.0f);

                    Button[] answerButtons = { ans1, ans2, ans3, ans4 };
                    List<Button> remainingButtons = new ArrayList<>();

                    // Add all buttons that are not the correct answer to the remainingButtons list
                    for (Button button : answerButtons) {
                        if (!button.getText().equals(rightAnswer)) {
                            remainingButtons.add(button);
                        }
                    }

                    // Choose a random button to hide
                    Random rand = new Random();
                    int index = rand.nextInt(remainingButtons.size());
                    Button buttonToHide = remainingButtons.get(index);

                    // Hide the chosen button
                    buttonToHide.setVisibility(View.GONE);
                    liveCount();
                } else {
                    Toast.makeText(ActivityQuestions.this, "Hint already used", Toast.LENGTH_SHORT).show();
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
        sound.playClick();
        ans1.setAlpha(0.4f);
        ans2.setAlpha(0.4f);
        ans3.setAlpha(0.4f);
        ans4.setAlpha(0.4f);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.ans1 || clickedButton.getId() == R.id.ans2 || clickedButton.getId() == R.id.ans3 || clickedButton.getId() == R.id.ans4) {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setAlpha(1.0f);

            SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            int counter = pref.getInt("counter", 0);

            if (selectedAnswer.equals(rightAnswer)) {
                int x = counter;
                x+=1;

                editor.putInt("counter",x);
                editor.commit();

                String diff = pref.getString("diff", null);

                currentQuestionIndex = x;

                if(countDownTimer != null){
                    countDownTimer.cancel();
                }

                //show first here a well done layout
                sound.playAfterQuiz();
                showWellDone(counter, diff, editor);

            }else{
                liveCount();
            }
        }
    }

    private void showWellDone(int counter, String diff, SharedPreferences.Editor editor){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(star_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.MATCH_PARENT);
        window.setGravity(Gravity.CENTER);

        ImageButton btnContinue = dialog.findViewById(R.id.con);
        ImageButton btnHome = dialog.findViewById(R.id.homeBtn);
        ImageButton btnSettings = dialog.findViewById(R.id.settingsBtn);
        ImageButton btnBack = dialog.findViewById(R.id.backBtn3);
        if(counter==0){
            gameProgress.unlockLevel("easy2_unlocked");
        }
       else if(counter ==1){
            gameProgress.unlockLevel("easy3_unlocked");

        }else if(counter ==2){
            gameProgress.unlockLevel("easy4_unlocked");
        }
        else if(counter ==3){
            gameProgress.unlockLevel("easy5_unlocked");
        }
        else if(counter ==4){
            gameProgress.unlockLevel("average1_unlocked");
        }
        else if(counter ==5){
            gameProgress.unlockLevel("average2_unlocked");
        }
        else if(counter ==6){
            gameProgress.unlockLevel("average3_unlocked");
        }
        else if(counter ==7){
            gameProgress.unlockLevel("average4_unlocked");
        }
        else if(counter ==8){
            gameProgress.unlockLevel("average5_unlocked");
        }
        else if(counter ==9){
            gameProgress.unlockLevel("hard1_unlocked");
        }
        else if(counter ==10){
            gameProgress.unlockLevel("hard2_unlocked");
        }
        else if(counter ==11){
            gameProgress.unlockLevel("hard3_unlocked");
        }
        else if(counter ==12){
            gameProgress.unlockLevel("hard4_unlocked");
        }
        else if(counter ==13){
            gameProgress.unlockLevel("hard5_unlocked");
        }
        else if(counter ==14){
            gameProgress.unlockLevel("extreme1_unlocked");
        }

        else if(counter ==15){
            gameProgress.unlockLevel("extreme2_unlocked");
        }
        else if(counter ==16){
            gameProgress.unlockLevel("extreme3_unlocked");
        }
        else if(counter ==17){
            gameProgress.unlockLevel("extreme4_unlocked");
        }
        else if(counter ==18){
            gameProgress.unlockLevel("extreme5_unlocked");
        }
        else if(counter ==19){
            gameProgress.gameComplete("game_completed");
        }
        else if(counter ==20){

        }


        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();

                //if user clicks continue, the following code will be executed.
                if(diff.trim().equals("easy")){
                    if(counter == 0){

                        gameProgress.unlockLevel("easy2_unlocked");
                        //Toast.makeText(ActivityQuestions.this, "easy2_unlocked "+gameProgress.isLevelUnlocked("easy2_unlocked") , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), EasyLevel2.class);
                        startActivity(intent);
                    }else if(counter==1){

                        Intent intent = new Intent(getApplicationContext(), EasyLevel3.class);
                        startActivity(intent);
                    }else if(counter==2){
                        Intent intent = new Intent(getApplicationContext(), EasyLevel4.class);
                        startActivity(intent);
                    }else if(counter==3){
                        Intent intent = new Intent(getApplicationContext(), EasyLevel5.class);
                        startActivity(intent);
                    }else if(counter==4){
                        editor.putString("diff", "average");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), AverageLevel1.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("average")){
                    if(counter == 5){

                        Intent intent = new Intent(getApplicationContext(), AverageLevel2.class);
                        startActivity(intent);
                    }else if(counter==6){
                        Intent intent = new Intent(getApplicationContext(), AverageLevel3.class);
                        startActivity(intent);
                    }else if(counter==7){
                        Intent intent = new Intent(getApplicationContext(), AverageLevel4.class);
                        startActivity(intent);
                    }else if(counter==8){
                        Intent intent = new Intent(getApplicationContext(), AverageLevel5.class);
                        startActivity(intent);
                    }else if(counter==9){
                        editor.putString("diff", "hard");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), HardLevel1.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("hard")){
                    if(counter == 10){

                        Intent intent = new Intent(getApplicationContext(), HardLevel2.class);
                        startActivity(intent);
                    }else if(counter==11){
                        Intent intent = new Intent(getApplicationContext(), HardLevel3.class);
                        startActivity(intent);
                    }else if(counter==12){
                        Intent intent = new Intent(getApplicationContext(), HardLevel4.class);
                        startActivity(intent);
                    }else if(counter==13){
                        Intent intent = new Intent(getApplicationContext(), HardLevel5.class);
                        startActivity(intent);
                    }else if(counter==14){
                        editor.putString("diff", "extreme");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), ExtremeLevel1.class);
                        startActivity(intent);
                    }
                }else if(diff.trim().equals("extreme")){
                    if(counter == 15){

                        Intent intent = new Intent(getApplicationContext(), ExtremeLevel2.class);
                        startActivity(intent);
                    }else if(counter==16){
                        Intent intent = new Intent(getApplicationContext(), ExtremeLevel3.class);
                        startActivity(intent);
                    }else if(counter==17){
                        Intent intent = new Intent(getApplicationContext(), ExtremeLevel4.class);
                        startActivity(intent);
                    }else if(counter==18){
                        Intent intent = new Intent(getApplicationContext(), ExtremeLevel5.class);
                        startActivity(intent);
                    }else if(counter==19){

                        Intent intent = new Intent(getApplicationContext(), ActivityExtremeLevelSelector.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }
                }else if(diff.equals(null)){
                    Intent intent = new Intent(getApplicationContext(), ActivitySelectDifficulty.class);
                    startActivity(intent);
                }
                if(countDownTimer != null){
                    countDownTimer.cancel();
                }

                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                stopService(new Intent(ActivityQuestions.this, MusicService.class));
                Intent intent = new Intent(ActivityQuestions.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivityQuestions.this, ActivitySettings.class);
                startActivity(intentLoadNewActivity);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();


                SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                String diff = pref.getString("diff", null);

                if(diff.trim().equals("easy")){
                    Intent intent = new Intent(getApplicationContext(), ActivityEasyLevelSelector.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if(diff.trim().equals("average")){
                    Intent intent = new Intent(getApplicationContext(), ActivityAverageLevelSelector.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if(diff.trim().equals("hard")){
                    Intent intent = new Intent(getApplicationContext(), ActivityHardLevelSelector.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if(diff.trim().equals("extreme")){
                    Intent intent = new Intent(getApplicationContext(), ActivityExtremeLevelSelector.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

                finish();
            }
        });

        dialog.show();
    }

    void liveCount(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("level", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        int counter = pref.getInt("counter", 0);
        livesCurrent = pref.getInt("lives",3);


        int x = livesCurrent;
        x-=1;

        editor.putInt("lives", x);
        editor.commit();

        if(x==2){
            heart3.setVisibility(View.INVISIBLE);
        }else if(x==1){
            heart3.setVisibility(View.INVISIBLE);
            heart2.setVisibility(View.INVISIBLE);
        }else if(x==0){
            editor.putInt("lives", 3);
            editor.commit();

            if(countDownTimer !=null) {
                countDownTimer.cancel();
            }

            //this is just a test, will show a game over layout
            sound.playGameOver();
            showGameOver();

        }
    }

    private void showGameOver(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.activity_game_over_2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.MATCH_PARENT);
        window.setGravity(Gravity.CENTER);

        ImageButton btnTryAgain = dialog.findViewById(R.id.tryAgain);
        ImageButton btnHome = dialog.findViewById(R.id.homeBtn);
        ImageButton btnSettings = dialog.findViewById(R.id.settingsBtn);
        ImageButton btnBack = dialog.findViewById(R.id.backBtn3);

        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                //if the user clicks try again, layout will be GONE.
                //load Another set of question
                startCountdown();
                livesCurrent = 3;
                loadQuestion();
                ans1.setAlpha(1.0f);
                ans2.setAlpha(1.0f);
                ans3.setAlpha(1.0f);
                ans4.setAlpha(1.0f);
                heart3.setVisibility(View.VISIBLE);
                heart2.setVisibility(View.VISIBLE);
                isHintClicked = false;
                ans1.setVisibility(View.VISIBLE);
                ans2.setVisibility(View.VISIBLE);
                ans3.setVisibility(View.VISIBLE);
                ans4.setVisibility(View.VISIBLE);

                dialog.dismiss();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                stopService(new Intent(ActivityQuestions.this, MusicService.class));
                Intent intent = new Intent(ActivityQuestions.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                Intent intentLoadNewActivity = new Intent(ActivityQuestions.this, ActivitySettings.class);
                startActivity(intentLoadNewActivity);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.playClick();
                finish();
            }
        });

        dialog.show();
    }

    void loadQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }

        //Generate random number(quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Pick one quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //Set question and right Answer
        //Array format {"Question", "Right Answer", "Choice1", "Choice2", "3"}
        //Array format {"Question", "Right Answer", "Choice1", "Choice2", "3", String.valueOf(Image)} <- for hard questions
        rightAnswer = quiz.get(1);
        questionsTextview.setText(quiz.get(0));
        if(hardQuizData != null){
            questions_img.setImageResource(Integer.parseInt(quiz.get(5)));
            quiz.remove(5);
        }

        //remove question from quiz and shuffle choices
        quiz.remove(0);
        Collections.shuffle(quiz);

        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));
        ans4.setText(quiz.get(3));

        //remove this quiz from quizArray
        quizArray.remove(randomNum);

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
