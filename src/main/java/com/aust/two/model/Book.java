package com.aust.two.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.lang.Override;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Version
    @Column(name = "version")
    private int version;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER) // 多对一的映射,@ManyToOne(fetch = FetchType.lazy)会报错
    private Author author;

}
