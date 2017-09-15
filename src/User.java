/**
 * Created by User on 2017-08-16.
 */
public class User {
    private int numberOfPoints;

    public int getNumberOfPoints() {
        return numberOfPoints;
    }
    public User() {
    }

    public User(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }
    public void addPoint(){
        numberOfPoints++;
    }
}
