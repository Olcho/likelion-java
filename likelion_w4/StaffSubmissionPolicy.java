package likelion_w4.policy;

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