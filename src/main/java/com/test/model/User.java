package com.test.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String openid;
	private String name;
	private String headImg;
	private String phone;
	private String sign;
  	private Integer sex;
  	private String city;
  	private java.util.Date createTime;
}

/*
JPA提供了四种主键生成策略(@GeneratedValue)：
	IDENTITY：使用数据库自增长字段来生成主键值；
	SEQUENCE：使用数据库序列来生成主键值；
	TABLE：使用表来存储主键值；
	AUTO：根据数据库类型和驱动自动选择一种主键生成策略。
*/