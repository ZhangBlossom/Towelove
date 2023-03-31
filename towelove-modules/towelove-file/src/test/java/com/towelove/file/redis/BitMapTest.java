package com.towelove.file.redis;

import com.towelove.common.core.constant.RedisServiceConstants;
import com.towelove.common.redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.script.RedisScript;
import sun.awt.util.IdentityArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/3/30 13:10
 * BitMapTest类
 */
@SpringBootTest
public class BitMapTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void bitmapCode(){
        //15.4k byte  1024k = 1m
        long userId = 22;
        long articleId = 1000;
        //设定喜欢的文章 设定状态为相反
        boolean bit = redisService.getBit(RedisServiceConstants.USER_LIKE_ARTICLE + userId,
                Long.valueOf(articleId));
        redisService.setBit(RedisServiceConstants.USER_LIKE_ARTICLE + userId
                ,Long.valueOf(articleId),!bit);

        List<Long> likeList = redisService.getCacheList(
                RedisServiceConstants.USER_LIKE_TIME + userId);
        if (bit){
            likeList.remove(articleId);
        }else{
            likeList.add(articleId);
        }
        //去重后放入list
        ArrayList<Long> likeList1 = new ArrayList<>(new HashSet<Long>(likeList));
        redisService.deleteObject(RedisServiceConstants.USER_LIKE_TIME+userId);
        redisService.setCacheList(RedisServiceConstants.USER_LIKE_TIME+userId,
                likeList1);
    }
    @Test
    public void bitmap() {
        Long userId = 1L;
        Long articleId = 124L;
        String key = RedisServiceConstants.USER_LIKE_ARTICLE + userId;
        System.out.println(redisService.setBit(key,
                articleId, Boolean.TRUE));
        System.out.println(redisService.getBit(key, articleId));
        String keyTime = RedisServiceConstants.USER_LIKE_TIME + userId;
        List<Long> list = new ArrayList<>(500);
        list.add(articleId);
        System.out.println(redisService.setCacheList(keyTime, list));
        System.out.println(redisService.getCacheList(keyTime));
        System.out.println("---------------------");
        long length = redisService.bitmapSize(key);
        System.out.println(length);
        System.out.println(redisService.bitCount(key));
        long i = redisService.bitCountRange(key, 0L, 128L);
        System.out.println(i);
        List<Long> articleIds = new ArrayList<>();
        for (long j = 0; j < length; j += 128) {
            if (redisService.bitCountRange(key, j, j + 128) == 0) {
                continue;
            } else {
                for (long h = j; h < j + 128; h++) {
                    if (redisService.getBit(key,h))
                    articleIds.add(h);
                }
            }
        }
        System.out.println(articleIds);

    }
}
