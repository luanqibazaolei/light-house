package com.light.show.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.light.mng.entity.BandInfo;
import com.light.mng.entity.ShowInfo;
import com.light.mng.service.ShowInfoService;
import com.light.mng.utils.PageInfo;
import com.light.show.mapper.ShowInfoMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 演出表 服务实现类
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@DubboService
public class ShowInfoServiceImpl implements ShowInfoService {

    @Autowired
    ShowInfoMapper showInfoMapper;

    @Override
    public PageInfo<ShowInfo> queryBandInfoList(ShowInfo showInfo, int page, int pageSize) {
        QueryWrapper<ShowInfo> queryWrapper = new QueryWrapper(showInfo);
        //根据数据的更新时间做倒叙排序
        IPage<ShowInfo> iPage = showInfoMapper.selectPage(new Page<>(page,pageSize), queryWrapper);
        return new PageInfo<>(Long.valueOf(iPage.getTotal()).intValue(), page, pageSize, iPage.getRecords());
    }
}
