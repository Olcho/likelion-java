package likelion.likelion_bonus.role;

<<<<<<< HEAD:likelion/likelion_bonus/role/Role.java
import likelion.likelion_bonus.policy.SubmissionPolicy;
=======
import likelion_w4.policy.SubmissionPolicy;
>>>>>>> 80a3145b3d5281ef93a376e292f06a2063b4d087:likelion_w4/Role.java

public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Role(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract SubmissionPolicy getPolicy();
    public abstract String getRoleName();
    public abstract String getInfo();
}