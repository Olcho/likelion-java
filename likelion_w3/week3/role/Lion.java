package week3.role;

import week3.policy.SubmitPolicy;
import week3.policy.LionPolicy;

public class Lion extends Role{
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public SubmitPolicy getPolicy() {
        return new LionPolicy();
    }

    public String getInfo() {
        return "Role: Likelion\n"
                +"Name: "+getName()
                +"\nGeneration: "+getGeneration()
                +"\nPart: "+getPart()
                +"\nStudentId: "+studentId;
    }
}