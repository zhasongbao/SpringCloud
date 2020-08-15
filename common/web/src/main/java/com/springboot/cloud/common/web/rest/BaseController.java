package com.springboot.cloud.common.web.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.common.web.service.BaseIService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author yukong
 * @date 2019-01-23 10:24
 * S： 业务service实现
 * Q： 查询query实现
 * T:  查询实体类
 * P:  主键类型
 */
public class BaseController<S extends BaseIService<T>,Q extends IPage<T>, T, P extends Serializable> {

    @Autowired
    protected S baseService;

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);




    @ApiOperation(value = "添加", httpMethod = "POST")
    @PostMapping
    public Result<Boolean> save(@RequestBody T t){
        return new Result<>(baseService.save(t));
    }

    @ApiOperation(value = "修改", httpMethod = "PUT")
    @PutMapping
    public Result<Boolean> update(@RequestBody T t){
        return new Result<>(baseService.updateById(t));
    }

    @ApiOperation(value = "删除", httpMethod = "DELETE")
    @DeleteMapping("/id/{id}")
    public Result<Boolean> delete(@PathVariable("id") P id){
        return new Result<>(baseService.removeById(id));
    }

    @ApiOperation(value = "主键查询", notes = "主键查询", httpMethod = "GET")
    @GetMapping("/id/{id}")
    public Result<T> getSysRoleInfo(@PathVariable("id") P id){
        return new Result<>(baseService.getById(id));
    }

    @ApiOperation(value = "分页查询", notes = "分页查询", httpMethod = "GET")
    @GetMapping("/page")
    public Result<IPage<T>> pageByQuery(Q sysRoleQuery){
        return new Result<>(baseService.pageByQuery(sysRoleQuery));
    }

    @ApiOperation(value = "查询所有信息", notes = "查询所有信息", httpMethod = "GET")
    @GetMapping
    public Result<Collection<T>> selectAll(){
        return new Result<>(baseService.listByMap(new HashMap<>()));
    }


}
