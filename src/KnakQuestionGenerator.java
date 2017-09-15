import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bartłomiej on 17.08.2017.
 */
public class KnakQuestionGenerator implements QuestionGenerator{


    private int numberOfQuestions;

    private static List<Question> questions = new
            ArrayList<>();

    private static String question;
    private static String anserwLine;
    private static String line;
    private static boolean answerw;
    static{

        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            try {

                Scanner scaner = new Scanner(file);
                while(scaner.hasNextLine()) {
                    line = scaner.nextLine();
                    if (line.contains("TAK")) {
                        question = line.replace(" TAK", "");
                        answerw = true;
                        questions.add(new Question(question,answerw));

                    }
                    if (line.contains("NIE")) {
                        question = line.replace(" NIE", "");
                        answerw = false;
                        questions.add(new Question(question,answerw));
                    }





                }

            } catch (FileNotFoundException e1) {

                e1.printStackTrace();
            }
        }

    }

    public  KnakQuestionGenerator(){
        this.numberOfQuestions = questions.size();
    }


    public KnakQuestionGenerator(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    public List<Question> generateQuestions(){
        return questions.subList(0,numberOfQuestions);
    }



}