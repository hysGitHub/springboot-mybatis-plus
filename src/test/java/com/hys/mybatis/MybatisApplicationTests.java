package com.hys.mybatis;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.support.Property;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hys.mybatis.mapper.entity.MythInventory;
import com.hys.mybatis.mapper.mapper.MythInventoryDao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	MythInventoryDao mythInventoryDao;

	//查询
	@Test
	public void select() {
		//        List<User> lambdaUsers = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getRoleId, 2L));

		MythInventory mythInventory = mythInventoryDao.selectOne(new QueryWrapper <MythInventory>().lambda().eq(MythInventory::getTransId, "1"));//mythInventoryDao.selectById("1");
		System.out.println(mythInventory);
	}


	//插入
	@Test
	public void inset() {
		MythInventory mythInventory = new MythInventory();
		mythInventory.setErrorMsg("1111");
		mythInventory.setTargetClass("class2");
		mythInventory.setStatus(1);
		mythInventory.setTransId("2");
		mythInventory.setRetriedCount(1);
		mythInventory.setCreateTime(new Date());
		mythInventory.setLastTime(new Date());
		mythInventory.setRole(1);
		mythInventory.setVersion(1);
		mythInventoryDao.insert(mythInventory);

	}



	//更新

	@Test
	public void update(){
		/*MythInventory mythInventory = mythInventoryDao.selectOne(new QueryWrapper <MythInventory>().lambda().eq(MythInventory::getTransId, "1"));//mythInventoryDao.selectById("1");
		System.out.println(mythInventory);
		mythInventory.setTargetClass("更新class");
		mythInventoryDao.updateById(mythInventory);*/

		MythInventory mythInventory2 =new MythInventory();
		UpdateWrapper<MythInventory> wrapper = new UpdateWrapper <>();
		wrapper.lambda().eq(MythInventory::getTransId,"23");
		mythInventory2.setErrorMsg("错误哦信息");
		mythInventoryDao.update(mythInventory2,wrapper);
	}



	@Test
	public void wapperSelect(){

		//sql 语法
		List <MythInventory> mythInventories = mythInventoryDao.selectList(new QueryWrapper <MythInventory>().lambda().inSql(MythInventory::getTransId, "select 1 from dual"));
		System.out.println("sql: "+mythInventories.size());


	}

	//分页
	@Test
	public void page(){

		Page<MythInventory> page = new Page<>(1, 2);
		QueryWrapper<MythInventory> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().orderByDesc(MythInventory::getCreateTime).orderByAsc(MythInventory::getVersion);

		IPage<MythInventory> pageList = mythInventoryDao.selectPage(page, queryWrapper);
		print(pageList.getRecords());
	}

	@Test
	public void selectBySql(){
		List <MythInventory> mythInventories = mythInventoryDao.queryForSql("2");
		print(mythInventories);
	}

	private <T> void print(List<T> list) {
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(System.out::println);
		}
	}

}

