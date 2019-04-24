package com.hys.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.Date;

@Mapping(mappingPath = "/config/symentry-mapping-json")
public class EsMpEntity {

    @Id
    private String id;

    @Field()
    private Date date;
}
