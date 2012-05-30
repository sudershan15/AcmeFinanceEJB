package com.foo.Stocks;

import javax.ejb.Stateless;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foo.Stocks.Stocks;
/**
 * Session Bean implementation class StockProvider
 */
@Stateless
public class StockProvider implements StockProviderRemote, StockProviderLocal {
	@PersistenceContext(unitName="stocksdata") // This is the entity manager required by the Entity bean
	private EntityManager em;
     
    public StockProvider() {
         

}
    @Override
	public List<Stocks> getStocks(String symbol) {
		
		// Example for using named query
		Query getStocksBySymbol = em.createNamedQuery("findStocksBySymbol");
		getStocksBySymbol.setParameter("symbol", symbol);
		List<Stocks> stocks = getStocksBySymbol.getResultList();
		return stocks;
	}

	@Override
	public List<Stocks> getStocksByDateRange(String symbol, String startDate, String endDate) {
		// You can also create a query if the named query is not defined
		
		System.out.println("before create query");
		Query getStocksByDateRange = em.createNamedQuery("findStocksByDateRange");
		System.out.println("after create query");
		
		getStocksByDateRange.setParameter("symbol", symbol);
		getStocksByDateRange.setParameter("startDate", startDate);
		getStocksByDateRange.setParameter("endDate", endDate);
		List<Stocks> stocks = getStocksByDateRange.getResultList();
		return stocks;
	}
	
	@Override
	public List<Stocks> getStocksByDate(String date) {
		// You can also create a query if the named query is not defined
		
		System.out.println("before create query");
		Query getStocksByDate = em.createNamedQuery("findStocksByDate");
		System.out.println("after create query");
		
		getStocksByDate.setParameter("date", date);
		List<Stocks> stocks = getStocksByDate.getResultList();
		return stocks;
	}
	
	@Override
	public List<Stocks> getTopStocksByCap(String date) {
		// You can also create a query if the named query is not defined
		
		System.out.println("before create query");
		Query getTopStocksByCap = em.createNamedQuery("findTopStocksByCap");
		System.out.println("after create query");
		
		getTopStocksByCap.setParameter("date", date);
		List<Stocks> stocks = getTopStocksByCap.getResultList();
		return stocks;
	}
}
