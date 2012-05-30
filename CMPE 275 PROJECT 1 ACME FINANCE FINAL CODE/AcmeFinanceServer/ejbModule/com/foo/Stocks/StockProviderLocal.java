package com.foo.Stocks;
import java.util.List;

import javax.ejb.Local;
import java.util.*;

@Local
public interface StockProviderLocal {
	public List<Stocks> getStocks(String symbol);
	public List<Stocks> getStocksByDateRange(String symbol, String startDate, String endDate);
	public List<Stocks> getStocksByDate(String date);
	public List<Stocks> getTopStocksByCap(String date);
}
