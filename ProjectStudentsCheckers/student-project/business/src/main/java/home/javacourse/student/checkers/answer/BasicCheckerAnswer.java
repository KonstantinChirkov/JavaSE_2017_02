package home.javacourse.student.checkers.answer;

import home.javacourse.student.answer.CheckerAnswer;

/**
 * Created by Mozart on 20.03.2017.
 */
public class BasicCheckerAnswer implements CheckerAnswer
{
    private boolean result;
    private String message;

    public BasicCheckerAnswer(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    @Override
    public boolean getResult() {
        return true;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BasicCheckerAnswer{" +
                "result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
