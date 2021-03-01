package top.youlanqiang.fazer.common.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BaseDomain implements Serializable {

    @Id
    @Column(name="uid")
    @GeneratedValue(generator = "idGenerator",strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name="idGenerator",
            strategy="top.youlanqiang.fazer.config.SnowflakeIdentifierGenerator"
    )
    private String uid;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Column(name = "create_time")
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy;

    @Column(name = "update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;




}
