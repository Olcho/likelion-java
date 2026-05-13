package package2;

import java.util.List;
import java.util.Scanner;

import role.Lion;
import role.Role;
import role.Staff;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");

        int choice = sc.nextInt();

        MemberRepository repository;

        if (choice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {
            System.out.println();
            System.out.println("🔥 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🔥");
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
                    System.out.println("❌ 등록 실패: 중복 이름");
                }

            } else if (menu == 2) {
                List<Role> members = service.getAllMembers();

                for (Role m : members) {
                    System.out.println("------------------");
                    m.printInfo();
                }

            } else if (menu == 3) {
                System.out.print("검색 이름: ");
                String name = sc.next();

                Role m = service.searchByName(name);

                if (m == null) {
                    System.out.println("❌ 없음");
                } else {
                    m.printInfo();
                }

            } else if (menu == 4) {
                break;
            }
        }

        sc.close();
    }

    public static Role inputMember(Scanner sc) {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int role = sc.nextInt();

        System.out.print("이름: ");
        String name = sc.next();

        System.out.print("전공: ");
        String major = sc.next();

        System.out.print("기수: ");
        int gen = sc.nextInt();

        System.out.print("파트: ");
        String part = sc.next();

        if (role == 1) {
            System.out.print("학번: ");
            String id = sc.next();
            return new Lion(name, major, gen, part, id);
        } else {
            System.out.print("직책: ");
            String pos = sc.next();
            return new Staff(name, major, gen, part, pos);
        }
    }
}