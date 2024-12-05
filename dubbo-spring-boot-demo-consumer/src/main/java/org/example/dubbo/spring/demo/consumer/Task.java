package org.example.dubbo.spring.demo.consumer;

import java.util.Date;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dubbo.spring.demo.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Task implements CommandLineRunner {

    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(()-> {
            int a = 0;
            int b = 1;
            while (true) {
                try {
                    Thread.sleep(1000);
//                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
                    System.out.println(demoService.getAddition(a, b));
                    a++;
                    b++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
