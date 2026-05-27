package likelion_w6.config;

import likelion_w6.repository.MemberRepository;
import likelion_w6.repository.MemoryMemberRepository;
import likelion_w6.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}