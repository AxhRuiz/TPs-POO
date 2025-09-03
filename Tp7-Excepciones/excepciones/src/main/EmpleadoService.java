package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmpleadoService {
	private static List<Empleado> empleados = new ArrayList<Empleado>();

	public static Boolean agregar(Empleado empleado) {
		if (empleado.getNombre() != null && empleado.getSueldo() != null 
				&& empleado.getSueldo() > 0) {
			if(empleado.getLegajo()==null || empleado.getLegajo() <=0) {
				throw new EnteroPositivoException("El legajo del empleado debe ser mayor a 0");
			}
			// agrego el empleado a la Collection
			return empleados.add(empleado);
		}
		return Boolean.FALSE;
	}

	// Devuelve el empleado de mayor sueldo
	public static Empleado mayorSueldo() {
		if(empleados==null) {
			throw new IllegalArgumentException("La lista no puede ser null");
		}
		if(empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados");
		}
		Iterator<Empleado> iterador = empleados.iterator();
		Empleado mayor = iterador.next();
		
		while (iterador.hasNext()) {
			Empleado empleado = iterador.next();
			if (empleado.getSueldo() > mayor.getSueldo()) {
				mayor = empleado;
			}
		}
		return mayor;
	}

	//Devuelve el sueldo promedio
	public static Double sueldoPromedio() {
		if(empleados==null) {
			throw new IllegalArgumentException("La lista no puede ser null");
		}
		if(empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados");
		}
		Double total = 0.0;
		for (Empleado empleado : empleados) {
			total += empleado.getSueldo();
		}
		return total / empleados.size();
	}

	public static void eliminar(String nombre) {
		if(empleados==null) {
			throw new IllegalArgumentException("La lista no puede ser null");
		}
		if(empleados.isEmpty()) {
			throw new CollectionVaciaException("No hay empleados");
		}
		boolean encontrado =false;
		Iterator<Empleado> iterador = empleados.iterator();
		while (iterador.hasNext()) {
			Empleado empl = iterador.next();
			if (empl.getNombre().equalsIgnoreCase(nombre)) {
				iterador.remove();
				encontrado= true;
				break;
			}
		}
		if(!encontrado) {
			throw new NoEncontradoException("No se encontro el empleado");
		}
	}

	public static List<Empleado> getEmpleados() {		
		return empleados;
	}

}
