package collection.map.test;

import java.util.*;

public class MemberRepository {
    private Map<String, Member> memberMap = new HashMap<>();

    public void save(Member member){
        memberMap.put(member.getId(), member);
    }
    public void remove(String id){
        memberMap.remove(id);
    }

    public Member findById(String id){
        return memberMap.get(id);
    }

    public Member findByName(String name){
//        for (String key : memberMap.keySet()) {
//            Member dummy = memberMap.get(key);
//            if(dummy.getName() == name) return dummy;
//        }
//            return null;

        for (Member value : memberMap.values()) {
            if(value.getName().equals(name))
                return value;
        }
        return null;
    }

}
