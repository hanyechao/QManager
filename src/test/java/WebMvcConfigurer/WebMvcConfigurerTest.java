package WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.conpany.project.Tester;

public class WebMvcConfigurerTest extends Tester {
	@Test
	public void validateSignTest() {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("id", "1");
		List<String> keys = new ArrayList<String>(hashMap.keySet());
		keys.remove("sign");// 排除sign参数
		Collections.sort(keys);// 排序
		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			sb.append(key).append("=").append(hashMap.get(key)).append("&");// 拼接字符串
		}
		String linkString = sb.toString();
		String secret = "Potato";// 密钥，自己修改
		String sign = DigestUtils.md5Hex(linkString + secret);// 混合密钥md5
		System.err.println(sign);
	}
}
