package com.peach.elasticsearch.entity.req;

import lombok.Data;

import java.util.List;

@Data
public class DeleteReq {
	private List<String> ids;
}
