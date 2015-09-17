package pe.edu.cibertec.proyemp.jpa.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;
import pe.edu.cibertec.proyemp.jpa.domain.Empleado;

public class JpaTest {
	
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();	
			test.crearEmpleados2();		
			test.modificarDepartamentoID1();
		tx.commit();
		
		test.listarEmpleados();
	}

	private void modificarDepartamentoID1() {
	/*
		
		String jql = "From departamento where id=1";
		
		Departamento dep = manager.createQuery("Select a From Departamento a where d.id = 1",Departamento.class).getSingleResult();
		dep.setNombre(".NET");
		manager.persist(dep);
		
		*/
		
		
	Departamento dep = manager.find(Departamento.class,new Long(1));
	dep.setNombre("PYTHON");
	manager.persist(dep);
	}



	private void crearEmpleados() {
	
		Departamento departamento = new Departamento("Java");
		manager.persist(departamento);

		manager.persist(new Empleado("Bob",departamento));
		manager.persist(new Empleado("Mike",departamento));
		
	}
	
	private void crearEmpleados2() {
		
		Departamento departamento =
				new Departamento("Java");
		
		manager.persist(departamento);
		
		Empleado emp1 = new Empleado("Bob");
		Empleado emp2 = new Empleado("Mike");
		
		
		manager.persist(emp1);
		manager.persist(emp2);
		
		manager.refresh(emp1);
		
		emp1.setNombre("BOBY");

		

	
		
	}
	
	private void listarEmpleados() {
		List<Empleado> resultList =
				manager.createQuery(
						"Select a From Empleado a", 
						Empleado.class).getResultList();
		
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}


}
