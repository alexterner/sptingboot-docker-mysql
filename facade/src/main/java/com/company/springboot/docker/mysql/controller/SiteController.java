package com.company.springboot.docker.mysql.controller;


import com.company.springboot.docker.mysql.dal.entity.Site;
import com.company.springboot.docker.mysql.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
@RequestMapping("/sites")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SiteController {

    private final Logger log = LoggerFactory.getLogger(SiteController.class);

    private static final int DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private SiteService siteService;


    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<Iterable<Site>> getActiveSites() {

        Iterable<Site> sites = null;
        try {
            sites = siteService.getSites();
        } catch (Exception e) {
            log.error("Failed get sites", e);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>( sites , HttpStatus.OK);
    }


    @ResponseBody
    @RequestMapping(value = "/isActive/{isActive}/name/{name}", method = RequestMethod.POST)
    public ResponseEntity<Site> addSite(@PathVariable(value = "isActive") boolean isActive,  @PathVariable("name") String name) {

        try {

            return new ResponseEntity<>(  siteService.addSite(isActive, name), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Failed to add site with name" + name, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
