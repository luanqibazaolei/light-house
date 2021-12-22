package com.light.show.service.impl;

import com.light.show.entity.BandInfo;
import com.light.show.mapper.BandInfoMapper;
import com.light.show.service.IBandInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 乐队信息表 服务实现类
 * </p>
 *
 * @author light
 * @since 2021-12-22
 */
@Service
public class BandInfoServiceImpl extends ServiceImpl<BandInfoMapper, BandInfo> implements IBandInfoService {

}
