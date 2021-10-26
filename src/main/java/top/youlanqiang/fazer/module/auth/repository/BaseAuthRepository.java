package top.youlanqiang.fazer.module.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.youlanqiang.fazer.module.auth.domain.BaseAuth;

@Repository
public interface BaseAuthRepository extends JpaRepository<BaseAuth, String>, JpaSpecificationExecutor<BaseAuth> {
}
