package blossom.project.towelove.msg.entity;

import java.time.LocalTime;
import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * (MsgTask) 表实体类
 *
 * @author 张锦标
 * @since 2023-11-21 19:33:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("msg_task")
public class MsgTask {
    //主键
    @TableId
    private Long id;

    //用户id
    private Long userId;
    //邮箱账号id
    private Long accountId;
    //模板id
    private Long templateId;
    //接收消息的邮箱账号
    private String receiveAccount;
    //发送人名称
    private String nickname;
    //标题
    private String title;
    //内容
    private String content;
    //发送日期
    private Date sendDate;
    //消息发送时间
    private LocalTime sendTime;
    //消息类型 0：发送一次 1：定时发送
    private Integer msgType;
    //状态
    private Integer status;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    //是否删除
    private Integer deleted;
    //参数数组(自动根据内容生成)
    private String params;
    //创建者
    private String createBy;

}

