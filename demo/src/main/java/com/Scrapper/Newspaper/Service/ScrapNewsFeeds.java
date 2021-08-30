package com.Scrapper.Newspaper.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Scrapper.Newspaper.Bean.NewsDetails;
import com.Scrapper.Newspaper.Bean.NewsFeedDetails;
import com.Scrapper.Newspaper.Repository.NewsDetailsRepository;
import com.Scrapper.Newspaper.Repository.NewsFeedDetailsRepository;

@Component
public class ScrapNewsFeeds {
		
	@Autowired
	NewsDetailsRepository newsDetailsRepository;
	@Autowired
	NewsFeedDetailsRepository newsFeedDetailsRepository;
	
	
	public void Scrapping() {
	ArrayList<String> news = new ArrayList<String>();
	List<NewsDetails> links = newsDetailsRepository.findAll();
	String temp = "";
	String temp2;
	String temp3;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date(); 
	
	for(NewsDetails link : links ) {
		
	System.out.println("Link : " + link.getUrl() + "Organization : " + link.getOrganization());
	Document page;
	NewsFeedDetails newsFeedDetails = new NewsFeedDetails();
		try {
			page = Jsoup.connect(link.getUrl()).get();
		
			Elements pageElements = page.select("a[href]");
				for (Element e:pageElements) {
		
					news.add(e.text());
					//hyperLinks.add("Link: " + e.attr("href"));
				}
		
				for (String s : news) {
					temp2 = temp + s;
					temp = temp2;
				}
				newsFeedDetails.setNewsPaperId(link.getId());
				newsFeedDetails.setDate(formatter.format(date));
				newsFeedDetails.setData(temp);
				newsFeedDetailsRepository.save(newsFeedDetails);
				System.out.println("Data fetch completed...");
				
			} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	 }
	}
}