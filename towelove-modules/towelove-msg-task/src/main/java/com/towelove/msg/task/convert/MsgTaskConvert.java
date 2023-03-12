package com.towelove.msg.task.convert;

import cn.hutool.core.util.StrUtil;
import com.towelove.common.core.domain.PageResult;
import com.towelove.msg.task.domain.MsgTask;
import com.towelove.msg.task.domain.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author: 张锦标
 * @date: 2023/3/11 17:41
 * MsgTaskConvert类
 * 将MsgTask与VO和DTO对象之间进行转换
 */
@Mapper
public interface MsgTaskConvert {
    MsgTaskConvert INSTANCE = Mappers.getMapper(MsgTaskConvert.class);

    MsgTask convert(MsgTaskCreateReqVO bean);

    MsgTask convert(MsgTaskUpdateReqVO bean);

    MsgTaskRespVO convert(MsgTask bean);

    PageResult<MsgTaskBaseVO> convertPage(PageResult<MsgTask> pageResult);

    List<MsgTaskSimpleRespVO> convertList02(List<MsgTask> list);

    MsgTaskSimpleRespVO map(MsgTask value);

}
