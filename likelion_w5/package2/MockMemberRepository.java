package package2;

import java.util.ArrayList;
import java.util.List;
import role.Role;
import role.Lion;

public class MockMemberRepository implements MemberRepository {

    private List<Role> dummy = new ArrayList<>();

    public MockMemberRepository() {
        dummy.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "202020202"));
        dummy.add(new Lion("이사자", "소프트웨어학과", 13, "프론트엔드", "202020203"));
    }

    @Override
    public boolean save(Role member) {
        return true; // 저장 안함 (Mock)
    }

    @Override
    public List<Role> findAll() {
        return dummy;
    }

    @Override
    public Role findByName(String name) {
        for (Role member : dummy) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }
}