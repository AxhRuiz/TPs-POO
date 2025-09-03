package empleado;

public class empleado {
	private String nombre;
	private Integer sueldo;
	private Integer legajo;
	
	public empleado() {
		super();
	}
	public empleado(String nombre, Integer sueldo, Integer legajo) {
		super();
		this.nombre= nombre;
		this.sueldo=sueldo;
		this.legajo=legajo;
	}
	public empleado(String nombre) {
		super();
		this.nombre=nombre;
	}
	public empleado(Integer sueldo) {
		super();
		this.sueldo= sueldo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new NullPointerException("Error: El nombre no puede ser null");
		}
		if(nombre.length() <3 ) {
			throw new IllegalArgumentException("Error: El nombre del empleado debe tener 3 o mas caracteres");
		}
		if(nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("Error: El nombre no puede ser vacio");
		}
		this.nombre= nombre;
	}
	public String getSueldoString() {
		return ("$"+sueldo);
	}
	public void setSueldo(Integer sueldo) {
		if(sueldo == null) {
			throw new NullPointerException("Error: El sueldo del empleado debe ser mayor a 0");
		}
		 if (sueldo <= 0) {
			 throw new IllegalArgumentException("Error: El sueldo del empleado debe ser mayor a 0");
		 }
		 this.sueldo=sueldo;
	}
	public String getLegajoString() {
		return ("Numero de legajo: "+legajo);
	}
	public void setLegajo(Integer legajo) {
		if(legajo == null) {
			throw new NullPointerException("Error: El legajo del empleado debe ser mayor a 0");
		}
		if(legajo <=0){
			throw new IllegalArgumentException("Error: el legajo del empleado debe ser mayor a 0");
		}
		this.legajo=legajo;
	}
	
	@Override
	public String toString() {
		return (this.getNombre()+ " Sueldo: "+ this.getSueldoString()+ this.getLegajoString());
	}
	
}
