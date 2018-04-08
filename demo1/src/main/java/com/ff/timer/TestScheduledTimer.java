package com.ff.timer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestScheduledTimer {
    @Scheduled(cron = "0 */1 * * * ?")
    public void test(){
      log.info("时间="+System.currentTimeMillis());
    }
}
