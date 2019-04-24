package com.hys.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ahys
 * service 层封装
 */
@Data
@Accessors(chain = true)
public class ServiceResponse<T> implements Serializable {


    private Status status;

    private String meg;

    private T data;

    public static <T> ServiceResponse<T> del(T data){
        return createServiceResponse( data,null, Status.del);
    }

    public static <T> ServiceResponse<T> del(T data,String meg){
        return createServiceResponse( data,meg, Status.del);
    }

    public static <T> ServiceResponse<T> ok(T data){
        return createServiceResponse( data,null, Status.ok);
    }

    public static <T> ServiceResponse<T> ok(T data,String meg){
        return createServiceResponse( data,meg, Status.ok);
    }

    public static <T> ServiceResponse<T> exist(T data){
        return createServiceResponse( data,null, Status.exist);
    }

    public static <T> ServiceResponse<T> exist(T data,String meg){
        return createServiceResponse( data,meg, Status.exist);
    }

    public static <T> ServiceResponse<T> warn(T data){
        return createServiceResponse( data,null, Status.warn);
    }

    public static <T> ServiceResponse<T> warn(T data,String meg){
        return createServiceResponse( data,meg, Status.warn);
    }

    public static <T> ServiceResponse<T> createServiceResponse(T data,String meg,Status status) {
        ServiceResponse response = new ServiceResponse();
        response.setData(data).setMeg(meg).setStatus(status);
        return response;
    }


    public static enum Status{
        exist(),del(),ok(),warn(),err();
    }
}
