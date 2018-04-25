package com.big.style.barber.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.big.style.barber.dominio.PuestoBarberoDTO;

import config.HibernateUtil;

@ManagedBean
public class PuestoDAO {

	public static List<PuestoBarberoDTO> getPuestos() {
        List<PuestoBarberoDTO> listaPuestos = new ArrayList<PuestoBarberoDTO>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(PuestoBarberoDTO.class);
            listaPuestos = criteria.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.out.println("error");
            session.getTransaction().rollback();
        }
        return listaPuestos;
    }
	
}
