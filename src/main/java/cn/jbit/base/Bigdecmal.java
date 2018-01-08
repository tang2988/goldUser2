package cn.jbit.base;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class Bigdecmal {
	
	public static void main(String[] args) {
		
		BigDecimal bd = new BigDecimal("122.21");
		System.out.println(bd.abs());
		System.out.println(bd.compareTo(new BigDecimal("20")));
		System.out.println(bd.divide(new BigDecimal("200"),2,RoundingMode.DOWN));
		System.out.println(bd.hashCode());
		System.out.println(bd.longValue());
		System.out.println(bd.doubleValue());
		System.out.println(bd.intValue());
		System.out.println(bd.max(new BigDecimal(200333)));
		System.out.println(bd.min(new BigDecimal(3000)));
		System.out.println(bd.negate());
		System.out.println(bd.plus());
		System.out.println(bd.precision());
		System.out.println(bd.round(MathContext.DECIMAL64));
		System.out.println(bd.setScale(3));
		System.out.println(bd.subtract(new BigDecimal("2")));
		System.out.println(bd.toString());
		System.out.println(bd.valueOf(200));
		System.out.println(bd);
		
		
		
		
	}
	

}
