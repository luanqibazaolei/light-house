package com.light.show.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.light.mng.entity.BandInfo;
import com.light.mng.service.BandInfoService;

import com.light.mng.utils.PageInfo;

import com.light.show.mapper.BandInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 乐队信息表 服务实现类
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@DubboService
public class BandInfoServiceImpl  implements BandInfoService {

    @Autowired
    BandInfoMapper bandInfoMapper;

    @Override
    public PageInfo<BandInfo> queryBandInfoList(BandInfo bandInfo, int page, int pageSize) {
        QueryWrapper<BandInfo> queryWrapper = new QueryWrapper<BandInfo>(bandInfo);
        // 排序
        // queryWrapper.orderByDesc();
        IPage<BandInfo> iPage = bandInfoMapper.selectPage(new Page<BandInfo>(page, pageSize), queryWrapper);
        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(), page, pageSize, iPage.getRecords());
    }

}
