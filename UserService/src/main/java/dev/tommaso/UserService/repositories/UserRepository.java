package dev.tommaso.UserService.repositories;

import dev.tommaso.UserService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
