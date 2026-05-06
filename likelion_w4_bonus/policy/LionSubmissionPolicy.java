package likelion_w4_bonus.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {
    private int generation;

    public LionSubmissionPolicy(int generation) {
        this.generation = generation;
    }

    @Override
    public boolean canSubmit() {
        return generation >= 14;
    }
}