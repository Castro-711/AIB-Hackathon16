package aib.hackathon.johneric.sustainablesmarts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

import aib.hackathon.johneric.sustainablesmarts.Question;
import aib.hackathon.johneric.sustainablesmarts.Quiz;
import aib.hackathon.johneric.sustainablesmarts.Answer;

public class QuizActivity extends AppCompatActivity {

    private TextView questionView;
    private RadioGroup radGroup;
    private RadioButton rad1;
    private RadioButton rad2;
    private RadioButton rad3;
    private RadioButton rad4;
    private Button nextQ;
    private Button backQ;

    public static int curQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        // call the getQuestions method
        final Quiz currentQ = getQuestions();

        // set current score
        currentQ.setQuizScore(0);

        // init all the components
        questionView = (TextView) findViewById(R.id.questionHeading);
        radGroup = (RadioGroup) findViewById(R.id.radGroup);
        rad1 = (RadioButton) findViewById(R.id.radioButton1);
        rad2 = (RadioButton) findViewById(R.id.radioButton2);
        rad3 = (RadioButton) findViewById(R.id.radioButton3);
        rad4 = (RadioButton) findViewById(R.id.radioButton4);
        nextQ = (Button) findViewById(R.id.nextBtn);
        backQ = (Button) findViewById(R.id.backBtn);


        // set the current question
        questionView.setText(currentQ.getQuestions()[0].getQuestion());
        // set the new question
        for(int i = 0; i < 4; i++)
        {
            String answer = currentQ.getQuestions()[0].getAnswers()[i].getAnswer();
            ((RadioButton) radGroup.getChildAt(i)).setText(answer.toCharArray(), 0, answer.length());
        }



        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(curQuestion < 8)
                    curQuestion++;
                else
                {
                    Intent result_act = new Intent(QuizActivity.this, ResultActivity.class);
                    result_act.putExtra("result", "" + currentQ.getQuizScore());
                    startActivity(result_act);
                }

                int id = radGroup.getCheckedRadioButtonId();

                Log.i("checked Radio", " " + id);

                questionView.setText(currentQ.getQuestions()[curQuestion].getQuestion());
                // set the new question
                for(int i = 0; i < 4; i++)
                {
                    String answer = currentQ.getQuestions()[curQuestion].getAnswers()[i].getAnswer();
                    ((RadioButton) radGroup.getChildAt(i)).setText(answer.toCharArray(), 0, answer.length());

                    if(currentQ.getQuestions()[curQuestion].getAnswers()[i].getIsRight())
                        if(radGroup.getChildAt(i).getId() == radGroup.getCheckedRadioButtonId())
                            currentQ.setQuizScore(currentQ.getQuizScore() + 1);
                }
            }
        });

        backQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(curQuestion > 0)
                    curQuestion--;

                questionView.setText(currentQ.getQuestions()[curQuestion].getQuestion());
                // set the new question
                for(int i = 0; i < 4; i++)
                {
                    String answer = currentQ.getQuestions()[curQuestion].getAnswers()[i].getAnswer();
                    ((RadioButton) radGroup.getChildAt(i)).setText(answer.toCharArray(), 0, answer.length());
                }
            }
        });


    }

//    public final int getFinal(final int current)
//    {
//        return questionNum[current + 1];
//    }


    public Quiz getQuestions()
    {
        // create the quiz to hold the questions
        Question[] quizQuestions =  new Question[20];

        // ----- Question 1 ----- //
        // how long to power your plasma tv for an hour

        // create an answer array
        Answer[] tvLightPushUp = new Answer[4];

        // create 4 answers
        tvLightPushUp[0] = new Answer("Light press ups for over 2.5 hours", false);
        tvLightPushUp[1] = new Answer("Light press ups for over 3.5 hours", false);
        tvLightPushUp[2] = new Answer("Light press ups for over 4.5 hours", true);
        tvLightPushUp[3] = new Answer("Light press ups for over 5.5 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[0] = new Question(
                "How long do you think you would have to perform light push ups to power" +
                        "your Plasma TV for an hour?", tvLightPushUp);

        // ----- Question 2 ----- //

        // create an answer array
        Answer[] tvDarts = new Answer[4];

        // create 4 answers
        tvDarts[0] = new Answer("Play darts for 6.5 hours", true);
        tvDarts[1] = new Answer("Play darts for 7.5 hours", false);
        tvDarts[2] = new Answer("Play darts for 8.5 hours", false);
        tvDarts[3] = new Answer("Play darts for 9.5 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[1] = new Question(
                "How long do you think you would have to play darts to power" +
                        "your Plasma TV for an hour?", tvDarts);

        // ----- Question 3 ----- //

        // create an answer array
        Answer[] tvInStreamFishing = new Answer[4];

        // create 4 answers
        tvInStreamFishing[0] = new Answer("Fish in a stream for 1.7 hours", false);
        tvInStreamFishing[1] = new Answer("Fish in a stream for 2.7 hours", true);
        tvInStreamFishing[2] = new Answer("Fish in a stream for 3.7 hours", false);
        tvInStreamFishing[3] = new Answer("Fish in a stream for 4.7 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[2] = new Question(
                "How long do you think you would have to fish in a stream to power" +
                        "your Plasma TV for an hour?", tvInStreamFishing);

        // ----- Question 4 ----- //

        // create an answer array
        Answer[] tvLesuireCycle = new Answer[4];

        // create 4 answers
        tvLesuireCycle[0] = new Answer("Leisurely cycle (>10mph) for over 3 hours", false);
        tvLesuireCycle[1] = new Answer("Leisurely cycle (>10mph) for over 4 hours", true);
        tvLesuireCycle[2] = new Answer("Leisurely cycle (>10mph) for over 5 hours", false);
        tvLesuireCycle[3] = new Answer("Leisurely cycle (>10mph) for over 6 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[3] = new Question(
                "How long do you think you would have to cycle leisurely (>10mph) to power" +
                        "your Plasma TV for an hour?", tvLesuireCycle);

        // ----- Question 5 ----- //
        // power a gaming station

        // create an answer array
        Answer[] gamingHopscotch = new Answer[4];

        // create 4 answers
        gamingHopscotch[0] = new Answer("Play hopscotch for over 3.7 hours", false);
        gamingHopscotch[1] = new Answer("Play hopscotch for over 6.7 hours", true);
        gamingHopscotch[2] = new Answer("Play hopscotch for over 4.7 hours", false);
        gamingHopscotch[3] = new Answer("Play hopscotch for over 5.7 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[4] = new Question(
                "How long do you think you would have to play hopscotch for to power" +
                        "your Gaming Desktop for an hour?", gamingHopscotch);

        // ----- Question 6 ----- //

        // create an answer array
        Answer[] gamingGolfing = new Answer[4];

        // create 4 answers
        gamingGolfing[0] = new Answer("Play golf for over 7.4 hours", true);
        gamingGolfing[1] = new Answer("Play golf for over 8.4 hours", false);
        gamingGolfing[2] = new Answer("Play golf for over 9.4 hours", false);
        gamingGolfing[3] = new Answer("Play golf for over 10.4 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[5] = new Question(
                "How long do you think you would have to play a general game of golf to power" +
                        "your Gaming Desktop for an hour?", gamingGolfing);

        // ----- Question 7 ----- //

        // create an answer array
        Answer[] gamingCarpentry = new Answer[4];

        // create 4 answers
        gamingCarpentry[0] = new Answer("Do carpentry work for 6.5 hours", false);
        gamingCarpentry[1] = new Answer("Do carpentry work for 7.5 hours", false);
        gamingCarpentry[2] = new Answer("Do carpentry work for 8.5 hours", false);
        gamingCarpentry[3] = new Answer("Do carpentry work for 9.5 hours", true);

        // now generate the question giving it the answer array
        quizQuestions[6] = new Question(
                "How long do you think you would have to play a general game of golf to power" +
                        "your Gaming Desktop for an hour?", gamingCarpentry);

        // ----- Question 8 ----- //

        // create an answer array
        Answer[] gamingDarts = new Answer[4];

        // create 4 answers
        gamingDarts[0] = new Answer("Play darts for over 13.4 hours", true);
        gamingDarts[1] = new Answer("Play darts for over 14.4 hours", false);
        gamingDarts[2] = new Answer("Play darts for over 15.4 hours", false);
        gamingDarts[3] = new Answer("Play darts for over 16.4 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[7] = new Question(
                "How long do you think you would have to play a general game of golf to power" +
                        "your Gaming Desktop for an hour?", gamingDarts);

        // ----- Question 9 ----- //
        // to power your gaming console (ps4)

        // create an answer array
        Answer[] consoleDarts = new Answer[4];

        // create 4 answers
        consoleDarts[0] = new Answer("Play darts for over 3.8 hours", true);
        consoleDarts[1] = new Answer("Play darts for over 4.8 hours", false);
        consoleDarts[2] = new Answer("Play darts for over 5.8 hours", false);
        consoleDarts[3] = new Answer("Play darts for over 2.8 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[8] = new Question(
                "How long do you think you would have to play a general game of golf to power" +
                        "your Gaming Console (PS4) for an hour?", consoleDarts);

        // ----- Question 10 ----- //

        // create an answer array
        Answer[] consoleFootball = new Answer[4];

        // create 4 answers
        consoleFootball[0] = new Answer("Play competitive football for over 1.6 hours", true);
        consoleFootball[1] = new Answer("Play competitive football for over 0.6 hours", false);
        consoleFootball[2] = new Answer("Play competitive football for over 2.6 hours", false);
        consoleFootball[3] = new Answer("Play competitive football for over 3.6 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[9] = new Question(
                "How long do you think you would have to play competitive football for to power" +
                        "your Gaming Console (PS4) for an hour?", consoleFootball);

        // ----- Question 11 ----- //

        // create an answer array
        Answer[] consoleFishingStand = new Answer[4];

        // create 4 answers
        consoleFishingStand[0] = new Answer("Fish while standing for 2.7 hours", true);
        consoleFishingStand[1] = new Answer("Fish while standing for 3.7 hours", false);
        consoleFishingStand[2] = new Answer("Fish while standing for 1.7 hours", false);
        consoleFishingStand[3] = new Answer("Fish while standing for 4.7 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[10] = new Question(
                "How long do you think you would have to fish while standing to power" +
                        "your Gaming Console (PS4) for an hour?", consoleFishingStand);

        // ----- Question 12 ----- //

        // create an answer array
        Answer[] consoleElectrical = new Answer[4];

        // create 4 answers
        consoleElectrical[0] = new Answer("Do electrical work for 2.7 hours", true);
        consoleElectrical[1] = new Answer("Do electrical work for 3.7 hours", false);
        consoleElectrical[2] = new Answer("Do electrical work for 4.7 hours", false);
        consoleElectrical[3] = new Answer("Do electrical work for 5.7 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[11] = new Question(
                "How long do you think you would have to do electrical work for to power" +
                        "your Gaming Console (PS4) for an hour?", consoleElectrical);

        // ----- Question 13 ----- //

        // create an answer array
        Answer[] fridgeElectrical = new Answer[4];

        // create 4 answers
        fridgeElectrical[0] = new Answer("Do electrical work for 19.2 hours", true);
        fridgeElectrical[1] = new Answer("Do electrical work for 20.2 hours", false);
        fridgeElectrical[2] = new Answer("Do electrical work for 24.2 hours", false);
        fridgeElectrical[3] = new Answer("Do electrical work for 15.2 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[12] = new Question(
                "How long do you think you would have to do electrical work for to power" +
                        "your Fridge for an hour?", fridgeElectrical);

        // ----- Question 14 ----- //

        // create an answer array
        Answer[] fridgeHopscotch = new Answer[4];

        // create 4 answers
        fridgeHopscotch[0] = new Answer("Play hopscotch for 13.4 hours", true);
        fridgeHopscotch[1] = new Answer("Play hopscotch for 14.4 hours", false);
        fridgeHopscotch[2] = new Answer("Play hopscotch for 15.4 hours", false);
        fridgeHopscotch[3] = new Answer("Play hopscotch for 12.4 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[13]= new Question(
                "How long do you think you would have to play hopscotch to power" +
                        "your Fridge for an hour?", fridgeHopscotch);

        // ----- Question 15 ----- //

        // create an answer array
        Answer[] fridgeGolf = new Answer[4];

        // create 4 answers
        fridgeGolf[0] = new Answer("Play a general game of golf for 15.3 hours", true);
        fridgeGolf[1] = new Answer("Play a general game of golf for 16.3 hours", false);
        fridgeGolf[2] = new Answer("Play a general game of golf for 17.3 hours", false);
        fridgeGolf[3] = new Answer("Play a general game of golf for 18.3 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[14] = new Question(
                "How long do you think you would have to play a general game of golf to power" +
                        "your Fridge for an hour?", fridgeGolf);

        // ----- Question 16 ----- //

        // create an answer array
        Answer[] fridgeSkiMachine = new Answer[4];

        // create 4 answers
        fridgeSkiMachine[0] = new Answer("Use a ski machine for 6.5 hours", true);
        fridgeSkiMachine[1] = new Answer("Use a ski machine for 4.5 hours", false);
        fridgeSkiMachine[2] = new Answer("Use a ski machine for 8.5 hours", false);
        fridgeSkiMachine[3] = new Answer("Use a ski machine for 10.5 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[15] = new Question(
                "How long do you think you would have to use a ski machine to power" +
                        "your Fridge for an hour?", fridgeSkiMachine);

        // ----- Question 17 ----- //

        // create an answer array
        Answer[] ovenCalisthentics = new Answer[4];

        // create 4 answers
        ovenCalisthentics[0] = new Answer("Perform a calisthetics exercise for 29.3 hours", true);
        ovenCalisthentics[1] = new Answer("Perform a calisthetics exercise for 25.3 hours", false);
        ovenCalisthentics[2] = new Answer("Perform a calisthetics exercise for 32.3 hours", false);
        ovenCalisthentics[3] = new Answer("Perform a calisthetics exercise for 35.3 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[16] = new Question(
                "How long do you think you would have to perform a given calisthetics exercise to power" +
                        "your Oven for an hour?", ovenCalisthentics);

        // ----- Question 18 ----- //

        // create an answer array
        Answer[] ovenFootball = new Answer[4];

        // create 4 answers
        ovenFootball[0] = new Answer("Play competitive football for over 15.9 hours", true);
        ovenFootball[1] = new Answer("Play competitive football for over 16.9 hours", false);
        ovenFootball[2] = new Answer("Play competitive football for over 17.9 hours", false);
        ovenFootball[3] = new Answer("Play competitive football for over 18.9 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[17] = new Question(
                "How long do you think you would have to play football to power" +
                        "your Oven for an hour?", ovenFootball);

        // ----- Question 19 ----- //

        // create an answer array
        Answer[] ovenStairMachine = new Answer[4];

        // create 4 answers
        ovenStairMachine[0] = new Answer("Use the stair master for 22.4 hours", true);
        ovenStairMachine[1] = new Answer("Use the stair master for 20.4 hours", false);
        ovenStairMachine[2] = new Answer("Use the stair master for 18.4 hours", false);
        ovenStairMachine[3] = new Answer("Use the stair master for 16.4 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[18] = new Question(
                "How long do you think you would have to the stair master to power" +
                        "your Oven for an hour?", ovenStairMachine);

        // ----- Question 20 ----- //

        // create an answer array
        Answer[] ovenHopscotch = new Answer[4];

        // create 4 answers
        ovenHopscotch[0] = new Answer("Play hopscotch for 28.8 hours", true);
        ovenHopscotch[1] = new Answer("Play hopscotch for 30.8 hours", false);
        ovenHopscotch[2] = new Answer("Play hopscotch for 32.8 hours", false);
        ovenHopscotch[3] = new Answer("Play hopscotch for 34.8 hours", false);

        // now generate the question giving it the answer array
        quizQuestions[19] = new Question(
                "How long do you think you would have to play hopscotch to power" +
                        "your Oven for an hour?", ovenHopscotch);


        Random rand = new Random();

        Question[] currentQuiz = new Question[10];




        // this loop generates the current questions from the poopl of questions
        for(int i = 0; i < 10; i++)
        {
            // number between 0 - 19
            int currentQuestion = rand.nextInt(20);

            // populate the array
            currentQuiz[i] = quizQuestions[currentQuestion];
        }

        Quiz theQuiz = new Quiz(currentQuiz, 10);

        return theQuiz;
    }
}
