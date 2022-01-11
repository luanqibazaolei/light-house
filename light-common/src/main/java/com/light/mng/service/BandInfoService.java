package com.light.mng.service;

import com.light.mng.entity.BandInfo;
import com.light.mng.utils.PageInfo;

/**
 * <p>
 * 乐队信息表 服务类
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
public interface BandInfoService {
    PageInfo<BandInfo> queryBandInfoList( BandInfo bandInfo,int page, int pageSize);


}
