package com.hys.es;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ahys
 */
@Data
@Accessors(chain = true)
public class Tag {

    @Field(index = false)
    private Long id;

    @Field(type = FieldType.Text,searchAnalyzer = "standard",analyzer = "standard")
    private String path;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer="ik_smart")
    private String tagName;
}
