package top.youlanqiang.fazer.common.base;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity
@Where(clause = "")
public class BaseDomain implements Serializable {

    @Id
    private String uid;

    @CreatedDate
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime deleteTime;

    private boolean isDelete;

}
