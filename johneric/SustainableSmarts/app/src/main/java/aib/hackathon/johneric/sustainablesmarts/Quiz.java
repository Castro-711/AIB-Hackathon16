package aib.hackathon.johneric.sustainablesmarts;

import java.util.ArrayList;

/**
 * Created by castro on 11/11/16.
 * This class will represent the quiz.
 */

public class Quiz
{
    private Question[] questions;
    private int quizScore;
    private int numQuestions;

    public Quiz(Question[] questions, int numQuestions)
    {
        this.questions = questions;
        this.numQuestions = numQuestions;
    }

    public Question[] getQuestions()
    {
        return questions;
    }

    public ArrayList<Question> getQuestionsAsList()
    {
        ArrayList<Question> questionsList = new ArrayList<Question>();
        for(int i = 0; i < questions.length; i++)
            questionsList.set(i, questions[i]);

        return questionsList;
    }

    public int getQuizScore()
    {
        return quizScore;
    }

    public void setQuizScore(int score)
    {
        this.quizScore = score;
    }
    public void setQuestions(Question[] questions)
    {
        this.questions = questions;
    }

}
