package com.company.springboot.docker.mysql.dal.repository;


import com.company.springboot.docker.mysql.dal.entity.Site;
import com.company.springboot.docker.mysql.dal.repository.custom.SiteRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends PagingAndSortingRepository<Site, Integer>/*, SiteRepositoryCustom*/{

    List<Site> findByIsActive(boolean isActive, Pageable pageable);
}
