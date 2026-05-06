package week3;

import week3.role.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("likelion information\n");

        System.out.print("Name: ");
        String lionname = sc.next();
        System.out.print("Major: ");
        String lionmajor = sc.next();
        System.out.print("Gen: ");
        int liongen = sc.nextInt();
        System.out.print("Part: ");
        String lionpart = sc.next();
        System.out.print("StudenId: ");
        String studentId = sc.next();
        
        Role lion = new Lion(lionname, lionmajor, liongen, lionpart, studentId);

        System.out.print("\nStaff Info \n");

        System.out.print("Name: ");
        String staffname = sc.next();
        System.out.print("Major: ");
        String staffmajor = sc.next();
        System.out.print("Gen: ");
        int staffgen = sc.nextInt();
        System.out.print("Part: ");
        String staffpart = sc.next();
        System.out.print("Position: ");
        String position = sc.next();

        Role staff = new Staff(staffname, staffmajor, staffgen, staffpart, position);

        System.out.println("\n\n");
        printResult(lion);
        printResult(staff);

        sc.close();
    }
    static void printResult(Role role) {
        System.out.println(role.getInfo());
        
        boolean result = role.getPolicy().canSubmit();

        System.out.println("Assignment: "+ (result ? "Possible": "Impossible"));
        System.out.println();
    }
}
