package geeapp.gee.repository;

import geeapp.gee.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
UserEntity findByEmail(String email);

}
