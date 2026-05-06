package likelion_w4.role;

import likelion_w4.policy.LionSubmissionPolicy;
import likelion_w4.policy.SubmissionPolicy;

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
        return "역할: " + getRoleName()
                + "\n이름: " + getName()
                + "\n전공: " + getMajor()
                + "\n기수: " + getGeneration()
                + "\n파트: " + getPart()
                + "\n학번: " + studentId
                + "\n과제 제출 가능 여부: " + (getPolicy().canSubmit() ? "가능" : "불가능");
    }
}