package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private TextView question;
    private TextView notextview;
    private Button next;
    private RadioGroup radioGroup;
    private Button clear;
    public int score=0;
    public int currQuestion=0;
    public int totalquestions=10;
    public ArrayList<Question> questions = new ArrayList<Question>();
    Question que1 = new Question("In the last week, how often have you been upset because of something that happened unexpectedly?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que2 = new Question("In the last week, how often have you felt that you were unable to control important things in your life?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que3 = new Question("In the last week, how often have you felt nervous and 'stressed'?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que4 = new Question("In the last week, how often have you felt confident about your ability to handle your personal problems?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", false);
    Question que5 = new Question("In the last week, how often have you felt that things were going your way?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", false);
    Question que6 = new Question("In the last week, how often have you found that you could NOT cope with all the things you had to do?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que7 = new Question("In the last week, how often have you been able to control irritations in your life?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", false);
    Question que8 = new Question("In the last week, how often have you felt that you were on top of things?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", false);
    Question que9 = new Question("In the last week, how often have you been angered because of things that happened that were out of your control?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que10 = new Question("In the last week, how often have you felt difficulties were piling up so high that you could not overcome them?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioButton option5;
    public static final String EXTRA_SCORE = "com.example.mentalhealthapp.extra.SCORE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question=findViewById(R.id.question);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        next = (Button)findViewById(R.id.next);
        clear=findViewById(R.id.clear);
        notextview=findViewById(R.id.notextview);
        option1= (RadioButton)findViewById(R.id.option1);
        option2= (RadioButton)findViewById(R.id.option2);
        option3= (RadioButton)findViewById(R.id.option3);
        option4= (RadioButton)findViewById(R.id.option4);
        option5= (RadioButton)findViewById(R.id.option5);
        radioGroup.clearCheck();
        questions.add(que1);
        questions.add(que2);
        questions.add(que3);
        questions.add(que4);
        questions.add(que5);
        questions.add(que6);
        questions.add(que7);
        questions.add(que8);
        questions.add(que9);
        questions.add(que10);
        String Question= questions.get(0).question;
        question.setText(Question);
        option1.setText(questions.get(0).option1);
        option2.setText(questions.get(0).option2);
        option3.setText(questions.get(0).option3);
        option4.setText(questions.get(0).option4);
        option5.setText(questions.get(0).option5);
        String QNo=currQuestion+1+"/"+totalquestions;
        notextview.setText(QNo);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1)
                {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);
                    updateScore(selectedId,questions.get(currQuestion));
                    currQuestion+=1;
                    if(currQuestion<totalquestions)
                    {
                        radioGroup.clearCheck();
                        updateTextview();
                        updateQuestion();
                    }
                    else
                    {
                        Toast.makeText(QuizActivity.this, "Your score is "+score, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(QuizActivity.this,ScoreActivity.class);
                        intent.putExtra(EXTRA_SCORE,Integer.toString(score));
                        startActivity(intent);
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                radioGroup.clearCheck();
            }
        });
    }
    private  void updateScore(int selectedId, Question que)
    {
        if(que.negque){
            switch (selectedId)
            {
                case R.id.option1:
                    score+=0;
                    break;
                case R.id.option2:
                    score+=1;
                    break;
                case R.id.option3:
                    score+=2;
                    break;
                case R.id.option4:
                    score+=3;
                    break;
                case R.id.option5:
                    score+=4;
                    break;
            }
        }else{
            switch (selectedId)
            {
                case R.id.option1:
                    score+=4;
                    break;
                case R.id.option2:
                    score+=3;
                    break;
                case R.id.option3:
                    score+=2;
                    break;
                case R.id.option4:
                    score+=1;
                    break;
                case R.id.option5:
                    score+=0;
                    break;
            }
        }

    }
    private void updateTextview()
    {
        String QNo=currQuestion+1+"/"+totalquestions;
        notextview.setText(QNo);
    }
    private void updateQuestion()
    {
        String Question;
        switch (currQuestion)
        {
            case 0:
                Question= questions.get(0).question;
                question.setText(Question);
                option1.setText(questions.get(0).option1);
                option2.setText(questions.get(0).option2);
                option3.setText(questions.get(0).option3);
                option4.setText(questions.get(0).option4);
                option5.setText(questions.get(0).option5);
                break;
            case 1:
                Question= questions.get(1).question;
                question.setText(Question);
                option1.setText(questions.get(1).option1);
                option2.setText(questions.get(1).option2);
                option3.setText(questions.get(1).option3);
                option4.setText(questions.get(1).option4);
                option5.setText(questions.get(1).option5);
                break;
            case 2:
                Question= questions.get(2).question;
                question.setText(Question);
                option1.setText(questions.get(2).option1);
                option2.setText(questions.get(2).option2);
                option3.setText(questions.get(2).option3);
                option4.setText(questions.get(2).option4);
                option5.setText(questions.get(2).option5);
                break;
            case 3:
                Question= questions.get(3).question;
                question.setText(Question);
                option1.setText(questions.get(3).option1);
                option2.setText(questions.get(3).option2);
                option3.setText(questions.get(3).option3);
                option4.setText(questions.get(3).option4);
                option5.setText(questions.get(3).option5);
                break;
            case 4:
                Question= questions.get(4).question;
                question.setText(Question);
                option1.setText(questions.get(4).option1);
                option2.setText(questions.get(4).option2);
                option3.setText(questions.get(4).option3);
                option4.setText(questions.get(4).option4);
                option5.setText(questions.get(4).option5);
                break;
            case 5:
                Question= questions.get(5).question;
                question.setText(Question);
                option1.setText(questions.get(5).option1);
                option2.setText(questions.get(5).option2);
                option3.setText(questions.get(5).option3);
                option4.setText(questions.get(5).option4);
                option5.setText(questions.get(5).option5);
                break;
            case 6:
                Question= questions.get(6).question;
                question.setText(Question);
                option1.setText(questions.get(6).option1);
                option2.setText(questions.get(6).option2);
                option3.setText(questions.get(6).option3);
                option4.setText(questions.get(6).option4);
                option5.setText(questions.get(6).option5);
                break;
            case 7:
                Question= questions.get(7).question;
                question.setText(Question);
                option1.setText(questions.get(7).option1);
                option2.setText(questions.get(7).option2);
                option3.setText(questions.get(7).option3);
                option4.setText(questions.get(7).option4);
                option5.setText(questions.get(7).option5);
                break;
            case 8:
                Question= questions.get(8).question;
                question.setText(Question);
                option1.setText(questions.get(8).option1);
                option2.setText(questions.get(8).option2);
                option3.setText(questions.get(8).option3);
                option4.setText(questions.get(8).option4);
                option5.setText(questions.get(8).option5);
                break;
            case 9:
                Question= questions.get(9).question;
                question.setText(Question);
                option1.setText(questions.get(9).option1);
                option2.setText(questions.get(9).option2);
                option3.setText(questions.get(9).option3);
                option4.setText(questions.get(9).option4);
                option5.setText(questions.get(9).option5);
                break;
        }
    }
}