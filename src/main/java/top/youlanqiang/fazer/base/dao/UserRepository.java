package top.youlanqiang.fazer.base.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.youlanqiang.fazer.base.domain.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
}
