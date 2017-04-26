/**
 * Copyright &copy; 2016-2020 <a href="http://strongunion.com.cn/">StrongUnion</a> All rights reserved.
 */
package cn.com.weiSsm.utils;

import java.lang.annotation.*;

/**
 * 硕正Express注解
 * @author WangZhen
 * @version 2013-11-12
 */
@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupExpress {
	
	/**
	 * 是否自动按列的引用关系优化计算顺序  默认值true
	 */
	String isOpt() default "";
	
	/**
	 * 文本
	 */
	String text() default "";

}
