/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.relex.practice.bean;

import com.relex.practice.pojo.User;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
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
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;
    private  String surname;
    private String email;
    private  Date date;
    
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
    
    public void addUser()
    {
        User usr= new User();
        usr.setName(name);
        usr.setSurname(surname);
        usr.setMail(email);
        usr.setData(date);
        //usr.setDivision(null);
        try {
                Class.forName("org.postgresql.Driver");            
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("manager");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usr);
        em.getTransaction().commit();
        em.close();
       //  FacesContext.getCurrentInstance().addMessage("OK!", new FacesMessage("AHA"));
    }
}
