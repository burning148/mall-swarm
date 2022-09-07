package com.macro.mall.demo.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.service.FeignSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Feign调用mall-search接口示例
 * Created by macro on 2019/10/22.
 */
@Api(tags = "FeignSearchController", description = "Feign调用mall-search接口示例")
@RestController
@RequestMapping("/feign/search")
public class FeignSearchController {

    @Resource
    private FeignSearchService feignSearchService;

    @ApiOperation(value = "简单商品搜索")
    @RequestMapping(value = "/justSearch", method = RequestMethod.GET)
    
    public CommonResult search(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        return feignSearchService.search(keyword, pageNum, pageSize);
    }
}
