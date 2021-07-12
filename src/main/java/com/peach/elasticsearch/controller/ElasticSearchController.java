package com.peach.elasticsearch.controller;

import com.peach.component.logkit.reuslt.Result;
import com.peach.component.logkit.reuslt.ResultFactory;
import com.peach.elasticsearch.entity.req.DeleteReq;
import com.peach.elasticsearch.service.IElasticSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("elasticSearch")
@Api(value = "ElasticSearchController", tags = "ES药品搜索")
public class ElasticSearchController {

	@Autowired
	private IElasticSearchService elasticSearchService;

	@GetMapping("/importAll")
	@ApiOperation(httpMethod = "GET", value = "导入所有商品")
	public Result importAll() {
		return ResultFactory.buildSuccessResult(elasticSearchService.importAllGoods());
	}

	@PostMapping("/delete")
	@ApiOperation(httpMethod = "POST", value = "根据ids删除商品")
	public Result deleteByIds(@RequestBody DeleteReq req) {
		return ResultFactory.buildSuccessResult(elasticSearchService.delete(req));
	}

	@GetMapping("/search")
	@ApiOperation(httpMethod = "GET", value = "根据关键字搜索商品")
	public Result searchByKeyword(@RequestParam(required = false) String keyword,
								  @RequestParam(value = "pageNum", required = false, defaultValue = "0") Integer pageNum,
								  @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
		return ResultFactory.buildSuccessResult(elasticSearchService.search(keyword, pageNum, pageSize));
	}
}
