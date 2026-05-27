package likelion_w6;

import likelion_w6.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LikelionW6Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LikelionW6Application.class, args);

        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
    }
}