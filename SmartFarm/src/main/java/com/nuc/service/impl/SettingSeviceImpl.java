package com.nuc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.mapper.SettingMapper;
import com.nuc.pojo.Setting;
import com.nuc.service.SettingService;

@Service
public class SettingSeviceImpl implements SettingService{

	@Autowired
	SettingMapper settingMapper;

	@Override
	public int updateByPrimaryKeySelective(Setting record) {
		// TODO Auto-generated method stub
		return settingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Setting select() {
		// TODO Auto-generated method stub
		return settingMapper.selectByPrimaryKey(1);
	}
	


}
