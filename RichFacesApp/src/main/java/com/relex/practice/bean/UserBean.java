/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.relex.practice.bean;

import com.relex.practice.pojo.User;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alex
 */

@ManagedBean
public class UserBean implements Serializable  
{
    private String name;
    private  String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   private String email;
  private  Date date;
    public void addUser()
    {
        User usr= new User();
        usr.setName(name);
        usr.setSurname(surname);
        usr.setMail(email);
        usr.setData(date);
        //usr.setDivision(null);
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Class.forName("org.postgresql.Driver");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("manager");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usr);
        em.getTransaction().commit();
        em.close();
         FacesContext.getCurrentInstance().addMessage("OK!", new FacesMessage("AHA"));
    }
}
