package week5.policy;

public class StudentLionPolicy implements Policy {
    @Override
    public boolean isPolicyAllowed(int generation) {
        return generation >=14;
    }
}