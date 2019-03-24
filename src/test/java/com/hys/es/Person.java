package com.hys.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分词
 * https://segmentfault.com/a/1190000011065897
 */
@Document(indexName = "com.hys.index",type = "person",createIndex = false)
@Data
@Accessors(chain = true)
public class Person {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String idCard;


    @Field(type = FieldType.Text)
    private String enName;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer="ik_smart")
    private String chnName;

    @MultiField(otherFields = {
            @InnerField(suffix = "std_", type = FieldType.Text,searchAnalyzer = "standard",analyzer = "standard")
    },mainField =@Field(type = FieldType.Keyword))
    private String sex;

    @Field(type = FieldType.Date,index = false)
    private Date birthDay;


    @Field(type = FieldType.Nested)
    private Province province;


    @Field(type = FieldType.Nested)
    private List<Tag> tags;

}
