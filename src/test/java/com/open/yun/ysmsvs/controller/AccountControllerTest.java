package com.open.yun.ysmsvs.controller;

import org.junit.Test;

import com.open.yun.ysmsvs.dto.AccountInput;

public class AccountControllerTest extends BaseAPiTest{
	@Test
	public void account(){
		AccountInput input = new AccountInput();
		input.setAccessId("dddd");
		input.setIp("sdfs");
		input.setUserno("sdf");
		doService("/account", input);
	}
}
