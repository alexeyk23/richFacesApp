/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.relex.practice.bean;

import com.relex.practice.pojo.User;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alex
 */
public class UserBean 
{
    public void addUser(String name, String surname,String email,Date date)
    {
        User usr= new User();
        usr.setName(name);
        usr.setSurname(surname);
        usr.setMail(email);
        usr.setData(date);
        usr.setDivision(null);
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("manager");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usr);
        em.getTransaction().commit();
        em.close();
    }
}
