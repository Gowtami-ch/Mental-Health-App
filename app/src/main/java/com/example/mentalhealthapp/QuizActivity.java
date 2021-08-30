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
    public int scores[] = new int[8];
    public int currQuestion=0;
    public int totalquestions=25;
    public int min, max, random_int;
    public ArrayList<Question> questions = new ArrayList<Question>();

    // Well-being and ill-being
    Question que1 = new Question("How often do you experience headaches?","Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que2 = new Question("How often do you experience tense muscles, sore back and neck?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que3 = new Question("How often do you experience fatigue?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que4 = new Question("How often do you experience anxiety, worry or phobias?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que5 = new Question("How often do you experience difficulty falling asleep?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que6 = new Question("How often do you experience irritability?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que7 = new Question("How often do you experience insomnia?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que8 = new Question("How often do you experience bouts of anger/hostility?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que9 = new Question("How often do you experience boredom or depression?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que10 = new Question("How often do you eat too much or too little?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que11 = new Question("How often do you experience diarrhea, cramps, gas or constipation?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    Question que12 = new Question("How often do you experience restlessness, itching or tics?", "Never", "Once or twice a month","Once a week","2-3 times per week","Almost everyday",false);
    //Physical Health
    Question que13 = new Question("How frequently do you moderately exercise?", "Daily", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Seldom", true);
    Question que14 = new Question("How often do you get a full, restful night of sleep?", "Almost every night", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Seldom", true);
    Question que15 = new Question("To what extent is your energy sufficient for your work and daily activities?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que16 = new Question("How closely does your weight approach the ideal level?", "My weight is at the ideal level", "My weight is almost close to the ideal level", "My weight is close to the ideal level", "My weight is not close to the ideal level", "I am dangerously overweight/ underweight", true);
    Question que17 = new Question("To what extent do you eat a nutritious diet?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que18 = new Question("Which of the following best describes your use of tobacco?", "In no period of my life have I had the habit of smoking or chewing tobacco", "Early in my life for a short period I smoked or chewed tobacco", "I stopped smoking or chewing tobacco over the past two years", "I smoke or chew tobacco fairly often", "I smoke or chew tobacco almost everyday", true);
    Question que19 = new Question("Which of the following best describes your use of alcohol?", "I do not abuse alcohol, and never have", "Very occasionally I abuse alcohol", "I have a history of abusing alcohol, but am not presently abusing it", "I abuse alcohol whenever I feel sad or depressed", "I abuse alcohol almost daily", true);
    //Control
    Question que20 = new Question("To what extent do you believe that you have a history of coping well with highly stressful " +
            "situations?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que21 = new Question("How confident are you of being able to control your emotions in stressful situations?", "I never let my emotions run away me", "I seldom let my emotions run away me", "I sometimes let my emotions run away me", "I often let my emotions run away me", "I cannot control my emotions at all in stressful situations", true);
    Question que22 = new Question("When things are not going well, how likely are you to view the situation as being temporary " +
            "rather than permanent?", "Most likely", "Very likely", "Likely", "Unlikely", "Very unlikely", true);
    Question que23 = new Question("When something bad happens to you, how likely are you to exaggerate its importance?", "Very unlikely", "Unlikely", "Likely", "Very likely", "Most likely", true);
    Question que24 = new Question("When stressed by a complex situation, how likely are you to focus your attention on those " +
            "aspects of the situation that you can manage?", "Most likely", "Very likely", "Likely", "Unlikely", "Very unlikely", true);
    Question que25 = new Question("When highly stressed, how capable are you of changing your thinking to calm down?", "Most capable", "Very capable", "Capable", "Incapable", "Very incapable", true);
    Question que26 = new Question("To what extent are you aware of practical, healthy ways of relaxing?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que27 = new Question("How frequently do you pursue some highly relaxing practice?", "Daily or more often", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Seldom", true);
    //Active Coping
    Question que28 = new Question("When confronted with a stressful situation, how likely are you to wait passively for events to " +
            "develop rather than to take charge?", "Very unlikely", "Unlikely", "Likely", "Very likely", "Most likely", true);
    Question que29 = new Question("Which of the following courses of action are you most likely to take when you have become " +
            "thoroughly frustrated?", "Identify an alternate goal and pursue it", "Pursue a relaxing activity", "Withdraw and feel sorry for yourself", "Vent your aggression on someone weaker than you", "Shout, threaten and bombard someone with hostile questions", true);
    Question que30 = new Question("If you had worn an article of clothing one day and then found it to be flawed, how likely would " +
            "you be to return it and ask for a refund?", "Most likely", "Very likely", "Likely", "Unlikely", "Very unlikely", true);
    Question que31 = new Question("When an unexpected, negative event happens to you, how likely are you to actively seek " +
            "information about the event and how to cope with it?", "Most likely", "Very likely", "Likely", "Unlikely", "Very unlikely", true);
    Question que32 = new Question("How much decision-making power so you have in your family?", "More power than any other member of my family", "As much power as any other member of my family", "Less power than some members of my family", "Less power than most members of my family", "Less power than any members of my family", true);
    Question que33 = new Question("How much decision-making power do you have in your working environment?", "More power than any other member of my work team", "As much power as any other member of my work team", "Less power than some members of my work team", "Less power than most members of my work team", "Less power than any members of my work team", true);
    Question que34 = new Question("To what extent do you believe that events in your life are merely the result of luck, fate, or " +
            "chance?",    "To a very little extent","To a little extent","To some extent","To a good extent","To a very great extent", true);
    //Relationships and Belonging
    Question que35 = new Question("What is your best guess as to the extent and quality of contact you had with your parent(s) " +
            "shortly after birth?", "Was given an above average amount of contact by happy parent", "Was given an average amount of contact by happy parent", "Was given an average amount of contact by unhappy (perhaps angry) parent(s)", "Was given a below average amount of contact by unhappy (perhaps angry) parent(s)", "Was given the least amount of contact by unhappy (perhaps angry) parent(s)", true);
    Question que36 = new Question("During your early childhood, to what extent was your mother both calm and generally " +
            "permissive?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que37 = new Question("How easily do you make friends in a strange situation?", "Very easily", "Fairly easily", "Easily", "Uneasily", "Very uneasily", true);
    Question que38 = new Question("When highly stressed, how likely are you to ask friends or relatives for help? ", "Most likely", "Very likely", "Likely", "Unlikely", "Very unlikely", true);
    Question que39 = new Question("In comparison with other people, how likely are you to see others as threatening, " +
            "uncooperative, or exploitative?", "Highly unlikely", "Very unlikely", "Unlikely", "Very likely", "Highly likely", true);
    Question que40 = new Question("How often are you confused about the intentions of others toward you?", "Very infrequently", "Infrequently", "Frequently", "Very frequently", "Almost always", true);
    Question que41 = new Question("Rate your satisfaction with your role in some kind of network of friends, relatives, and/or others about whom you care deeply and who reciprocate that commitment to you", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que42 = new Question("Rate your satisfaction with your marital status", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que43 = new Question("Rate your satisfaction with your primary relationships", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    //Hope and Hopelessness
    Question que44 = new Question("How often do you engage in a spiritual practice such as prayer, mediation, or inspirational " +
            "reading to enrich your interior life?", "Daily or more often", "3-4 times per week", "Once or twice a week", "Once or twice a month", "Seldom", true);
    Question que45 = new Question("How connected do you feel to your conception of a higher power or to a worthy cause?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que46 = new Question("To what extent do you believe your life has purpose?", "To a very great extent", "To a good extent", "To some extent", "To a little extent", "To a very little extent", true);
    Question que47 = new Question("How much contact do you have with what you would consider a spiritual community?", "Very much", "Fairly much", "Not very much", "Little", "Very little", true);
    Question que48 = new Question("Rate your satisfaction with your spirituality", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    // Self Perception
    Question que49 = new Question("Rate your satisfaction with the choice of your career", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que50 = new Question("Rate your satisfaction with your present job/business/school", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que51 = new Question("Rate your satisfaction with your capacity to have fun", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que52 = new Question("Rate your satisfaction with the amount of fun experienced in last month ", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que53 = new Question("Rate your satisfaction with your financial prospects", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que54 = new Question("Rate your satisfaction with your current income level", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que55 = new Question("Rate your satisfaction with your level of self-esteem", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que56 = new Question("Rate your satisfaction with the prospects for having impact on those who know you and possibly others", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que57 = new Question("Rate your satisfaction with your sex life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que58 = new Question("Rate your satisfaction with your body, how it looks and performs", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que59 = new Question("Rate your satisfaction with your home life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que60 = new Question("Rate your satisfaction with your life skills and knowledge of issues and facts unrelated to your job or profession", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que61 = new Question("Rate your satisfaction with your stress management capacities", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que62 = new Question("Rate your satisfaction with your nutritional knowledge, attitudes, and choices ", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que63 = new Question("Rate your satisfaction with your ability to recover from disappointment, hurts, setbacks, and tragedies", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que64 = new Question("Rate your satisfaction with your confidence that you currently are, or will in the future be, reasonably close to your highest potential", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que65 = new Question("Rate your satisfaction with your achievement of a rounded or balanced quality in your life", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que66 = new Question("Rate your satisfaction with your sense that life for you is on an upward curve, getting better and fuller all the time", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que67 = new Question("Rate your satisfaction with your level of participation in issues and concerns beyond your immediate interests", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que68 = new Question("Rate your satisfaction with your choice whether to parent or not and with the consequences or results of that choice", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    Question que69 = new Question("Rate your satisfaction with your Emotional acceptance of the inescapable reality of aging", "Very happy","Mildly happy", "Mildly disappointed", "Very disappointed", "Completely disappointed", true);
    //Stress and Anxiety
    Question que70 = new Question("In the last week, how often have you been upset because of something that happened unexpectedly?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que71 = new Question("In the last week, how often have you felt that you were unable to control important things in your life?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que72 = new Question("In the last week, how often have you felt nervous and 'stressed'?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que73 = new Question("In the last week, how often have you felt confident about your ability to handle your personal problems?","Very Often","Fairly Often","Sometimes","Almost Never", "Never", true);
    Question que74 = new Question("In the last week, how often have you felt that things were going your way?","Very Often","Fairly Often","Sometimes","Almost Never", "Never", true);
    Question que75 = new Question("In the last week, how often have you found that you could NOT cope with all the things you had to do?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que76 = new Question("In the last week, how often have you been able to control irritations in your life?","Very Often","Fairly Often","Sometimes","Almost Never", "Never", true);
    Question que77 = new Question("In the last week, how often have you felt that you were on top of things?","Very Often","Fairly Often","Sometimes","Almost Never", "Never", true);
    Question que78 = new Question("In the last week, how often have you been angered because of things that happened that were out of your control?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);
    Question que79 = new Question("In the last week, how often have you felt difficulties were piling up so high that you could not overcome them?","Never","Almost Never","Sometimes","Fairly Often", "Very Often", true);


    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioButton option5;
    public static final String EXTRA_SCORE = "com.example.mentalhealthapp.extra.SCORE", EXTRA_SCORE_0 = "com.example.mentalhealthapp.extra.SCORE_0", EXTRA_SCORE_1 = "com.example.mentalhealthapp.extra.SCORE_1", EXTRA_SCORE_2 = "com.example.mentalhealthapp.extra.SCORE_2",
            EXTRA_SCORE_3 = "com.example.mentalhealthapp.extra.SCORE_3", EXTRA_SCORE_4 = "com.example.mentalhealthapp.extra.SCORE_4", EXTRA_SCORE_5 = "com.example.mentalhealthapp.extra.SCORE_5",EXTRA_SCORE_6 = "com.example.mentalhealthapp.extra.SCORE_6",
            EXTRA_SCORE_7 = "com.example.mentalhealthapp.extra.SCORE_7";
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
        questions.add(que11);
        questions.add(que12);
        questions.add(que13);
        questions.add(que14);
        questions.add(que15);
        questions.add(que16);
        questions.add(que17);
        questions.add(que18);
        questions.add(que19);
        questions.add(que20);
        questions.add(que21);
        questions.add(que22);
        questions.add(que23);
        questions.add(que24);
        questions.add(que25);
        questions.add(que26);
        questions.add(que27);
        questions.add(que28);
        questions.add(que29);
        questions.add(que30);
        questions.add(que31);
        questions.add(que32);
        questions.add(que33);
        questions.add(que34);
        questions.add(que35);
        questions.add(que36);
        questions.add(que37);
        questions.add(que38);
        questions.add(que39);
        questions.add(que40);
        questions.add(que41);
        questions.add(que42);
        questions.add(que43);
        questions.add(que44);
        questions.add(que45);
        questions.add(que46);
        questions.add(que47);
        questions.add(que48);
        questions.add(que49);
        questions.add(que50);
        questions.add(que51);
        questions.add(que52);
        questions.add(que53);
        questions.add(que54);
        questions.add(que55);
        questions.add(que56);
        questions.add(que57);
        questions.add(que58);
        questions.add(que59);
        questions.add(que60);
        questions.add(que61);
        questions.add(que62);
        questions.add(que63);
        questions.add(que64);
        questions.add(que65);
        questions.add(que66);
        questions.add(que67);
        questions.add(que68);
        questions.add(que69);
        questions.add(que70);
        questions.add(que71);
        questions.add(que72);
        questions.add(que73);
        questions.add(que74);
        questions.add(que75);
        questions.add(que76);
        questions.add(que77);
        questions.add(que78);
        questions.add(que79);
        for(int i=0; i<8; i++){
            scores[i]=0;
        }

        min = 1; max = 12;
        random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        String Question= questions.get(random_int).question;
        question.setText(Question);
        option1.setText(questions.get(random_int).option1);
        option2.setText(questions.get(random_int).option2);
        option3.setText(questions.get(random_int).option3);
        option4.setText(questions.get(random_int).option4);
        option5.setText(questions.get(random_int).option5);
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
                        for(int i=0; i<8; i++)
                        System.out.println(scores[i]);
                        Toast.makeText(QuizActivity.this, "Your score is "+score, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(QuizActivity.this,ScoreActivity.class);
                        intent.putExtra(EXTRA_SCORE,Integer.toString(score));
                        intent.putExtra(EXTRA_SCORE_0,Integer.toString(scores[0])); intent.putExtra(EXTRA_SCORE_1,Integer.toString(scores[1]));
                        intent.putExtra(EXTRA_SCORE_2,Integer.toString(scores[2])); intent.putExtra(EXTRA_SCORE_3,Integer.toString(scores[3]));
                        intent.putExtra(EXTRA_SCORE_4,Integer.toString(scores[4])); intent.putExtra(EXTRA_SCORE_5,Integer.toString(scores[5]));
                        intent.putExtra(EXTRA_SCORE_6,Integer.toString(scores[6])); intent.putExtra(EXTRA_SCORE_7,Integer.toString(scores[7]));
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
        int i;
        if(currQuestion >= 0 && currQuestion <=2){
            i=0;
        }else if(currQuestion >= 3 && currQuestion <=5){
            i=1;
        }else if(currQuestion >=6 && currQuestion <=8){
            i=2;
        }else if(currQuestion >=9 && currQuestion<=11){
            i=3;
        }else if(currQuestion >=12 && currQuestion<=14){
            i=4;
        }else if(currQuestion>=15 && currQuestion<=17){
            i=5;
        }else if(currQuestion>=18 && currQuestion<=21){
            i=6;
        }else{
            i=7;
        }
        switch (selectedId)
        {
            case R.id.option1:
                score+=0;
                scores[i]+=0;
                //System.out.println("Score : "+0);
                break; case R.id.option2: score+=1;
                scores[i]+=1;
                //System.out.println("Score : "+1);
                break; case R.id.option3: score+=2;
                scores[i]+=2;
                //System.out.println("Score : "+2);
                break; case R.id.option4: score+=3;
                scores[i]+=3;
                //System.out.println("Score : "+3);
                break; case R.id.option5: score+=4;
                scores[i]+=4;
                //System.out.println("Score : "+4);
                break;
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
            case 1:
            case 2:
                min = 1; max = 12;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;
            case 3:
            case 4:
            case 5:
                min = 13; max = 19;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;
            case 6:
            case 7:
            case 8:
                min = 20; max = 27;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;
            case 9:
            case 10:
            case 11:
                min = 28; max = 34;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;

            case 12:
            case 13:
            case 14:
                min = 35; max = 43;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;

            case 15:
            case 16:
            case 17:
                min = 44; max = 48;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
                min = 49; max = 69;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;

            case 22:
            case 23:
            case 24:
                min = 70; max = 79;
                random_int = (int)(Math.random()*(max-min+1)+min);
                Question= questions.get(random_int).question;
                question.setText(Question);
                option1.setText(questions.get(random_int).option1);
                option2.setText(questions.get(random_int).option2);
                option3.setText(questions.get(random_int).option3);
                option4.setText(questions.get(random_int).option4);
                option5.setText(questions.get(random_int).option5);
                break;
        }
    }
}