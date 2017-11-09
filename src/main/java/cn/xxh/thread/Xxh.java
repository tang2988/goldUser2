package cn.xxh.thread;

public class Xxh {
	public static void main(String[] args) {
		final long time = 1000;
		Runnable runnable = new Runnable() {
			
			public void run() {
				
				while(true){
					
					System.out.println("xxhxxhxxh");
					
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
