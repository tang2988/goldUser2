package cn.xxh.thread;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.jbit.Service.OrderinformationService;
import cn.jbit.ServiceImpl.OrderinformationServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Orderinformation;

public class date {

	public static void main(String[] args) {
		System.out.println("正在启动定时任务");

		Runnable runnable = new Runnable() {

			public void run() {
				aaaaaaaaaa();
				
			}
		};
		// 实例化ScheduledExecutorService类 调用方法创建
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();

		// 调用速率执行的方法(指定任务,起始延迟1秒,间隔5秒,秒)
		service.scheduleAtFixedRate(runnable, 1, 5, TimeUnit.SECONDS);

	}
	
	public static void aaaaaaaaaa() {
		OrderinformationService orderService = new OrderinformationServiceImpl();
		List<Orderinformation> list = orderService.findAll();
		
		for(Orderinformation list2 :list){
			Orderinformation orderinformation = orderService.findAllById(list2.getOrderId());
			System.out.println(orderinformation.getOrderId());
			ResBo zhen = orderService.Thesystemorderisinvalid(orderinformation);
			
		}
		System.out.println("zheng");
		//循环所有订单ID
		
		
	}
	
	private void bbbbbbb() {
		System.out.println("zheng");
		//循环所有订单ID
		
	}
	
}
