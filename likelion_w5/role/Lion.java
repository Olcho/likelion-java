package role;

import policy.LionSubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
        this.submissionPolicy = new LionSubmissionPolicy(generation);
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void printInfo() {
        System.out.println("🦁 역할: 아기사자");
        System.out.println("이름: " + name);
        System.out.println("전공: " + major);
        System.out.println("기수: " + generation);
        System.out.println("파트: " + part);
        System.out.println("학번: " + studentId);
        System.out.println("과제 제출 가능: " + (canSubmit() ? "✅ 가능" : "❌ 불가능"));
    }
}