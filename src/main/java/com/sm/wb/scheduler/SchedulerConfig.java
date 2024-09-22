package com.sm.wb.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	private Integer counter=4;

	@Scheduled(cron="*/60 * * * * ?")
	public void cancelIRNSchd() throws InterruptedException 
	{
		for(int i=0;i<=counter;i++) {
			String invNum="INV_"+i;
			String message="invoice cancelled for "+invNum;
			messagingTemplate.convertAndSend("/topic/notifications", message);
			Thread.sleep(5000);
		}
	}
}
