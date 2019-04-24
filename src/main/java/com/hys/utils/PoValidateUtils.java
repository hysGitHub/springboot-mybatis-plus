package com.hys.utils;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author ahys
 * 对象验证工具类 对hibernate注解生效
 *
 */
public class PoValidateUtils {


    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();


    /**
     * 验证对象合法性,不符合有异常抛出
     * @param data 数据
     * @param <T>
     */
    public static <T> void fastValidate(T data){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(data);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            ConstraintViolation<T> firstViolation = constraintViolations.iterator().next();
            throw new RuntimeException(getValidateMsg(firstViolation).toString());
        }
    }

    /**
     * 获取验证信息
     * @param violation
     * @param <T>
     * @return
     */
    private static <T> StringBuffer getValidateMsg(ConstraintViolation<T> violation){
        return new StringBuffer(violation.getPropertyPath()+","+violation.getMessage()+".");
    }

    /**
     * 验证合法性，并返回验证信息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServiceResponse fastValidateResponse(T data){
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(data);
        if (constraintViolations.size() > 0) {
            StringBuilder res = new StringBuilder();
            constraintViolations.stream().forEach(v->{
                res.append(getValidateMsg(v));
            });
            return ServiceResponse.warn(null,res.toString());
        }
        return ServiceResponse.ok(null,"验证通过.");
    }


}
