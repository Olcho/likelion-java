package likelion_w4_bonus.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    private int generation;

    public StaffSubmissionPolicy(int generation) {
        this.generation = generation;
    }

    @Override
    public boolean canSubmit() {
        return generation >= 13;
    }
}