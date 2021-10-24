package top.youlanqiang.fazer.module.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.youlanqiang.fazer.module.auth.domain.BaseGroup;

@Repository
public interface BaseGroupRepository  extends JpaRepository<BaseGroup, String> {

}
