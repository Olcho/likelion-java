package week3.role;

import week3.policy.SubmitPolicy;
import week3.policy.StaffPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public SubmitPolicy getPolicy() {
        return new StaffPolicy();
    }

    public String getInfo() {
        return "Role: Staff\n"
                +"Name: "+getName()
                +"\nGeneration: "+getGeneration()
                +"\nPart: "+getPart()
                +"\nposition: "+position;
    }
}
