package cn.jbit.Servlet;

import java.util.regex.Pattern;

public class zzz {
	public static void main(String[] args) {
		
		boolean aa = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$").matcher("15012812812").matches();
		System.out.println(aa);
		System.out.println("150128128111".matches("^[1]{1}[0-9]{10}$"));
	}

}
