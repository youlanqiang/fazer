package top.youlanqiang.fazer.common.domain.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import top.youlanqiang.fazer.common.domain.Snowflake;

import java.io.Serializable;

/**
 * @author youlanqiang
 * created in 2021/2/24 11:30
 */
public class SnowflakeIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor,
                                 Object o) throws HibernateException {
        return Long.toString(Snowflake.nextId());
    }
}
