package cn.jbit.Servlet;

import java.math.BigDecimal;


public class xie {
	public static void main(String[] args){
 
		String s = "64";
		BigDecimal b1 = new BigDecimal(s);
		String b = "8";
		BigDecimal b2 = new BigDecimal(b);
		 BigDecimal aa = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
		 System.out.println(aa);
		
	}

}
