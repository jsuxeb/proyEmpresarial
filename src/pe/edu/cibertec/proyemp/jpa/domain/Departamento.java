package pe.edu.cibertec.proyemp.jpa.domain;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue
	@Column(name="DEP_ID",nullable= false,unique=true)
	private Long id;
	
	@Column(name="DEP_NOMBRE",nullable= false)
	private String nombre;
	
	@Column(name="DEP_CAPACIDAD",nullable=true)
	private Integer capacidad;
	
	@Column(name="dep_estado",nullable= true,columnDefinition="char(1)")
	private String estado;

	
	
	

	
	
	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Departamento(){}
	
	
	//@OneToMany(mappedBy="departamento",cascade=CascadeType.PERSIST)
	@OneToMany(mappedBy="departamento", cascade =CascadeType.PERSIST)
	private List<Empleado> empleados = 
			new ArrayList<Empleado>();

	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	

	
	
}
