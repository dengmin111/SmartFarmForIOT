package com.nuc.service;

import com.nuc.pojo.Setting;

public interface SettingService {
	 int updateByPrimaryKeySelective(Setting record);
	 Setting select();

}
