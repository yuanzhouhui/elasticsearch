package com.peach.elasticsearch.repository;

import com.peach.elasticsearch.entity.dao.MedicineCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsRepository extends ElasticsearchRepository<MedicineCache, String> {

	Page<MedicineCache> findByDisplayNameOrMedicineNameOrTreatment(String dispalyName, String medicineName, String treatment, Pageable page);
}
