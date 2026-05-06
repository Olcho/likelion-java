package package1;

import java.util.Scanner;

public class step2 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("멤버 이름을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("전공을 입력해주세요.");
        String major = sc.nextLine();
        System.out.println("기수를 입력해주세요.");
        int gen = sc.nextInt();

        // 객체 생성 후 내부 상태 검증
        member member = new member(name, major, gen);
        System.out.println("객체 생성이 완료되었습니다. 멤버 객체의 상태를 확인합니다.");

        if (member.isValid()) {
            System.out.println("멤버 객체가 자신의 상태를 정상으로 판단했습니다.");
            member.printInfo();
        } else {
            System.out.println("잘못된 멤버 정보입니다.");
        }
        sc.close();
    }
}