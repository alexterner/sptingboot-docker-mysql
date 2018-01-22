package com.company.springboot.docker.mysql.service;


import com.company.springboot.docker.mysql.dal.entity.Site;
import com.company.springboot.docker.mysql.dal.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;


    @Transactional(readOnly = true)
    public Iterable<Site> getSites(){
        return siteRepository.findAll();
    }

}
