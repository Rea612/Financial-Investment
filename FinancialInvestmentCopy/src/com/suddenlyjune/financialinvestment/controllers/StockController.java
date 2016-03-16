package com.suddenlyjune.financialinvestment.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suddenlyjune.financialinvestment.dao.Stock;
import com.suddenlyjune.financialinvestment.dao.StockDao;
import com.suddenlyjune.financialinvestment.dao.User;
import com.suddenlyjune.financialinvestment.dao.UserDAO;
import com.suddenlyjune.financialinvestment.service.StockService;
import com.suddenlyjune.financialinvestment.utility.JsonReader;

@Controller
public class StockController {

	@Autowired
	UserDAO userDao;
	@Autowired
	StockService stockService;
	@Autowired
	StockDao stockDao;

	@Autowired
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	@RequestMapping(value = "/viewStock", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req) throws JSONException, IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		model.addAttribute("username", username);
		User user = userDao.getUser(username);
		req.getSession().setAttribute("username", user.getUsername());

		// weather
		JSONObject json = JsonReader.readJsonFromUrl(
				"http://api.openweathermap.org/data/2.5/weather?zip=95117,us&APPID=15354182ae016e1be98cf7fafc4348b1");
		double temp = (Double) ((JSONObject) json.get("main")).get("temp");
		temp = (((temp - 273) * 9 / 5) + 32);
		temp = Double.parseDouble(String.format("%.1f", temp));
		model.addAttribute("temp", temp);
		String location = (String) json.get("name");
		model.addAttribute("location", location);
		int humidity = (Integer) ((JSONObject) json.get("main")).get("humidity");
		model.addAttribute("humidity", humidity);
		double wind = (Double) ((JSONObject) json.get("wind")).get("speed");
		model.addAttribute("wind", wind);
		String weather = (String) ((JSONObject) ((JSONArray) json.get("weather")).get(0)).get("main");
		model.addAttribute("weather", weather);

		// stock
		model.addAttribute("stock", stockService.getCurrent());

		return "viewStock";
	}

	@RequestMapping(value ="/addstock", method = RequestMethod.GET)
	public String viewStock(Locale locale, Model model, HttpServletRequest req) throws JSONException, IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		model.addAttribute("username", username);
		User user = userDao.getUser(username);
		req.getSession().setAttribute("username", user.getUsername());

		// List of Stock
	
		JSONObject json1 = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:MSFT");
		JSONObject json2 = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:FB"); 
		JSONObject json3 = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:AAPL"); 
		JSONObject json4 = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:TSLA"); 
		JSONObject json5 = JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:GOOG"); 
		JSONObject json6 =	JsonReader.readJsonFromUrl2("http://finance.google.com/finance/info?client=ig&q=NASDAQ:BABA");

		double price1 = Double.parseDouble((String) json1.get("l"));
		model.addAttribute("price1", price1);
		String name1 = (String) json1.get("t");
		model.addAttribute("name1", name1);
		double price2 = Double.parseDouble((String) json2.get("l"));
		model.addAttribute("price2", price2);
		String name2 = (String) json2.get("t");
		model.addAttribute("name2", name2);
		double price3 = Double.parseDouble((String) json3.get("l"));
		model.addAttribute("price3", price3);
		String name3 = (String) json3.get("t");
		model.addAttribute("name3", name3);
		double price4 = Double.parseDouble((String) json4.get("l"));
		model.addAttribute("price4", price4);
		String name4 = (String) json4.get("t");
		model.addAttribute("name4", name4);
		double price5 = Double.parseDouble((String) json5.get("l"));
		model.addAttribute("price5", price5);
		String name5 = (String) json5.get("t");
		model.addAttribute("name5", name5);
		double price6 = Double.parseDouble((String) json6.get("l"));
		model.addAttribute("price6", price6);
		String name6 = (String) json6.get("t");
		model.addAttribute("name6", name6);

		return "addstock";
	}
	/*@RequestMapping(value="/addStock", method = RequestMethod.POST)
	public String addStock(Stock stock, BindingResult result) {
		if (result.hasErrors()){
			return "addstock";
		}
		else {
			return "viewstock";
		}
		}*/
		
	
	

}
