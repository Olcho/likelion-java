package likelion_w4_bonus.package2;

import likelion_w4_bonus.role.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Role> members = new ArrayList<>();
    static Map<String, List<Role>> partMap = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 멤버 삭제");
            System.out.println("6. 기수 순 정렬 조회");
            System.out.println("7. 파트별 통계");
            System.out.println("8. 종료");

            int m = inputInt("선택: ");

            if (m == 1) register();
            else if (m == 2) printAll();
            else if (m == 3) search();
            else if (m == 4) searchPart();
            else if (m == 5) delete();
            else if (m == 6) msort();
            else if (m == 7) stat();
            else if (m == 8) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못된 입력");
            }
        }
    }

    static void register() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println("이미 존재하는 이름");
                return;
            }
        }

        System.out.print("기수: ");
        int g = inputInt("");

        System.out.print("파트: ");
        String p = sc.nextLine();

        Role r = new Lion(name, "CS", g, p, "id");

        members.add(r);
        partMap.computeIfAbsent(p, k -> new ArrayList<>()).add(r);

        System.out.println("등록 완료");
    }

    static void delete() {
        System.out.print("삭제할 이름: ");
        String name = sc.nextLine();

        Role dname;
        dname = null;

        for (Role r : members) {
            if (r.getName().equals(name)) {
                dname = r;
                break;
            }
        }

        if (dname == null) {
            return;
        }

        members.remove(dname);
        List<Role> list = partMap.get(dname.getPart());
        if (list != null) {
            list.remove(dname);
            if (list.isEmpty()) {
                partMap.remove(dname.getPart());
            }
        }

        System.out.println("삭제돰");
    }

    static void msort() {
        System.out.println("\n-- 정렬 --");

        List<Role> sorted = new ArrayList<>(members);
        sorted.sort(Comparator.comparingInt(Role::getGeneration));

        for (Role r : sorted) {
            System.out.println(r.getInfo());
        }
    }

    static void stat() {
        System.out.println("\n-- 통계 --");

        for (String k : partMap.keySet()) {
            System.out.println(k + " : " + partMap.get(k).size());
        }

        System.out.println("총 인원: " + members.size());
    }

    static void printAll() {
        System.out.println("\n-- 멤버리스트 --");

        if (members.isEmpty()) {
            System.out.println("없음");
            return;
        }

        for (Role m : members) {System.out.println(m.getInfo());}

    static void search() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println(r.getInfo());
                return;
            }
        }

        System.out.println("검색 결과 없음");
    }

    static void searchPart() {
        System.out.print("파트: ");
        String p = sc.nextLine();

        List<Role> list = partMap.get(p);

        if (list == null || list.isEmpty()) {
            System.out.println("해당 파트 없음");
            return;
        }

        for (Role m : list) {
            System.out.println(m.getInfo());
        }
    }

    static int inputInt(String msg) {
        while (true) {
            try {
                if (!msg.isEmpty()) System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("숫자 입력");
            }
        }
    }
}