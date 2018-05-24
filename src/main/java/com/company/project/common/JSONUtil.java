package com.company.project.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONUtil {
	/**
	 * 将json字符串转为Map结构 如果json复杂，结果可能是map嵌套map
	 * 
	 * @param jsonStr
	 *            入参，json格式字符串
	 * @return 返回一个map
	 */
	public static Map<String, Object> json2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<>();
		if (jsonStr != null && !"".equals(jsonStr)) {
			// 最外层解析
			JSONObject json = JSONObject.parseObject(jsonStr);
			for (Object k : json.keySet()) {
				Object v = json.get(k);
				// 如果内层还是数组的话，继续解析
				if (v instanceof JSONArray) {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Iterator<Object> it = ((JSONArray) v).iterator();
					while (it.hasNext()) {
						JSONObject json2 = (JSONObject) it.next();
						list.add(json2Map(json2.toString()));
					}
					map.put(k.toString(), list);
				} else {
					map.put(k.toString(), v);
				}
			}
			return map;
		} else {
			return null;
		}
	}
}
