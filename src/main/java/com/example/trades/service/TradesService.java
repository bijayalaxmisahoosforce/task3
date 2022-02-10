package com.example.trades.service;

import com.example.trades.response.CommonResponse;

public interface TradesService {

	public CommonResponse getTrades(String symbol,Integer limit);
}
