package top.youlanqiang.fazer.module.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import top.youlanqiang.fazer.module.auth.domain.BaseUser;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, String>, JpaSpecificationExecutor<BaseUser> {


    /**
     * 使用jpql来查询
     */
//    @Query("from BaseUser where username = ?1")
//    BaseUser findJpql(String username);

    /**
     * 根据名称查询
     */
    BaseUser findByUsername(String username);

}
