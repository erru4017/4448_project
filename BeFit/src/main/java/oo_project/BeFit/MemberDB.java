package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDB {
    private final MemberRepository repo;

    @Autowired
    public MemberDB(MemberRepository _repo){
        repo = _repo;
    }

    public long getCount(){
        return repo.count();
    }

    public void addMember(String _name, String _username){
        Member m = new Member(_name, _username);
        repo.save(m);
    }
    public Member retrieveMember(String _username){
        Optional<Member> result = repo.findById(_username);
        return result.orElse(null);

    }
    public void updateMember(Member m){
        repo.save(m);

    }





}
