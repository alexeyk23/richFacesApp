/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.relex.practice.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alex
 */
@ManagedBean
public class UserBeanList implements Serializable   {
    private List<UserBean> users = new ArrayList<UserBean>();

    public List<UserBean> getUsers() {
        loadUsers();
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
    public void loadUsers()
    {
        try {
                Class.forName("org.postgresql.Driver");            
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
         EntityManagerFactory emf= Persistence.createEntityManagerFactory("manager");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query createNamedQuery = em.createNamedQuery("SELECT \"USER_ID\", \"NAME\", \"SURNAME\", \"MAIL\", \"DATAREG\", \"DIVISION_ID\"  FROM \"USER\"");
        List resultList = createNamedQuery.getResultList();
        setUsers(resultList);    
        em.getTransaction().commit();
        em.close();
    }
    }
