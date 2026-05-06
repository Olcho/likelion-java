package package1;

public class member {
    public String name;        // public: 외부에서 직접 수정 가능
    String major;              // default: 같은 패키지 내에서만 접근 가능
    private int generation;    // private: 클래스 내부에서만 접근 가능

    // 생성자
    public member(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public boolean isValid() {
        if (name == null || name.isEmpty()) {
            System.out.println("이름은 비어 있을 수 없습니다.");
            return false;
        }
        if (major == null || major.isEmpty()) {
            System.out.println("전공은 비어 있을 수 없습니다.");
            return false;
        }
        if (generation < 1) {
            System.out.println("기수는 1 미만일 수 없습니다.");
            return false;
        }
        return true;
    }

    // print
    public void printInfo() {
        System.out.println("이름: " + name + " , 전공: " + major + " , 기수: " + generation);
    }
    
    public void setMajor(String major) {
        if (major != null && !major.isEmpty()) {
            this.major = major;
            System.out.println("전공이 성공적으로 변경되었습니다.");
        }
    }
}