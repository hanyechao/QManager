package com.company.project.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OsCommandImpl implements OsCommand {


	/**
	 * 执行windows下CMD命令
	 */
	@Override
	public String windowsCMD(String command) { 
		 Runtime runtime = Runtime.getRuntime();
		 String result = null;
		 String line=null;
	        try {
	            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec("cmd.exe /c "+command).getInputStream(),"gbk"));	           
	            StringBuffer b=new StringBuffer();
	              while ((line=br.readLine())!=null) {
	                  b.append(line+"\n");
	             }
	             result = b.toString();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }

		return result;
	}

	@Override
	public String shellCMD() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String pythonCMD() {
		// TODO Auto-generated method stub
		return "";
	}


}
