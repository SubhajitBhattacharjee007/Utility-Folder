package com.Scrapper.Newspaper.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.Scrapper.Newspaper.Bean.NewsDetails;

public interface NewsDetailsRepository extends JpaRepository<NewsDetails, Integer>{

}
