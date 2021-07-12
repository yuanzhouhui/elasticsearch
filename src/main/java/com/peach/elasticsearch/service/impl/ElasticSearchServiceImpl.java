package com.peach.elasticsearch.service.impl;

import com.peach.elasticsearch.entity.dao.MedicineCache;
import com.peach.elasticsearch.entity.req.DeleteReq;
import com.peach.elasticsearch.remote.MedicineClient;
import com.peach.elasticsearch.repository.EsRepository;
import com.peach.elasticsearch.service.IElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticSearchServiceImpl implements IElasticSearchService {

	@Autowired
	private MedicineClient medicineClient;

	@Autowired
	private EsRepository esRepository;

	@Override
	public int importAllGoods() {
		List<MedicineCache> medicineCaches = medicineClient.selectMedicineCache();
		if (medicineCaches.size() > 0) {
			esRepository.saveAll(medicineCaches);
			return medicineCaches.size();
		}
		return 0;
	}

	@Override
	public int delete(DeleteReq req) {
		for (String id : req.getIds()) {
			esRepository.deleteById(id);
		}
		return req.getIds().size();
	}

	@Override
	public int update(Long id) {
		return 0;
	}

	@Override
	public Page<MedicineCache> search(String keywords, Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return esRepository.findByDisplayNameOrMedicineNameOrTreatment(keywords,keywords, keywords, pageable);
	}
}
