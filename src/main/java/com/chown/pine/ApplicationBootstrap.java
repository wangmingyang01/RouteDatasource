/**
 * 文 件 名:  ApplicationBootstrap
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2019/3/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.chown.pine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 动态切换数据源
 */
@SpringBootApplication
public class ApplicationBootstrap
{
	public static void main (String[] args)
	{
		SpringApplication.run (ApplicationBootstrap.class, args);
	}
}
