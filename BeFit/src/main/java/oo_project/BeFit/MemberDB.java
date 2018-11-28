package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * MemberDB class contains methods regarding members
 * */
@Service
public class MemberDB {
    /**
     * This database contains all members.
     */
    private final MemberRepository repo;
    /**
     * Set the repository.
     */

    @Autowired
    public MemberDB(MemberRepository _repo){
        repo = _repo;
    }

    /**
     * Add a member to the database.
     * @param _name The name of the member
     * @param _username A unique username to be used as their ID
     */
    public void addMember(String _name, String _username){
        Member m = new Member(_name, _username);
        repo.save(m);
    }
    /**
     * Retrieve a member to the database.
     * @param _username The username of the member
     * @return the member with that username
     */

    public Member retrieveMember(String _username){
        Optional<Member> result = repo.findById(_username);
        return result.orElse(null);
    }
    /**
     *Update a member to the database.
     * @param m The object of the member to update
     */

    public void updateMember(Member m){
        repo.save(m);
    }
    /**
     *Update a member to the database.
     * @param _username username of a member to check
     * @return true if a member with that username exists already
     */

    public boolean exists(String _username){
        return repo.existsById(_username);
    }





}
