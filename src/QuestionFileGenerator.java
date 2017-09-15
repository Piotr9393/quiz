/**
 * Created by User on 2017-08-17.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// zakładamy że pytania poprawne mogą być takimi elementami jak:YES,TAK,tak,yes,yup,DOBRZE,
//zakładamy że pytania niepoprawne mogą być  NO, NIE, no,nie ,nein, nope, NOPE, ŻLE ,zle



public class QuestionFileGenerator implements QuestionGenerator {

    private static  final List<String> YES_WORD = new ArrayList<>();
    private static final List<String> NO_WORD= new ArrayList<>();
    private static final double PI = 3.15;
   /* static {
        YES_WORD.add("YES");
        YES_WORD.add("TAK");
        YES_WORD.add("tak");
        YES_WORD.add("yes");
        YES_WORD.add("yup");
        YES_WORD.add("YUP");
        YES_WORD.add("si");
        YES_WORD.add("SI");
        YES_WORD.add("dobrze");
        YES_WORD.add("DOBRZE");

        NO_WORD.add("NO");
        NO_WORD.add("nie");
        NO_WORD.add("no");
        NO_WORD.add("NIE");
        NO_WORD.add("nein");
        NO_WORD.add("nope");
        NO_WORD.add("NOPE");
        NO_WORD.add("źle");
        NO_WORD.add("zle");
        NO_WORD.add("ŹLE");
    }*/// ZAMIAST TEGO MAMY WKLEJONE ENUMY NIŻEJ KTÓRE TO ZASTĘPUJĄ



    @Override
    public List<Question> generateQuestions() {
        String fileName = "questions.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toString)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(list);

        String[] splits = new String[2];

        List<Question>questions=new ArrayList<>();
        for(String line:list){
            splits=line.split("\\?");
            Question question=new Question(splits[0]+"?");
            String secondPart = splits[1].trim();

            question.setTrue(QuestionEnum.valueOf(secondPart).isCorrect());
            questions.add(question);
        }
        System.out.println(questions);

        return questions;
    }

    public static void main(String[] args) {
        QuestionFileGenerator questionFileGenerator = new QuestionFileGenerator();
        questionFileGenerator.generateQuestions();
    }
}