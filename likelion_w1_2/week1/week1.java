package week1;
import java.util.Scanner;

public class week1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int count = 0;
            
            // 1. 멤버 입력
            while (true) { // 1불가능 
                System.out.println("멤버 수를 5 이상 입력하세요 : ");
                String input = sc.nextLine();
                try {
                    count = Integer.parseInt(input);
                    if (count < 5) {
                        System.out.println("5 이상 입력하세요 : ");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력 가능합니다");
                }
            }

            // 2. 이름 입력
            String[] members = new String[count];
            System.out.println("멤버 이름을 입력하세요 : ");
            
            for (int i = 0; i < count; i++) {
                String name = sc.nextLine();

                if (name.trim().isEmpty()) {
                    System.out.println("이름 없음. 다시 입력하세요 ");
                    i--;
                    continue;
                }

                boolean isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (name.equals(members[j])) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("중복된 이름, 다시 입력하세요.");
                    i--;
                    continue;
                }

                members[i] = name;
            }

            // 3. print
            System.out.println("멤버 출력");

            for (int i = 0; i < members.length; i++) {
                System.out.println((i + 1) + ". " + members[i]);
            }

            // 4. 종료
            System.out.println("\n======================");
            System.out.println("프로그램을 종료하려면 exit");
            System.out.println("계속 멤버를 등록하려면 restart");
            
            while (true) {
                String command = sc.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("멤버 명단 관리 프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else if (command.equalsIgnoreCase("restart")) {
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                }
            }
        }
    }
}