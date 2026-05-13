package package1;

import java.util.List;
import java.util.Scanner;

import role.Lion;
import role.Role;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberService service = new MemberService();

        while (true) {
            System.out.println();
            System.out.println("🦁 ===== 멋사 멤버 관리 시스템 (Step 1: 직접 생성) ===== 🦁");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();

            if (menu == 1) {
                Role member = inputMember(sc);
                boolean result = service.register(member);

                if (result) {
                    System.out.println("✅ 등록 완료: " + member.getName());
                } else {
                    System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                }

            } else if (menu == 2) {
                List<Role> members = service.getAllMembers();

                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                } else {
                    for (Role member : members) {
                        System.out.println("--------------------");
                        member.printInfo();
                    }
                }

            } else if (menu == 3) {
                System.out.print("검색할 이름: ");
                String name = sc.next();

                Role member = service.searchByName(name);

                if (member == null) {
                    System.out.println("❌ 해당 이름의 멤버가 없습니다.");
                } else {
                    System.out.println("🔍 ===== 검색 결과 =====");
                    member.printInfo();
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        sc.close();
    }

    public static Role inputMember(Scanner sc) {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int role = sc.nextInt();

        System.out.println();
        System.out.println("📝 정보 입력");

        System.out.print("이름: ");
        String name = sc.next();

        System.out.print("전공: ");
        String major = sc.next();

        System.out.print("기수: ");
        int generation = sc.nextInt();

        System.out.print("파트: ");
        String part = sc.next();

        if (role == 1) {
            System.out.print("학번: ");
            String studentId = sc.next();

            return new Lion(name, major, generation, part, studentId);
        } else {
            System.out.print("직책: ");
            String position = sc.next();

            return new Staff(name, major, generation, part, position);
        }
    }
}