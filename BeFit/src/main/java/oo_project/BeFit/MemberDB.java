package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addMember(String _name){
        long _id = getCount()+1;
        Member m = new Member(_name, _id);
        repo.save(m);
    }





}
