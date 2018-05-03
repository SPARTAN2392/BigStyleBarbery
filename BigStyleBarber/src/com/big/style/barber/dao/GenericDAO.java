package com.big.style.barber.dao;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import config.HibernateUtil;

@SuppressWarnings("unchecked")
@ManagedBean
public class GenericDAO {

	
	public static List<? extends Object> buscarTodos(Class clase) {
        List<? extends Object> lista = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(clase);
            lista = criteria.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.out.println("error");
            session.getTransaction().rollback();
        }
        return lista;
    }
	
	public static List<? extends Object> buscarFiltro(Class clase, Map<String, Object> parametros) {
		 List<? extends Object> lista = null;
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
	        try {
	            session.beginTransaction();
	            Criteria criteria = session.createCriteria(clase);
	            
	            for (Map.Entry<String, Object> entry : parametros.entrySet())
	            {
	            	
	            	if(entry.getValue().getClass().getSimpleName().equals("String")) {
	            		criteria.add(Restrictions.like(entry.getKey(), (String)entry.getValue(), MatchMode.ANYWHERE));
	            	}else {
	            		criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
	            	}
	            	
		            lista = criteria.list();
	            }
	            
	            
	            session.getTransaction().commit();
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	            System.out.println("error");
	            session.getTransaction().rollback();
	        }
	        return lista;
    }
	
	public static void GuardarObjeto(Object poObject) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		try {
			session.beginTransaction();
			session.save(poObject);
			session.getTransaction().commit();
		}catch(Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}
	
}
