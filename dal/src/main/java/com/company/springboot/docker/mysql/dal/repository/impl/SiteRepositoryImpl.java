package com.company.springboot.docker.mysql.dal.repository.impl;


import com.company.springboot.docker.mysql.dal.entity.Site;

import com.company.springboot.docker.mysql.dal.repository.custom.SiteRepositoryCustom;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class SiteRepositoryImpl implements SiteRepositoryCustom {

   // private static final QSite Q_SITE = QSite.sitesDbRecord;

    @Override
    public List<Site> getActiveSites() {
        return null;
    }

    @Override
    public Iterable<Site> getBySearch(String searchTerm) {
        return null;
    }

    /*private static final QSite Q_SITE = QSite.sitesDbRecord;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Site> getActiveSites() {
        return new JPAQuery(entityManager)
                .from(Q_SITE)
                .where(isActiveSites())
                .list(Q_SITE);
    }

    private BooleanExpression isActiveSites() {
        return Q_SITE.isActive.isNotNull().and(Q_SITE.isActive.eq(Boolean.TRUE));
    }

    @Override
    public Iterable<Site> getBySearch(String searchTerm) {
        return new JPAQuery(entityManager)
                .from(Q_SITE)
                .where(isActiveSites(), Q_SITE.name.toUpperCase().contains(searchTerm.toUpperCase()))
                .list(Q_SITE);
    }*/

}
