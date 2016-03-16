package com.suddenlyjune.financialinvestment.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suddenlyjune.financialinvestment.dao.Stock;
import com.suddenlyjune.financialinvestment.dao.StockDao;
import com.suddenlyjune.financialinvestment.utility.JsonReader;


@Service
public class StockService {
private StockDao stockDao;
	
	@Autowired
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}


	public void create(Stock stock) {
		stockDao.insertStock(stock);
		
	}
	public List<Stock> getCurrent(){
		return stockDao.getStocks();
		
	}
/*	public void buyStocks(String name, double price, int quantity, int userid){
		List<Stock> userstock = (List<Stock>) stockDao.getStock(name);
		boolean flag = true;
		for(Stock stocks: userstock){
			if(stocks.getUserid() == userid){
				flag = false;
				stocks.setQuantity(quantity+stocks.getQuantity());
				stockDao.insertStock(stocks);
				break;
			}
			
		}
		
		
		
	}*/
/*	
	public List<Stock> getStocks(String name) throws JSONException, IOException{
		@SuppressWarnings("unchecked")
		List<Stock> stock = (List<Stock>) stockDao.getStock(name);
		for(Stock stocks : stock){	
			JSONObject json = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:"+stocks.getName());
			System.out.println(json.get("l"));
			double price = Double.parseDouble((String) json.get("l"));
			stocks.setPrice(price);;
			stocks.setTotalPrice(price * stocks.getQuantity() ); 
		}
		
		return stock;
	}*/
}
