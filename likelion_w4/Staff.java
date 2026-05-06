package likelion_w4;

package likelion_w4.role;

import likelion_w4.policy.StaffSubmissionPolicy;
import likelion_w4.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    public SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy(getGeneration());
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getInfo() {
        return "역할: " + getRoleName()
                + "\n이름: " + getName()
                + "\n전공: " + getMajor()
                + "\n기수: " + getGeneration()
                + "\n파트: " + getPart()
                + "\n직책: " + position
                + "\n과제 제출 가능 여부: " + (getPolicy().canSubmit() ? "가능" : "불가능");
    }
}