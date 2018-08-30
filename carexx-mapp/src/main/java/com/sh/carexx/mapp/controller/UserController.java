package com.sh.carexx.mapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.carexx.common.CarexxConstant;
import com.sh.carexx.common.web.BasicRetVal;
import com.sh.carexx.common.web.DataRetVal;
import com.sh.carexx.common.web.SessionHolder;
import com.sh.carexx.model.uc.UserInfo;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@RequestMapping(value = "/get_user_info")
	public String getUserInfo() {
		UserInfo userInfo = this.ucServiceClient.getUserInfo(SessionHolder.getUserId());
		return new DataRetVal(CarexxConstant.RetCode.SUCCESS, userInfo).toJSON();
	}

	@RequestMapping(value = "/modify_bind_mobile/{mobile}/{verifyCode}")
	public BasicRetVal modifyBindMobile(@PathVariable("mobile") String mobile,
			@PathVariable("verifyCode") String verifyCode) {
		Integer id = this.getCurrentUser().getId();
		return this.ucServiceClient.modifyUserBindMobile(id, mobile, verifyCode);
	}
}
