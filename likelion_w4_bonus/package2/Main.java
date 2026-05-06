package likelion_w4_bonus.package2;

import likelion_w4_bonus.role.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Role> members = new ArrayList<>();
    static Map<String, List<Role>> partMap = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1 등록 2 전체조회 3 검색 4 파트조회 5 삭제 6 정렬 7 통계 8 종료");
            int m = Integer.parseInt(sc.nextLine());

            if (m == 1) register();
            else if (m == 2) printAll();
            else if (m == 3) search();
            else if (m == 4) searchPart();
            else if (m == 5) delete();
            else if (m == 6) sort();
            else if (m == 7) stat();
            else break;
        }
    }

    static void register() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println("중복");
                return;
            }
        }

        System.out.print("기수: ");
        int g = Integer.parseInt(sc.nextLine());

        System.out.print("파트: ");
        String p = sc.nextLine();

        Role r = new Lion(name, "CS", g, p, "id");

        members.add(r);
        partMap.computeIfAbsent(p, k -> new ArrayList<>()).add(r);
    }

    static void delete() {
        System.out.print("삭제할 이름: ");
        String name = sc.nextLine();

        Role target = null;

        for (Role r : members) {
            if (r.getName().equals(name)) target = r;
        }

        if (target == null) return;

        members.remove(target);

        List<Role> list = partMap.get(target.getPart());
        if (list != null) {
            list.remove(target);
            if (list.isEmpty()) partMap.remove(target.getPart());
        }
    }

    static void sort() {
        members.sort(Comparator.comparingInt(Role::getGeneration));
        printAll();
    }

    static void stat() {
        for (String k : partMap.keySet()) {
            System.out.println(k + " : " + partMap.get(k).size());
        }
    }

    static void printAll() {
        for (Role r : members) System.out.println(r.getInfo());
    }

    static void search() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) System.out.println(r.getInfo());
        }
    }

    static void searchPart() {
        System.out.print("파트: ");
        String p = sc.nextLine();

        for (Role r : partMap.getOrDefault(p, new ArrayList<>())) {
            System.out.println(r.getInfo());
        }
    }
}