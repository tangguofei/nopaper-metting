package com.open.yun.ysmsvs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.open.yun.common.annotation.AccessToken;
import com.open.yun.common.annotation.AccessType;
import com.open.yun.common.annotation.AnCunReqBody;
import com.open.yun.common.annotation.SignType;
import com.open.yun.common.model.RespBody;
import com.open.yun.ysmsvs.dto.AccountInput;
import com.open.yun.ysmsvs.mapper.AccountMapper;
import com.open.yun.ysmsvs.model.Account;
import com.open.yun.ysmsvs.model.AccountExample;

@RestController
@AnCunReqBody
public class AccountController {
	
	@Resource
	AccountMapper accountMapper;
	
	@AccessToken(access=AccessType.OPEN, sign=SignType.MD5, checkAccess=false)
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public RespBody<List<Account>> entryApplyPage(AccountInput input){
		return new RespBody<List<Account>>(accountMapper.selectByExample(new AccountExample()));
	}
}
