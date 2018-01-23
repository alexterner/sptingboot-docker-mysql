package com.company.springboot.docker.mysql.service;


import com.company.springboot.docker.mysql.dal.entity.Site;
import com.company.springboot.docker.mysql.dal.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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


    @Transactional(readOnly = true)
    public Iterable<Site> getSites(int page, int size){
        return siteRepository.findAll(new PageRequest(page, size));
    }


    @Transactional
    public Site addSite(boolean isActive, String name){
        return siteRepository.save(new Site( isActive, name));
    }

    @Transactional(readOnly = true)
    public Iterable<Site> getActiveSites(){
        return siteRepository.getActiveSites();
    }


    @Transactional(readOnly = true)
    public Iterable<Site> getActiveSites(int page, int size){
        return siteRepository.findByIsActive(true, new PageRequest( page, size ));
    }


    @Transactional(readOnly = true)
    public Iterable<Site> getBySearchTerm(String searchTerm) {
        return siteRepository.getBySearch(searchTerm);
    }
}
