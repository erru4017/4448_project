package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MemberRepository extends MongoRepository<Member, String> {
}
