package com.company.springboot.docker.mysql.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/sites")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SiteController {

    private final Logger log = LoggerFactory.getLogger(SiteController.class);

    private static final int DEFAULT_PAGE_SIZE = 10;


}
