package likelion.likelion_bonus.role;

import likelion.likelion_bonus.policy.*;

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
        return getName() + " (" + getGeneration() + "기)";
    }
}