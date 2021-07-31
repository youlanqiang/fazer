package top.youlanqiang.fazer.module.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.youlanqiang.fazer.common.domain.BaseDomain;

import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_group")
public class BaseGroup extends BaseDomain {


}
