package com.taylor.spb.entity;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "user")
public class UserEntity {
	private Integer id;
	private String name;

}
