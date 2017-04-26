/**
 * Copyright &copy; 2016-2020 <a href="http://strongunion.com.cn/">StrongUnion</a> All rights reserved.
 */
package cn.com.weiSsm.base;


import cn.com.weiSsm.model.User;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service基类
 *
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class BaseService {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 数据范围过滤
	 * @param user 当前用户对象，通过“entity.getCurrentUser()”获取
	 * @param officeAlias 机构表别名，多个用“,”逗号隔开。
	 * @param userAlias 用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
	 * @return 标准连接条件对象
	 */
	public static String dataScopeFilter(User user, String officeAlias, String userAlias) {

		StringBuilder sqlString = new StringBuilder();
		
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		
		// 超级管理员，跳过权限过滤
		return "";
	}

	/**
	 * 数据范围过滤（符合业务表字段不同的时候使用，采用exists方法）
	 * @param entity 当前过滤的实体类
	 * @param sqlMapKey sqlMap的键值，例如设置“dsf”时，调用方法：${sqlMap.sdf}
	 * @param officeWheres office表条件，组成：部门表字段=业务表的部门字段
	 * @param userWheres user表条件，组成：用户表字段=业务表的用户字段
	 * @example
	 * 		dataScopeFilter(user, "dsf", "id=a.office_id", "id=a.create_by");
	 * 		dataScopeFilter(entity, "dsf", "code=a.jgdm", "no=a.cjr"); // 适应于业务表关联不同字段时使用，如果关联的不是机构id是code。
	 */
	public static void dataScopeFilter(BaseEntity<?> entity, String sqlMapKey, String officeWheres, String userWheres) {

		User user = entity.getCurrentUser();
	}
		
		// 如果是超级管理员，则不过滤数据
}
