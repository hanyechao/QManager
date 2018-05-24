package com.company.project.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSCommand {

	/**
	 * 执行windows下CMD命令
	 */

	public static String windowsCMD(String command) {
		Runtime runtime = Runtime.getRuntime();
		String result = null;
		String line = null;
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(runtime.exec("cmd.exe /c " + command).getInputStream(), "gbk"));
			StringBuffer b = new StringBuffer();
			while ((line = br.readLine()) != null) {
				b.append(line + "\n");
			}
			result = b.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String shellCMD(String command) {
		try {
			Process ps = Runtime.getRuntime().exec(command);
			ps.waitFor();

			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			String result = sb.toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public String pythonCMD() {
		// TODO Auto-generated method stub
		return "";
	}

}
