package hibernate_demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_demo.dto.User;

public class UserCrud{
	EntityManager em = Persistence.createEntityManagerFactory("arvind").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
	}
	
	public List<User> fetchAll(){
		Query query = em.createQuery("select a from User a where a.name Like '%a'");
		List li = query.getResultList();
		return li;
	}
}
