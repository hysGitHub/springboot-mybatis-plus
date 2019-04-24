package com.hys.ds;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

/**
 * @author ahys
 *
 */
@Data
@Accessors(chain = true)
public class KsLessee {

    /**
     * 租户id
     */
     static String lesseeId;


    public static void setLesseeId(String lesseeId){
        lesseeId = lesseeId;
    }

    public static String getLesseeId(){
        if(StringUtils.isEmpty(lesseeId)){
            throw new RuntimeException("lesseeId is null");
        }
        return lesseeId;
    }

}
