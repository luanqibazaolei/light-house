package com.light.mng.controller;

import com.light.mng.entity.BandInfo;
import com.light.mng.service.BandInfoService;
import com.light.mng.utils.PageInfo;
import com.light.mng.utils.domain.ModelResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/band")
public class BandInfoController {

    @DubboReference
    private BandInfoService bandInfoService;

    @GetMapping
    public ModelResult<PageInfo<BandInfo>> selectAll(BandInfo bandInfo, int page, int pageSize) {
        return new ModelResult<>(this.bandInfoService.queryBandInfoList(bandInfo,page,pageSize));
    }


}
