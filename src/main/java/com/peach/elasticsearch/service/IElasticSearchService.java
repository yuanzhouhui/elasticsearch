package com.peach.elasticsearch.service;

import com.peach.elasticsearch.entity.dao.MedicineCache;
import com.peach.elasticsearch.entity.req.DeleteReq;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IElasticSearchService {
	/**
	 * 导入所有商品
	 *
	 * @return 商品数量
	 */
	int importAllGoods();

	/**
	 * 根据id批量删除商品
	 *
	 * @param req id列表
	 * @return 删除数量
	 */
	int delete(DeleteReq req);

	/**
	 * 根据id更新商品信息
	 *
	 * @param id id
	 * @return 数量
	 */
	int update(Long id);

	/**
	 * 根据关键字分页查询
	 *
	 * @param keywords 关键字
	 * @param pageNum  页数
	 * @param pageSize 每页数量
	 * @return 结果
	 */
	Page<MedicineCache> search(String keywords, Integer pageNum, Integer pageSize);
}
