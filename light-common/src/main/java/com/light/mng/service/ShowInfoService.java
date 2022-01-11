package com.light.mng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.light.mng.entity.BandInfo;
import com.light.mng.entity.ShowInfo;
import com.light.mng.utils.PageInfo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 演出表 服务类
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
public interface ShowInfoService {
    PageInfo<ShowInfo> queryBandInfoList(ShowInfo showInfo, int page, int pageSize);

}
