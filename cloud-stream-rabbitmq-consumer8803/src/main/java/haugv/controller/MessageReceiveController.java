package haugv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@EnableBinding(Sink.class)
public class MessageReceiveController {


    @Value("${server.port}")
    String port;

    @GetMapping("/receiveMessage")
    public String receiveMessage(){
        return port;
    }

    /**
     * getPayload 与消息发送者的 withPayload对应
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者接收到的消息："+message.getPayload()+"\t"+port);
    }
}
