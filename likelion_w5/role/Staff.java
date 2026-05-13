package role;

import policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
        this.submissionPolicy = new StaffSubmissionPolicy();
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void printInfo() {
        System.out.println("🧑‍💻 역할: 운영진");
        System.out.println("이름: " + name);
        System.out.println("전공: " + major);
        System.out.println("기수: " + generation);
        System.out.println("파트: " + part);
        System.out.println("직책: " + position);
        System.out.println("과제 제출 가능: " + (canSubmit() ? "✅ 가능" : "❌ 불가능"));
    }
}