package com.peach.elasticsearch.remote;

import com.peach.elasticsearch.entity.dao.MedicineCache;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "service-data-medicine")
public interface MedicineClient {

	@GetMapping("/medicine/selectMedicineCache")
	List<MedicineCache> selectMedicineCache();
}
