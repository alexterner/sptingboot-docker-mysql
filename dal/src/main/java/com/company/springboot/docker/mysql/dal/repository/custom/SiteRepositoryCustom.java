package com.company.springboot.docker.mysql.dal.repository.custom;

import com.company.springboot.docker.mysql.dal.entity.Site;

import java.util.List;

public interface SiteRepositoryCustom {

    List<Site> getActiveSites();

    Iterable<Site> getBySearch(String searchTerm);
}
