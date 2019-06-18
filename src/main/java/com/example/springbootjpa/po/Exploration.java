package com.example.springbootjpa.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 15:33 2019/5/15
 */

@Entity
@Table(name = "exploration",schema="house")
@Data
@ToString
public class Exploration {
    @Id
    private String id;

    @Column(name = "deleted")
    private Boolean deleted;

  @Column(name = "uts_created")
    private String utsCreated;

    @Column(name = "uts_updated")
    private String utsUpdated;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "staff_id")
    private String staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "property_id")
    private String propertyId;

    @Column(name = "photo_count")
    private Integer photoCount;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)

    private Date createDate;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "active")
    private Boolean active;
}