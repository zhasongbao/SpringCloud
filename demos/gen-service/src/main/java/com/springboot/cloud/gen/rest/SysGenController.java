package com.springboot.cloud.gen.rest;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.gen.model.query.TableInfoQuery;
import com.springboot.cloud.gen.service.ISysGenService;
import com.springboot.cloud.gen.service.ITableInfoService;
import com.springboot.cloud.gen.model.dto.BuildConfigDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dongwei
 * @date: 2018/11/8 10:33
 */
@Controller
@Api(value = "代码生成controller", tags = {"代码生成接口管理"})
public class SysGenController {

    private static final String MODULE_NAME = "代码生成模块";


    @Autowired
    private ITableInfoService tableInfoService;

    @Autowired
    private ISysGenService sysGenService;


    @ApiOperation(value = "分页查询数据库中所有的表信息", notes = "分页查询数据库中所有的表信息", httpMethod = "GET")
    @ApiImplicitParam(name = "query", value = "表信息查询条件", required = false, dataType = "TableInfoQuery")
    @ResponseBody
    @GetMapping("/table/page")
    public Result<TableInfoQuery> page(TableInfoQuery query){
        return Result.success(tableInfoService.pageByQuery(query));
    }



    @ApiOperation(value = "根据表名称生成代码", notes = "根据表名称生成代码  返回zip包", httpMethod = "POST")
    @ApiImplicitParam(name = "buildConfigDTO", value = "表配置", required = true, dataType = "BuildConfigDTO")
    @PostMapping("/code")
    public void code(@RequestBody BuildConfigDTO buildConfigDTO, HttpServletResponse response) throws IOException {

        byte[] data = sysGenService.genCodeByTableName(buildConfigDTO);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

}
