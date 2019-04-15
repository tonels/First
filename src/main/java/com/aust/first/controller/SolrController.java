package com.aust.first.controller;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.util.ResultBean;

@RestController
@RequestMapping("/solr1")
public class SolrController {

	@Autowired
	private SolrClient solrClient;

	@GetMapping("/query")
	public ResultBean search() throws SolrServerException, IOException {
		System.out.println();
		SolrQuery params = new SolrQuery();

		//查询条件, 这里的 q 对应 下面图片标红的地方
		params.set("q", "*:*");
		QueryResponse queryResponse = solrClient.query(params);

		SolrDocumentList results = queryResponse.getResults();

		return ResultBean.ok(results);
	}
}
