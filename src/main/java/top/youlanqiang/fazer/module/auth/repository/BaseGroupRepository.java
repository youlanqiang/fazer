package top.youlanqiang.fazer.module.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import top.youlanqiang.fazer.module.auth.domain.BaseRole;

@Repository
public interface BaseGroupRepository  extends JpaRepository<BaseRole, String>, JpaSpecificationExecutor<BaseRole> {

}
