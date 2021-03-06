package com.hm.qyhm.controller.authority;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.qyhm.common.result.Code;
import com.hm.qyhm.common.result.Result;
import com.hm.qyhm.common.result.ResultInfo;
import com.hm.qyhm.common.utils.CiphersUtils;
import com.hm.qyhm.common.utils.CommonUtils;
import com.hm.qyhm.common.utils.CurrentUserUtils;
import com.hm.qyhm.entity.authority.UserEntity;
import com.hm.qyhm.service.authority.UserService;

@RestController
public class UserController {

	static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * 添加用户
	 * 
	 * @param username
	 * @param password
	 * @param telephone
	 * @return
	 */
	@RequestMapping(value = "/api/user/add", method = RequestMethod.POST)
	public Result add(String username, String password, String telephone) {
		try {
			UserEntity user = userService.findByUsername(username);
			if (user != null) {
				return new Result(Code.EXISTED.value(), "user exist");
			}

			Date now = new Date();
			user = new UserEntity(username, CiphersUtils.getInstance().MD5Password(password), telephone, now, now);
			userService.save(user);
			return new Result(Code.SUCCESS.value(), "created");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}

	}

	/**
	 * 编辑用户
	 * 
	 * @param userId
	 * @param telephone
	 * @return
	 */
	@RequestMapping(value = "/api/user/edit", method = RequestMethod.POST)
	public Result edit(Long userId, String telephone) {
		try {
			UserEntity user = userService.findOne(userId);

			user.setTelephone(telephone);
			user.setUpdateTime(new Date());
			userService.save(user);
			return new Result(Code.SUCCESS.value(), "updated");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param userIds
	 * @return
	 */
	@RequestMapping(value = "/api/user/delete", method = RequestMethod.GET)
	public Result delete(String userIds) {
		try {
			userService.delete(CommonUtils.convent2Long(userIds));
			return new Result(Code.SUCCESS.value(), "deleted");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}

	/**
	 * 用户详情
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/api/user/detail", method = RequestMethod.GET)
	public Result detail(Long userId) {
		try {
			UserEntity user = userService.findOne(userId);
			return new ResultInfo(Code.SUCCESS.value(), "ok", user);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
	public Result listUser() {
		try {
			List<UserEntity> userList = userService.list();
			return new ResultInfo(Code.SUCCESS.value(), "ok", userList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}
	}

	/**
	 * 用户登录
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
	public Result login(String username, String password) {
		try {
			UserEntity user = userService.findByUsername(username);
			if (user == null) {
				return new Result(Code.NULL.value(), "user null");
			}

			if (!StringUtils.equals(CiphersUtils.getInstance().MD5Password(password), user.getPassword())) {
				return new Result(Code.USER_PWD_ERROR.value(), "password error");
			}

			user.setLastLoginTime(new Date());
			userService.save(user);
			CurrentUserUtils.getInstance().serUser(user);
			return new Result(Code.SUCCESS.value(), "login success");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Result(Code.ERROR.value(), e.getMessage());
		}

	}

	/**
	 * 用户名是否存在
	 *
	 * @param username
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/api/user/exist", method = RequestMethod.GET)
	public @ResponseBody String exist(String username) throws JsonProcessingException {
		boolean result = true;

		UserEntity user = userService.findByUsername(username);
		if (user != null) {
			result = false;
		}

		Map<String, Boolean> map = new HashMap<>();
		map.put("valid", result);
		ObjectMapper mapper = new ObjectMapper();
		String resultString = mapper.writeValueAsString(map);

		return resultString;
	}

}
