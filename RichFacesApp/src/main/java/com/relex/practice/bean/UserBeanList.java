/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.relex.practice.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        Query createNamedQuery = em.createNativeQuery("SELECT \"USER_ID\", \"NAME\", \"SURNAME\", \"MAIL\", \"DATAREG\"  FROM \"USER\"");
        List resultList = createNamedQuery.getResultList();
        Iterator a = resultList.iterator();
        users.clear();
            while (a.hasNext()) 
            {
             Object[] arr = (Object[])a.next();
              UserBean user = new UserBean();
              user.setId((Integer)arr[0]);
              user.setName((String)arr[1]);
              user.setSurname((String)arr[2]);
              user.setEmail((String)arr[3]);
              user.setDate((Date)arr[4]);
              users.add(user);              
            }  
            
        em.getTransaction().commit();
        em.close();
    }
    }
