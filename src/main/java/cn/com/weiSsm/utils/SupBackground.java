/**
 * Copyright &copy; 2016-2020 <a href="http://strongunion.com.cn/">StrongUnion</a> All rights reserved.
 */
package cn.com.weiSsm.utils;

import java.lang.annotation.*;

/**
 * 硕正Background注解
 * @author WangZhen
 * @version 2013-11-12
 */
@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupBackground {
	
	/**
	 * 背景颜色
	 * @return
	 */
	String bgColor() default "";

}