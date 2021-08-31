
package com.Scrapper.Newspaper.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Scrapper.Newspaper.Bean.NewsDetails;
import com.Scrapper.Newspaper.Repository.NewsDetailsRepository;
import com.Scrapper.Newspaper.Service.ScrapNewsFeeds;

@Controller
public class NewsController {

	@Autowired
	NewsDetailsRepository NewsDetailsRepository;
	@Autowired
	ScrapNewsFeeds scrapNewsFeeds;
	
	@RequestMapping("/")
	public String login() {
	
		return "AddNewsLink.html";
	}
	@RequestMapping("/Test")
	public String Test() {
		
		scrapNewsFeeds.Scrapping();
		//return "GlobalDataVisualization.html";
		return "Test.html";
	}
	@RequestMapping("/GlobalDataVisualization")
	public String GlobalDataVisualization() {
		
		return "GlobalDataVisualization.html";
	}
	
	@RequestMapping(value="/AddUrl", method = RequestMethod.GET)
	public String GetNewsFeedUrl(@RequestParam String addNewsUrl, @RequestParam String orgName, Model model) {
		
		//System.out.println("URL : " + addNewsUrl);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	      
		
		NewsDetails newsDetails = new NewsDetails();
		newsDetails.setUrl(addNewsUrl);
		newsDetails.setDate(formatter.format(date));
		newsDetails.setOrganization(orgName);
		
		NewsDetailsRepository.save(newsDetails);
		
		model.addAttribute("Status", "Successful");
		return "AddNewsLink.html";
	}
	
	
}
