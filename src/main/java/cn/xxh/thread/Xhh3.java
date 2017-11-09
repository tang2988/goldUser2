package cn.xxh.thread;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.jbit.Dao.OrderinformationDao;
import cn.jbit.DaoImpl.OrderinformationDaoImpl;
import cn.jbit.entity.Orderinformation;

public class Xhh3 {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			public void run() {
				Date aa = new Date();
				System.out.println(aa);
			}
		};
		// 实例化ScheduledExecutorService类 调用方法创建
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();

		// 调用速率执行的方法(指定任务,起始延迟1秒,间隔5秒,秒)
		service.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);

	}

}
