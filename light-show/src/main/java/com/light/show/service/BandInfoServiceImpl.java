package com.light.show.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.light.mng.entity.BandInfo;
import com.light.mng.service.BandInfoService;

import com.light.mng.utils.BaseServiceImpl;
import com.light.mng.utils.PageInfo;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 乐队信息表 服务实现类
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@DubboService
public class BandInfoServiceImpl extends BaseServiceImpl<BandInfo> implements BandInfoService {

    @Override
    public PageInfo<BandInfo> queryBandInfoList(BandInfo bandInfo, int page, int pageSize) {
        QueryWrapper<BandInfo> queryWrapper = new QueryWrapper<BandInfo>(bandInfo);
        //根据数据的更新时间做倒叙排序
        IPage<BandInfo> iPage = super.queryPageList(queryWrapper, page, pageSize);
        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(), page, pageSize, iPage.getRecords());
    }

}
