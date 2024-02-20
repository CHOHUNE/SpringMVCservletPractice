package hello.servlert.domain.member;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@NoArgsConstructor()
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈가 우려되는 실무에서는 CocurrentHashMap, AtomicLong 등을 쓴다
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();
    // 싱글톤 객체로 만들 것이며 private 으로 생성자를 막아놓았다.

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {

        member.setId(++sequence);
        store.put(member.getId(),member);

        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    // 굳이 이렇게 새로 리스트에 담아서 return 하는 이유는 store의 불변성을 유지하기 위함이다.

    public void clearStore() {
        store.clear();
    }
    //테스트 코드 사용



}
