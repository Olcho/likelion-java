package package1;

import java.util.List;
import role.Role;

public class MemberService {
    private MemberRepository repository = new MemberRepository();

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