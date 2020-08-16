package com.springboot.cloud.sysadmin.organization.rest;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.common.core.util.UserContextHolder;
import com.springboot.cloud.sysadmin.organization.entity.dto.SysResourceTree;
import com.springboot.cloud.sysadmin.organization.entity.form.ResourceForm;
import com.springboot.cloud.sysadmin.organization.entity.form.ResourceQueryForm;
import com.springboot.cloud.sysadmin.organization.entity.param.ResourceQueryParam;
import com.springboot.cloud.sysadmin.organization.entity.po.Resource;
import com.springboot.cloud.sysadmin.organization.service.IResourceService;
import com.springboot.cloud.sysadmin.organization.service.IUserRoleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/resource")
@Api("resource")
@Slf4j
public class ResourceController {

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private IUserRoleService userRoleService;

    @ApiOperation(value = "新增资源", notes = "新增一个资源")
    @ApiImplicitParam(name = "resourceForm", value = "新增资源form表单", required = true, dataType = "ResourceForm")
    @PostMapping
    public Result add(@Valid @RequestBody ResourceForm resourceForm) {
        log.debug("name:{}", resourceForm);
        Resource resource = resourceForm.toPo(Resource.class);
        return Result.success(resourceService.add(resource));
    }

    @ApiOperation(value = "删除资源", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "资源ID", required = true, dataType = "string")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(resourceService.delete(id));
    }

    @ApiOperation(value = "修改资源", notes = "修改指定资源信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源ID", required = true, dataType = "string"),
            @ApiImplicitParam(name = "resourceForm", value = "资源实体", required = true, dataType = "ResourceForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody ResourceForm resourceForm) {
        Resource resource = resourceForm.toPo(id, Resource.class);
        return Result.success(resourceService.update(resource));
    }

    @ApiOperation(value = "获取资源", notes = "获取指定资源信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "资源ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return Result.success(resourceService.get(id));
    }

    @ApiOperation(value = "查询资源", notes = "根据userId查询用户所拥有的资源信息")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping(value = "/user/{username}")
    public Result queryByUsername(@PathVariable String username) {
        log.debug("query with username:{}", username);
        log.debug("===注备查询资源===");
        List<Resource> resources = resourceService.query(username);
        log.debug("===注备查询资源返回===");
        log.debug(resources.toString());

        return Result.success(resources);
    }

    @ApiOperation(value = "查询所有资源", notes = "查询所有资源信息")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping(value = "/all")
    public Result queryAll() {
        return Result.success(resourceService.getAll());
    }

    @ApiOperation(value = "搜索资源", notes = "根据条件搜索资源信息")
    @ApiImplicitParam(name = "resourceQueryForm", value = "资源查询参数", required = true, dataType = "RoleQueryForm")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @PostMapping(value = "/conditions")
    public Result query(@Valid @RequestBody ResourceQueryForm resourceQueryForm) {
        log.debug("query with name:{}", resourceQueryForm);
        return Result.success(resourceService.query(resourceQueryForm.getPage(), resourceQueryForm.toParam(ResourceQueryParam.class)));
    }


    /**
     * 获取当前用户的菜单树
     * @return
     */
    @ApiOperation(value = "获取当前用户的菜单树", notes = "根据token查询当前用户权限的菜单树", httpMethod = "GET")
    @GetMapping("/menu/tree")
    public Result<List<SysResourceTree>> getMenuTree(){
        String username = UserContextHolder.getInstance().getUsername();
        Set<String> roleCodes = userRoleService.queryByUserId(username);
        return new Result<>(resourceService.getMenuTreeByRoleCodes(roleCodes));
    }

    /**
     * 获取所有的资源树
     * @return
     */
    @GetMapping("/tree")
    @ApiOperation(value = "获取所有菜单的树", notes = "获取所有菜单的树", httpMethod = "GET")
    public Result<List<SysResourceTree>> getAllResourceTree(){
        log.debug("@ApiOperation(value = \"获取所有菜单的树\", notes = \"获取所有菜单的树\", httpMethod = \"GET\")");
        return new Result<>(resourceService.getAllResourceTree());
    }


}
