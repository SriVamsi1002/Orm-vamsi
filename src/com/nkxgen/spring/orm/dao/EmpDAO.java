package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Employee;

@Component
public class EmpDAO {

	@PersistenceContext
	private EntityManager em;

	public void persist(Employee emp) {
		em.persist(emp);
	}

	public List<Employee> getAllEmployees() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}

	public boolean delete(Employee e) {
		Employee employee = em.find(Employee.class, e.getEmpNo());
		if (employee != null) {
			em.remove(employee);
			return true;
		} else {
			return false;
		}
	}
}
