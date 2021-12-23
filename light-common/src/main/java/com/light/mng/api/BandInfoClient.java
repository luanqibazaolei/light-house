package com.light.mng.api;

import com.light.mng.entity.BandInfo;
import com.light.mng.utils.domain.ModelResult;
import com.light.mng.utils.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@FeignClient("light-show")
@Component
public interface BandInfoClient {
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param bandInfo 查询实体
     * @return 所有数据
     */
    @GetMapping("/bandInfo")
    public ModelResult<BandInfo> selectAll(@RequestParam("bandInfo") BandInfo bandInfo,@RequestParam("page") Integer page,@RequestParam("page") Integer pageSize) ;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/bandInfo/{id}")
    public ModelResult<BandInfo> selectOne(@PathVariable Serializable id) ;

    /**
     * 新增数据
     *
     * @param bandInfo 实体对象
     * @return 新增结果
     */
    @PostMapping("/bandInfo")
    public Result insert(@RequestBody BandInfo bandInfo) ;

    /**
     * 修改数据
     *
     * @param bandInfo 实体对象
     * @return 修改结果
     */
    @PutMapping("/bandInfo")
    public Result update(@RequestBody BandInfo bandInfo) ;

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/bandInfo")
    public Result delete(@RequestParam("idList") List<Long> idList) ;
}
