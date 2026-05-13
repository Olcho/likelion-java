<<<<<<< HEAD:likelion/likelion_bonus/policy/StaffSubmissionPolicy.java
package likelion.likelion_bonus.policy;
=======
package likelion_w4;
>>>>>>> 80a3145b3d5281ef93a376e292f06a2063b4d087:likelion_w4/StaffSubmissionPolicy.java

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