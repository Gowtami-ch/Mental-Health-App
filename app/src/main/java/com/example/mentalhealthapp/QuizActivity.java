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
    // Category-1
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
    // Category-2
    Question que11 = new Question("How often do you experience headaches?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que12 = new Question("How often do you experience tense muscles, sore back and neck?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que13 = new Question("How often do you experience fatigue?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que14 = new Question("How often do you experience anxiety, worry or phobias?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que15 = new Question("How often do you experience difficulty falling asleep?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que16 = new Question("How often do you experience irritability?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que17 = new Question("How often do you experience insomnia?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que18 = new Question("How often do you experience bouts of anger/hostility?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que19 = new Question("How often do you experience boredom or depression?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que20 = new Question("How often do you eat too much or too little?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que21 = new Question("How often do you experience diarrhea, cramps, gas or constipation?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    Question que22 = new Question("How often do you experience restlessness, itching or tics?", "Almost everyday", "2-3 times per week", "Once a week", "Once or twice a month", "Never", true);
    // Category-3
    Question que23 = new Question("Rate your satisfaction with the choice of your career", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que24 = new Question("Rate your satisfaction with your present job/business/school", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que25 = new Question("Rate your satisfaction with your marital status", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que26 = new Question("Rate your satisfaction with your primary relationships", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que27 = new Question("Rate your satisfaction with your capacity to have fun", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que28 = new Question("Rate your satisfaction with the amount of fun experienced in last month ", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que29 = new Question("Rate your satisfaction with your financial prospects", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que30 = new Question("Rate your satisfaction with your current income level", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que31 = new Question("Rate your satisfaction with your spirituality", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que32 = new Question("Rate your satisfaction with your level of self-esteem", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que33 = new Question("Rate your satisfaction with the prospects for having impact on those who know you and possibly others", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que34 = new Question("Rate your satisfaction with your sex life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que35 = new Question("Rate your satisfaction with your body, how it looks and performs", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que36 = new Question("Rate your satisfaction with your home life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que37 = new Question("Rate your satisfaction with your life skills and knowledge of issues and facts unrelated to your job or profession", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que38 = new Question("Rate your satisfaction with your stress management capacities", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que39 = new Question("Rate your satisfaction with your nutritional knowledge, attitudes, and choices ", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que40 = new Question("Rate your satisfaction with your ability to recover from disappointment, hurts, setbacks, and tragedies", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que41 = new Question("Rate your satisfaction with your confidence that you currently are, or will in the future be, reasonably close to your highest potential", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que42 = new Question("Rate your satisfaction with your achievement of a rounded or balanced quality in your life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que43 = new Question("Rate your satisfaction with your sense that life for you is on an upward curve, getting better and fuller all the time", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que44 = new Question("Rate your satisfaction with your level of participation in issues and concerns beyond your immediate interests", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que45 = new Question("Rate your satisfaction with your choice whether to parent or not and with the consequences or results of that choice", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que46 = new Question("Rate your satisfaction with your role in some kind of network of friends, relatives, and/or others about whom you care deeply and who reciprocate that commitment to you", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que47 = new Question("Rate your satisfaction with your Emotional acceptance of the inescapable reality of aging", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    // Category-4
    Question que48 = new Question("How frequently do you moderately exercise?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que49 = new Question("How often do you get a full, restful night of sleep?", "Dail", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que50 = new Question("To what extent is your energy sufficient for our work and daily activities?\n", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que51 = new Question("How closely does your weight approach the ideal level?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que52 = new Question("To what extent do you eat a nutritious diet?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que53 = new Question("Which of the following best describes your use of tobacco?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que54 = new Question("Which of the following best describes your use of alcohol?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que55 = new Question("To what extent do you believe that you have a history of coping well with highly stressful" +
            "situations?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que56 = new Question("How confident are you of being able to control your emotions in stressful situations?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que57 = new Question("When things are not going well, how likely are you to view the situation as being temporary\n" +
            "rather than permanent?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que58 = new Question("When something bad happens to you, how likely are you to exaggerate its importance?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que59 = new Question("When stressed by a complex situation, how likely are you to focus your attention on those\n" +
            "aspects of the situation that you can manage?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que60 = new Question("When highly stressed, how capable are you of changing your thinking to calm down?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que61 = new Question("When confronted with a stressful situation, how likely are you to wait passively for events to\n" +
            "develop rather than to take charge?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que62 = new Question("Which of the following courses of action are you most likely to take when you have become\n" +
            "thoroughly frustrated?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que63 = new Question("If you had worn an article of clothing one day and then found it to be flawed, how likely would\n" +
            "you be to return it and ask for a refund?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que64 = new Question("When an unexpected, negative event happens to you, how likely are you to actively seek\n" +
            "information about the event and how to cope with it?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que65 = new Question("How much decision-making power so you have in your family?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que66 = new Question("How much decision-making power do you have in your working environment?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que67 = new Question("To what extent do you believe that events in your life are merely the result of luck, fate, or\n" +
            "chance?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que68 = new Question("What is your best guess as to the extent and quality of contact you had with your parent(s)\n" +
            "shortly after birth?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que69 = new Question("During your early childhood, to what extent was your mother both calm and generally\n" +
            "permissive?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que70 = new Question("How easily do you make friends in a strange situation?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que71 = new Question("When highly stressed, how likely are you to ask friends or relatives for help?\n", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que72 = new Question("In comparison with other people, how likely are you to see others as threatening,\n" +
            "uncooperative, or exploitative?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que73 = new Question("How often are you confused about the intentions of others toward you?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que74 = new Question("To what extent are you aware of practical, healthy ways of relaxing?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que75 = new Question("How frequently do you pursue some highly relaxing practice?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que76 = new Question("How often do you engage in a spiritual practice such as prayer, mediation, or inspirational\n" +
            "reading to enrich your interior life?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que77 = new Question("How connected do you feel to your conception of a higher power or to a worthy cause?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que78 = new Question("To what extent do you believe your life has purpose?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);
    Question que79 = new Question("How much contact do you have with what you would consider a spiritual community?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Never", true);

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