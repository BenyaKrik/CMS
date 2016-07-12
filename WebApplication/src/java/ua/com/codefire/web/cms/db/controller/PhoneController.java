/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.cms.db.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import ua.com.codefire.web.cms.db.entity.Brand;

/**
 *
 * @author user
 */
public class PhoneController {

    private static EntityManagerFactory factory;

    public synchronized static EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("MainPU");
        }

        return factory;
    }

    public List<Brand> getAll() {
        EntityManager manager = getFactory().createEntityManager();

        try {
            TypedQuery<Brand> query = manager.createQuery("SELECT p FROM Phone p", Brand.class);
            List<Brand> phoneList = query.getResultList();
            return phoneList;
        } finally {
            manager.close();
        }
    }
}
