package com.light.show.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.light.mng.entity.ShowInfo;
import com.light.mng.utils.domain.ModelResult;
import com.light.mng.utils.domain.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.light.show.service.IShowInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

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
    private IShowInfoService showInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param showInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ModelResult<Page<ShowInfo>> selectAll(Page<ShowInfo> page, ShowInfo showInfo) {
        return new ModelResult<>(this.showInfoService.page(page, new QueryWrapper<>(showInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ModelResult<ShowInfo> selectOne(@PathVariable Serializable id) {
        return new ModelResult<ShowInfo>(this.showInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param showInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody ShowInfo showInfo) {
        return new Result(this.showInfoService.save(showInfo));
    }

    /**
     * 修改数据
     *
     * @param showInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody ShowInfo showInfo) {
        return new Result(this.showInfoService.updateById(showInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public Result delete(@RequestParam("idList") List<Long> idList) {
        return new Result(this.showInfoService.removeByIds(idList));
    }
}

