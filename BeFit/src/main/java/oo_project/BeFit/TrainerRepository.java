package oo_project.BeFit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
/**
 * Create a repository to store all the trainers*/


@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {

}
