package com.challenge.constants;

public enum Urls {
	REPLACE ("XYZ"),
	STOCK_URL ("http://finance.yahoo.com/webservice/v1/symbols/XYZ/quote"),
	DAY_RANGE_URL ("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22XYZ%22)&env=store://datatables.org/alltableswithkeys");
	
	private final String url;
	
	Urls (String url){
		this.url = url;
	}

	public String getCommand() {
		return url;
	}
	
	
}
