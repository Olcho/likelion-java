package likelion.likelion_bonus.role;

import likelion.likelion_bonus.policy.*;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy(getGeneration());
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getInfo() {
        return getName() + " (" + getGeneration() + "기)";
    }
}