package com.hcl.demo.m02.d09.jpademo.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hcl.demo.m02.d09.jpademo.entity.Student;

public class DBUtil {

	static final String PERSISTENCE_UNIT = "demo-persistence-unit";
	
	private static EntityManagerFactory factory;
	
    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }


	public static void insert(Student s) {

		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public static Student getOne(Integer id) {

		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		Student s = em.find(Student.class, id);
		em.getTransaction().commit();
		em.close();
		return s;
	}
	
	public static List<Student> getAll() {
		
		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		
		Query q = em.createQuery("select s from student s");
		List<Student> students = q.getResultList();
		em.getTransaction().commit();
		em.close();
		return students;
	}

	public static void update(int id, Student updatedStudent) {

		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		
		Student oldStudent= em.find(Student.class, id);
		oldStudent.setFirstName(updatedStudent.getFirstName());
		oldStudent.setLastName(updatedStudent.getLastName());
		oldStudent.setEmail(updatedStudent.getEmail());
	
		em.getTransaction().commit();
		em.close();
	}

	public static void delete(int id) {

		EntityManager em = getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		Student s = em.find(Student.class, id);
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}

}
