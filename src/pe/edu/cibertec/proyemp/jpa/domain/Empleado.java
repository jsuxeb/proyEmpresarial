package pe.edu.cibertec.proyemp.jpa.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.edu.cibertec.proyemp.jpa.listener.EmpleadoListener;


@Entity
@EntityListeners(EmpleadoListener.class)
@Table(name="tb_empleado")

public class Empleado {
	
	@Id
	@GeneratedValue
	@Column(name="EMP_ID",nullable= false,unique=true)
	private Long id;
	
	@Column(name="EMP_NOMBRE", nullable = false, length = 200)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="EMP_DEPARTAMENTO")
	private Departamento departamento;
	
	
	
	@Column(name="EMP_SALARIO", precision=10, scale=2)
	private BigDecimal salario;
	

	@Column(name="EMP_FEC_ING")
	@Temporal(value = TemporalType.DATE)
	private Date fechaIngreso;
	
	/*Tb_empleado	EMP_APELLIDO	varchar (50)
Tb_empleado	EMP_DNI	Varchar, �nico, tama�o 8
/
 * 
 */
	@Column(name="EMP_APELLIDO")
	private String  apellido;
	
	@Column(name="EMP_DNI", columnDefinition="char(8)")
	private String  dni;

	
	
	
	public Empleado(Long id, String nombre, Departamento departamento,
			BigDecimal salario, Date fechaIngreso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
	}

	
	
	public BigDecimal getSalario() {
		return salario;
	}



	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public Empleado(){}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Empleado(String nombre, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}

	
}
