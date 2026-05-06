package likelion_w4.package1;

import likelion_w4.role.Lion;
import likelion_w4.role.Role;
import likelion_w4.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Role> members = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int menu = inputInt("선택: ");

            if (menu == 1) {
                registerMember();
            } else if (menu == 2) {
                printAllMembers();
            } else if (menu == 3) {
                searchByName();
            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n===== 멤버 관리 시스템 =====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 종료");
    }

    private static void registerMember() {
        System.out.println("\n-- 멤버 등록 --");
        int roleNumber = inputInt("역할 선택 (1: 아기사자, 2: 운영진): ");
        String name = inputText("이름: ");

        if (findMemberByName(name) != null) {
            System.out.println("등록 실패: 이미 존재하는 이름입니다.");
            return;
        }

        String major = inputText("전공: ");
        int generation = inputInt("기수: ");
        String part = inputText("파트 (백엔드/프론트엔드/기획/디자인): ");

        Role member;

        if (roleNumber == 1) {
            String studentId = inputText("학번: ");
            member = new Lion(name, major, generation, part, studentId);
        } else if (roleNumber == 2) {
            String position = inputText("직책: ");
            member = new Staff(name, major, generation, part, position);
        } else {
            System.out.println("등록 실패: 올바른 역할을 선택해주세요.");
            return;
        }

        members.add(member);
        System.out.println("등록 완료: " + member.getName());
    }

    private static void printAllMembers() {
        System.out.println("\n-- 전체 멤버 목록 --");

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            Role m = members.get(i);
            System.out.println((i + 1) + ". [" + m.getRoleName() + "] "
                    + m.getName() + " - " + m.getGeneration() + "기");
        }

        System.out.println("총 " + members.size() + "명");
    }

    private static void searchByName() {
        System.out.println("\n-- 이름으로 검색 --");
        String name = inputText("검색할 이름: ");
        Role m = findMemberByName(name);

        if (m == null) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        System.out.println("\n[검색 결과]");
        System.out.println(m.getInfo());
    }

    private static Role findMemberByName(String name) {
        for (Role m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    private static String inputText(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    private static int inputInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}