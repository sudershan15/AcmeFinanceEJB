package com.foo.Stocks;

 
	/**
	 * This bean represents the Stocks entity
	 * Contains information of a stock
	 *
	 */

 

	import java.io.Serializable;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
import javax.persistence.Table;


	@Entity
	@Table(name = "stocks")
	@NamedQueries({
			@NamedQuery(name = "findStocksBySymbol", query = "SELECT s from Stocks s WHERE s.symbol = :symbol")})
	public class Stocks implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		public Stocks() {
			
		}
		
		public Stocks(Long sId, String date, String symbol, float open, float high, float low, float close, Long cap) {
			this.sId = sId;
			this.date = date;
			this.symbol = symbol;
			this.open = open;
			this.close = close;
			this.high = high;
			this.low = low;
			this.cap = cap;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)	
		protected Long sId;

		public Long getSId() {
			return sId;
		}

		public void setSId(Long sId) {
			this.sId = sId;
		}

		@Column(nullable = false)
		protected String date;
		
		@Column(nullable = false)
		protected String symbol;
		
		@Column(nullable = false)
		protected float open;
		
		@Column(nullable = false)
		protected float high;
		
		@Column(nullable = false)
		protected float low;
		
		@Column(nullable = false)
		protected float close;
		
		@Column(nullable = false)
		protected Long cap;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public float getOpen() {
			return open;
		}

		public void setOpen(float open) {
			this.open = open;
		}

		public float getHigh() {
			return high;
		}

		public void setHigh(float high) {
			this.high = high;
		}

		public float getLow() {
			return low;
		}

		public void setLow(float low) {
			this.low = low;
		}

		public float getClose() {
			return close;
		}

		public void setClose(float close) {
			this.close = close;
		}
		
		public Long getCap() {
			return cap;
		}

		public void setCap(Long cap) {
			this.cap = cap;
		}
		
		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
	}


