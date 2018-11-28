package oo_project.BeFit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * Create a repository to store all the sessions*/

@Repository
public interface SessionRepository extends MongoRepository<Session, String> { }
