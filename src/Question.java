/**
 * Created by User on 2017-08-16.
 */
public class Question {

    private String text;

    private boolean isTrue;

    public Question(String text) {
        this.text = text;
    }

    public Question(String text, boolean isTrue) {
        this.text = text;
        this.isTrue = isTrue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public String toString(){

        return getText()+" "+isTrue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (isTrue != question.isTrue) return false;
        return text.equals(question.text);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + (isTrue ? 1 : 0);
        return result;
    }
}
