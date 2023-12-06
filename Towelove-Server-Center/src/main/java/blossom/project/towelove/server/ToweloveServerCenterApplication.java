package blossom.project.towelove.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ZhangBlossom
 * @date: 2023/11/21 18:28
 * @contact: QQ:4602197553
 * @contact: WX:qczjhczs0114
 * @blog: https://blog.csdn.net/Zhangsama1
 * @github: https://github.com/ZhangBlossom
 * MsgApplicatiojn类
 */
@SpringBootApplication
@EnableFeignClients("blossom.project.towelove.client")
public class ToweloveServerCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToweloveServerCenterApplication.class,args);

        System.out.println("（づ￣3￣）づ╭❤～ Towelove 服务中心模块启动成功  (o>ε(o>ｕ(≧∩≦)");
        System.out.println(
               " __  __           \n" +
                       "|  \\/  |          \n" +
                       "| \\  / |___  __ _ \n" +
                       "| |\\/| / __|/ _` |\n" +
                       "| |  | \\__ \\ (_| |\n" +
                       "|_|  |_|___/\\__, |\n" +
                       "             __/ |\n" +
                       "            |___/ \n");

    }
}