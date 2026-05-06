package package1;

import java.util.Scanner;

public class step1 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("멤버 이름을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("전공을 입력해주세요.");
        String major = sc.nextLine();
        System.out.println("기수를 입력해주세요.");
        int gen = sc.nextInt();

        System.out.println("입력값 검증을 진행합니다.");
        
        if (name.isEmpty() || major.isEmpty() || gen < 1) {
            System.out.println("이름/전공이 비어 있거나 기수가 1 미만입니다.");
        } else {
            System.out.println("입력값 검증을 통과하여 멤버 객체 생성을 진행합니다.");
            member member = new member(name, major, gen);
            System.out.println("멤버 객체를 성공적으로 생성하였습니다.");
            member.printInfo();
        }
        sc.close();
    }
}