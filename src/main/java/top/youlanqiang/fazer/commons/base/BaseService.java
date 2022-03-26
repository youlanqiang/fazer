package top.youlanqiang.fazer.commons.base;

/**
 * @author youlanqiang
 * created in 2022/3/27 00:26
 */

import org.springframework.data.domain.Page;
import top.youlanqiang.fazer.commons.domain.BaseDomain;

public  interface  BaseService<T extends BaseDomain> {

    T saveOrUpdate(T t);


    boolean deleteById(String id);

    T getById(String id);

    Page<T> page(int pageNum, int pageSize);


}
