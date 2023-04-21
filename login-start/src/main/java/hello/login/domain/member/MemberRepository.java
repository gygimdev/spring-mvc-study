package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //회원 저장
    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    //회원 조회
    public Member findById(Long id){
        return store.get(id);
    }

    //전체회원 조회
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //로그인 아이디로 회원 조회
    public Optional<Member> findByLoginId(String loginId){
//        List<Member> all = findAll();
//        for(Member m : all){
//            if(m.getName().equals(loginId)){
//                return Optional.of(m);
//            }
//        }
//        return Optional.empty();

        return findAll().stream() //스트림 루프 같은것
                .filter(m -> m.getLoginId().equals(loginId)) //조건에 만족하는 애를 찾음
                .findFirst(); //먼저 나오는애만 반환, 뒤에 무시
    }

    //테스트용
    public void clearStore(){
        store.clear();
    }

}
