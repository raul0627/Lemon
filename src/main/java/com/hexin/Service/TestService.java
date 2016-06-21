package com.hexin.Service;

import com.hexin.Dao.TestArrayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("testService")
public class TestService implements ITestService{

	/*@Autowired
	private UserMapper userMapper;*/
	@Autowired
	private TestArrayMapper testArrayMapper;
	@Override
	public String madrid() throws Exception {
//		userMapper.insert();
		List<HashMap<String, Object>> result = testArrayMapper.queryArray();
		if (result.size() <= 0) {
			System.out.println("no data!!!");
			return null;
		}
		for (HashMap<String, Object> map : result) {
			Object ob =  map.get("score");
			String str = ob.toString();
			System.out.println(str);
		}
		return "success";
	}

}
