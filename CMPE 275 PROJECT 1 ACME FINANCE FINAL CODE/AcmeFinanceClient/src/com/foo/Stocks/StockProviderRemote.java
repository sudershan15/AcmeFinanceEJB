package com.foo.Stocks;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface StockProviderRemote {
	public List<Stocks> getStocks(String symbol);
	public List<Stocks> getStocksByDateRange(String symbol, String startDate, String endDate);
	public List<Stocks> getStocksByDate(String date);
	public List<Stocks> getTopStocksByCap(String date);
}
