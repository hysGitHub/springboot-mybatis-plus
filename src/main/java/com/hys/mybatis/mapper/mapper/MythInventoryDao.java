package com.hys.mybatis.mapper.mapper;

import com.hys.annotation.EsOperator;
import com.hys.annotation.EsOperatorEnum;
import com.hys.mybatis.mapper.entity.MythInventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ahys
 * @since 2019-02-16
 */
@Repository
public interface MythInventoryDao extends BaseMapper<MythInventory> {

    @Select("select * from myth_inventory where trans_id = #{id}")
    @EsOperator(type = EsOperatorEnum.DEL)
    public List<MythInventory> queryForSql(@Param("id")String id);
}
