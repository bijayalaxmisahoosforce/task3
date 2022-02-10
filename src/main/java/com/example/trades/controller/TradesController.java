package com.example.trades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trades.response.CommonResponse;
import com.example.trades.service.TradesService;

@RestController
@RequestMapping("/v1")
public class TradesController {
	@Autowired
	TradesService tradesService;
	
	@GetMapping("/trades")
	public CommonResponse getResponse(@RequestParam String symbol,@RequestParam Integer limit) {
		return tradesService.getTrades(symbol,limit);
	}
}
