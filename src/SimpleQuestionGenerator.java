import java.util.ArrayList;
import java.util.List;


public class SimpleQuestionGenerator implements QuestionGenerator {
    private int numberOfQuestions;

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    private static List<Question> questions = new
            ArrayList<>();

    public static List<Question> getQuestions() {
        return questions;
    }

    static{
        questions.add(new Question("Czy a to a?",true));

        questions.add(new Question("2+5=8?",false));

        questions.add(new Question("Czy cat to pies?",false));

        questions.add(new Question("Czy 2 do poęgi 10 to 1024?",true));

        questions.add(new Question("2+9=12?",false));

        questions.add(new Question("1Czy a to a?",true));

        questions.add(new Question("12+5=8?",false));

        questions.add(new Question("1Czy cat to pies?",false));

        questions.add(new Question("1Czy 2 do poęgi 10 to 1024?",true));

        questions.add(new Question("22+9=12?",false));
    }

    public  SimpleQuestionGenerator(){
        this.numberOfQuestions = questions.size();
    }


    public SimpleQuestionGenerator(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    public List<Question> generateQuestions(){
        return questions.subList(0,numberOfQuestions);
    }
}


