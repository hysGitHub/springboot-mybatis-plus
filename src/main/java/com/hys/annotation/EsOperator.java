package com.hys.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * es 存储操作注解
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
//方法上
@Target(value = ElementType.METHOD)
@Inherited
public @interface EsOperator {

    /**
     * es 的操作类型
     * @return
     */
    public EsOperatorEnum type() default EsOperatorEnum.SAVE;
}
