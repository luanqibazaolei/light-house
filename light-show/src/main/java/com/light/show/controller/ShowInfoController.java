package com.light.show.controller;


import com.light.mng.entity.ShowInfo;
import com.light.mng.service.ShowInfoService;
import com.light.mng.utils.PageInfo;
import com.light.mng.utils.domain.ModelResult;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 演出表(ShowInfo)表控制层
 *
 * @author shenzl
 * @since 2021-12-23 16:47:12
 */
@RestController
@RequestMapping("showInfo")
public class ShowInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ShowInfoService showInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param showInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ModelResult<PageInfo<ShowInfo>> selectAll(ShowInfo showInfo, Integer page, Integer pageSize) {
        PageInfo<ShowInfo> showInfoPageInfo = showInfoService.queryBandInfoList(showInfo, page, pageSize);
        return new ModelResult<>(showInfoPageInfo);
    }


}

