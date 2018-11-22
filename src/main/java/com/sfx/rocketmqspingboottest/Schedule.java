package com.sfx.rocketmqspingboottest;

import com.maihaoche.starter.mq.base.MessageBuilder;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Component
@EnableScheduling
public class Schedule {
    @Autowired
    RockmqProducer rockmqProducer;
    @Value("${rocketmq.topic}")
    String topic;
    @Scheduled(cron = "00/1 * * * * ?")
    public void Send() {

        String message = UUID.randomUUID().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = message+df.format(Calendar.getInstance().getTime());
        Message msg2 = MessageBuilder.of(msg).topic(topic).tag("sfx").key("sfxKey").build();
        rockmqProducer.syncSend(msg2);

    }
}
