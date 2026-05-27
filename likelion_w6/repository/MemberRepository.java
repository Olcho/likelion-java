package likelion_w6.repository;

import likelion_w6.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);
}