package aib.hackathon.johneric.sustainablesmarts;

/**
 * Created by castro on 11/11/16.
 * This is a class to represent tone answer for a given question.
 */

public class Answer
{
    private String answer;      // contains one possible answer
    private boolean isRight;    // contains a boolean flagging if it is correct

    public Answer(String answer, boolean isRight)
    {
        // set the contents of the variables
        this.answer = answer;
        this.isRight = isRight;
    }

    // ------ GETTERS AND SETTERS ------ //

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setIsRight(boolean isRight)
    {
        this.isRight = isRight;
    }

    public boolean getIsRight()
    {
        return isRight;
    }
}
