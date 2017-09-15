import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by michalos on 17.08.2017.
 */
public class QuestionRandomGenerator extends SimpleQuestionGenerator {


    public QuestionRandomGenerator() {
        setNumberOfQuestions(3);
    }

    // przesłonięcie
    @Override
    public List<Question> generateQuestions() {
        List<Question> questions = SimpleQuestionGenerator.getQuestions();
        Set<Question> setQuestions = new HashSet<>();

        Random random = new Random();
        int counter = 0;

        while (counter != getNumberOfQuestions()) {
            int number = random.nextInt(questions.size());
            System.out.println("Number "+number);
            if (!setQuestions.contains(questions.get(number))) {
                setQuestions.add(questions.get(number));
                counter++;
            }

        }

        return setQuestions.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        QuestionRandomGenerator questionRandomGenerator = new QuestionRandomGenerator();
        System.out.println(questionRandomGenerator.generateQuestions());
    }
}