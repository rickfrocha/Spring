package com.example.testeDB;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

/**
 * Created by ricardo on 27/09/17.
 */
@Table
@Entity
@RevisionEntity
public class EnversEntity {

    @Id
    @Column(name = "ID_REVISION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @RevisionNumber
    private Long id;

    @RevisionTimestamp
    @Column(name = "COD_TIMESTAMP")
    private Long timeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
