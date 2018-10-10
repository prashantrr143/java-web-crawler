package com.prashant.webcrawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.webcrawler.service.WebCrawlerService;

/**
 * Controller to handle web crawler requests
 * 
 * @author prasingh26
 *
 */

@RestController
@RequestMapping("/crawler")
public class WebCrawlerController {

	@Autowired
	private WebCrawlerService crawlerService;

	private static final Logger LOGGER = LoggerFactory.getLogger(WebCrawlerController.class);

	/**
	 * Method to create a site map
	 * 
	 * @param site
	 * @return
	 */
	@GetMapping(path = "/{site}", produces = MediaType.APPLICATION_XML_VALUE)
	public String createSiteMap(@PathVariable("site") String site) {
		LOGGER.info("Started controller");

		return crawlerService.createXMlSiteMap(site);

	}

}
