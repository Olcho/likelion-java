package package2; // 다른 패키지

import package1.member;

public class Step3 {
    public static void main(String[] args) {
        member member = new member("김하나", "컴퓨터공학과", 14);
        
        System.out.println("Step 3-1. public 필드 접근 시도");
        member.name = "김둘"; // 성공: public
        System.out.println("public 필드 접근 성공");
        member.printInfo();
    }

        //member.major = "소프트웨어학과";   오류1
        //member.generation = 15;   오류2

}