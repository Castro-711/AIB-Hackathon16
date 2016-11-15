package aib.hackathon.johneric.sustainablesmarts;

/**
 * Created by castro on 11/11/16.
 * This class will represent a question.
 */

public class Question
{
    private String question;    // the contents of the current question
    private Answer[] answers;   // an array of answers to provide multiple choice

    public Question(String question, Answer[] answers)
    {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Answer[] getAnswers()
    {
        return answers;
    }

    public void setAnswers(Answer[] answers)
    {
        this.answers = answers;
    }

}
