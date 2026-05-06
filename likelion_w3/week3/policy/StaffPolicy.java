package week3.policy;

public class StaffPolicy implements SubmitPolicy{
    public boolean canSubmit() {
        return false;
    }
}
