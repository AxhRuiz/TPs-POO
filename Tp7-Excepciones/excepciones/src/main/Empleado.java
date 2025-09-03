package main;

public class Empleado {
	private String nombre;
	private Integer sueldo;
	private Integer legajo;
	
	public Empleado() {
		super();
	}
	public Empleado(String nombre, Integer sueldo, Integer legajo) {
		setNombre(nombre);
		setSueldo(sueldo);
		setLegajo(legajo);
	}
	public Empleado(String nombre) {
		
		setNombre(nombre);
	}
	public Empleado(Integer sueldo) {
		
		setSueldo(sueldo);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null || nombre.trim().length()<3) {
			throw new StringException("El empleado debe tener 3 o mas caracteres");
		}
		this.nombre= nombre;
	}
	public Integer getSueldo() {
		return sueldo;
	}
	public void setSueldo(Integer sueldo) {
		if(sueldo == null ||sueldo <=0) {
			throw new EnteroPositivoException("El sueldo del empleado debe ser mayor a 0");
		}
		this.sueldo=sueldo;
	}
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		if(legajo == null || legajo <=0) {
			throw new EnteroPositivoException("El legajo del empleado debe ser mayor a 0");
		}
		
		this.legajo=legajo;
	}
	
	@Override
	public String toString() {
		return (this.getNombre()+ " Sueldo: "+ this.getSueldo()+ " "+ this.getLegajo());
	}

}
