package cn.xxh.thread;

import java.util.Timer;
import java.util.TimerTask;

public class Xxh1 {
	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			
			public void run() {
				System.out.println("xxxxxxxxxxxxxxxxxxxxhhhhhhhhhhhhhh");
				
			}
		};
		Timer timer = new Timer();
		long time = 4000;
		long timepro = 1 * 1000;
		timer.scheduleAtFixedRate(task, time,timepro);
	}

}
