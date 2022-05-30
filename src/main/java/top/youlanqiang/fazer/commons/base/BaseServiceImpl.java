package top.youlanqiang.fazer.commons.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import top.youlanqiang.fazer.commons.domain.BaseDomain;


import javax.annotation.Resource;

/**
 * @author youlanqiang
 * created in 2022/3/27 00:28
 */
public class BaseServiceImpl<T extends BaseDomain, P extends JpaRepository<T, String>> implements BaseService<T>{


    @Autowired(required = false)
    private P repository;

    @Override
    public T saveOrUpdate(T t) {
        return repository.save(t);
    }

    @Override
    public boolean deleteById(String id) {
        try{
            repository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public T getById(String id) {
        return repository.getById(id);
    }

    @Override
    public Page<T> page(int pageNum, int pageSize) {
        return repository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public P repository() {
        return repository;
    }
}
