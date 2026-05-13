package package2;

import java.util.List;
import role.Role;

public class MemberService {

    private final MemberRepository repository;

    // 생성자 주입
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role member) {
        return repository.save(member);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }
}