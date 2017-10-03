/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akarte.dao.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author GLAVNI
 */
public class DB {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RezervacijaAvioKarataPU");

    public static List query(String jpql, Map<String, Object> params) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery(jpql);
            for(Entry<String, Object> e:params.entrySet()){
                query.setParameter(e.getKey(), e.getValue());
            }
            List results = query.getResultList();
            return results;
        } finally {
            if(em!=null)
               em.close();
        }
        
    }
    public static List query(String jpql, Object... params) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery(jpql);
            for(int i= 0; i<params.length; i++){
                query.setParameter(i+1, params[i]);
            }
            List results = query.getResultList();
            return results;
        } finally {
            if(em!=null)
               em.close();
        }
        
    }
    
    public static void insert(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } finally {
            if(em!=null)
               em.close();
        }
        
    }
    
    public static void update(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } finally {
            if(em!=null)
               em.close();
        }
        
    }
    
    public static void delete(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(obj));
            em.getTransaction().commit();
        } finally {
            if(em!=null)
               em.close();
        }
        
    }
    
    /*public static void delete(Integer id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Osoba osoba = em.getReference(Osoba.class, id);
            em.remove(osoba);
            em.getTransaction().commit();
        } finally {
            if(em!=null)
               em.close();
        }*/
        
    }
    




