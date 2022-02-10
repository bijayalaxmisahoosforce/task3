package com.example.trades.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.trades.beans.TradeBean;
import com.example.trades.model.TradesEntity;
import com.example.trades.repository.TradesRepository;
import com.example.trades.response.CommonResponse;
import com.example.trades.service.TradesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TradesServiceImpl implements TradesService {

	@Autowired
	TradesRepository tradesRepository;

	@Override
	public CommonResponse getTrades(String symbol,Integer limit) {
		String url = "https://api.binance.com/api/v3/trades?symbol={symbol}&limit={limit}";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("X-Request-Source", "Desktop");
		HttpEntity request = new HttpEntity(headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class,symbol, limit);
			ObjectMapper objectMapper = new ObjectMapper();
			List<TradeBean> tradesResponse = objectMapper.readValue(response.getBody(),
					new TypeReference<List<TradeBean>>() {
					});
			if (response.getStatusCode() == HttpStatus.OK) {
				List<TradesEntity> tradesEntityList = new ArrayList<TradesEntity>();
				for (TradeBean bean : tradesResponse) {
					// pre-process for save/update data in db
					TradesEntity tradesEntity = new TradesEntity();
					tradesEntity.setId(bean.getId());
					tradesEntity.setPrice(bean.getPrice());
					tradesEntity.setQty(bean.getQty());
					tradesEntity.setQuoteQty(bean.getQuoteQty());
					tradesEntity.setTime(bean.getTime());
					tradesEntityList.add(tradesEntity);

				}

				tradesRepository.saveAll(tradesEntityList);
				return new CommonResponse(HttpStatus.OK.toString(), "Process Successful", tradesResponse);
			}
		} catch (Exception ex) {
			return new CommonResponse(HttpStatus.FAILED_DEPENDENCY.toString(), "Process Failed", ex.getMessage());
		}
		return new CommonResponse(HttpStatus.FAILED_DEPENDENCY.toString(), "Process Failed", null);

	}

}
