package com.hys.es;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Province {


    @Field(type = FieldType.Keyword)
    private String enName;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer="ik_smart")
    private String chnName;

}
