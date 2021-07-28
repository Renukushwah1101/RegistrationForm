package com.renu.hibernate.DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.renu.hibernate.entity.Files;

public class FilesDAO {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Files.class)
			.buildSessionFactory();

	
	public void addFileDetails(Files file) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		System.out.println(" Got added");
	}
	
	public List<Files> resultout() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Files> files =  session.createQuery("from file").getResultList();
		//session.getTransaction().commit();	
		return files;
	}
	public Files getFile(int fileId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
	Files file	=session.get(Files.class, fileId);
		session.getTransaction().commit();
		
		return file;
	}
	
	public void deleteFile(int fileId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Files file=session.get(Files.class, fileId);
		
	session.delete(file);
		session.getTransaction().commit();
		
	}
	public List<Files> result(int fileId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from file where id= :fileId");
		query.setParameter("fileId", fileId);
		List<Files> files = query.list();
		return files;
	}
	
	public void updateDetails(int id,String userid,String name ,String file,String gender,String address ,String city,String pin ,String state,String email,String Con  )
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Files files=session.get(Files.class,id);
		files.setUserid(userid);
		files.setName(name);
		files.setFile(file);
		files.setGender(gender);
		files.setAddress(address);
		files.setCity(city);
		files.setPin(pin);
		files.setState(state);
		files.setEmail(email);
		files.setContact(Con);
		session.getTransaction().commit();
	}
}
