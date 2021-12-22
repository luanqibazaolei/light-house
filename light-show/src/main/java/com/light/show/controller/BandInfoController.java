package com.light.show.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.light.mng.utils.domain.ModelResult;
import com.light.mng.utils.domain.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.light.show.entity.BandInfo;
import com.light.show.mapper.BandInfoMapper;
import com.light.show.service.IBandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 乐队信息表(BandInfo)表控制层
 *
 * @author makejava
 * @since 2021-12-22 16:12:14
 */
@RestController
@RequestMapping("bandInfo")
public class BandInfoController {
    /**
     * 服务对象
     */
    @Resource
    private IBandInfoService bandInfoService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param pageSize 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ModelResult<Page<BandInfo>> selectAll(Integer page , Integer pageSize) {
        Page page1 = new Page(page,pageSize);


        return new ModelResult<>(this.bandInfoService.page(page1));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ModelResult<BandInfo> selectOne(@PathVariable("id") Serializable id) {
        return new ModelResult<BandInfo>(this.bandInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bandInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody BandInfo bandInfo) {
        return new Result(this.bandInfoService.save(bandInfo));
    }

    /**
     * 修改数据
     *
     * @param bandInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody BandInfo bandInfo) {
        return new Result(this.bandInfoService.updateById(bandInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return new Result(this.bandInfoService.removeByIds(idList));
    }
}

