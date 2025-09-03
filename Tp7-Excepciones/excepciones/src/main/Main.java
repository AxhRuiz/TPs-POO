package main;



public class Main {

	public static void main(String[] args) {
		 System.out.println("=== PRUEBAS EMPLEADO SERVICE ===\n");
	        
	        // Caso 1: Agregar empleados válidos
	        System.out.println("1. AGREGAR EMPLEADOS VÁLIDOS:");
	        try {
	            Empleado emp1 = new Empleado("Ana García", 50000, 101);
	            Empleado emp2 = new Empleado("Juan Pérez", 75000, 102);
	            Empleado emp3 = new Empleado("María López", 60000, 103);
	            
	            System.out.println("Agregando Ana: " + EmpleadoService.agregar(emp1));
	            System.out.println("Agregando Juan: " + EmpleadoService.agregar(emp2));
	            System.out.println("Agregando María: " + EmpleadoService.agregar(emp3));
	            
	            System.out.println("Empleados en lista: " + EmpleadoService.getEmpleados().size());
	            
	        } catch (Exception e) {
	            System.out.println("Error inesperado: " + e.getMessage());
	        }

	        // Caso 2: Intentar agregar empleado con legajo inválido
	        System.out.println("\n2. AGREGAR EMPLEADO CON LEGAJO INVÁLIDO:");
	        try {
	            Empleado empInvalido = new Empleado("Pedro Malo", 40000, -5);
	            EmpleadoService.agregar(empInvalido);
	            System.out.println("Empleado agregado (no debería pasar)");
	        } catch (EnteroPositivoException e) {
	            System.out.println("✅ Correcto: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Caso 3: Obtener mayor sueldo
	        System.out.println("\n3. OBTENER EMPLEADO CON MAYOR SUELDO:");
	        try {
	            Empleado mayor = EmpleadoService.mayorSueldo();
	            System.out.println("Empleado con mayor sueldo: " + mayor.getNombre() + 
	                             " - Sueldo: $" + mayor.getSueldo());
	        } catch (CollectionVaciaException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Caso 4: Calcular sueldo promedio
	        System.out.println("\n4. CALCULAR SUELDO PROMEDIO:");
	        try {
	            Double promedio = EmpleadoService.sueldoPromedio();
	            System.out.println("Sueldo promedio: $" + promedio);
	        } catch (CollectionVaciaException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Caso 5: Eliminar empleado existente
	        System.out.println("\n5. ELIMINAR EMPLEADO EXISTENTE:");
	        try {
	            EmpleadoService.eliminar("juan pérez"); // Case insensitive
	            System.out.println("Juan eliminado correctamente");
	            System.out.println("Empleados restantes: " + EmpleadoService.getEmpleados().size());
	        } catch (NoEncontradoException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Caso 6: Intentar eliminar empleado inexistente
	        System.out.println("\n6. INTENTAR ELIMINAR EMPLEADO INEXISTENTE:");
	        try {
	            EmpleadoService.eliminar("Pedro Fantasma");
	            System.out.println("Empleado eliminado (no debería pasar)");
	        } catch (NoEncontradoException e) {
	            System.out.println("✅ Correcto: " + e.getMessage());
	        }

	        // Caso 7: Probar con lista vacía
	        System.out.println("\n7. PROBAR CON LISTA VACÍA:");
	        try {
	            // Limpiar lista
	            EmpleadoService.getEmpleados().clear();
	            EmpleadoService.mayorSueldo(); // Debe lanzar excepción
	        } catch (CollectionVaciaException e) {
	            System.out.println("✅ Correcto: " + e.getMessage());
	        }

	      

	        System.out.println("\n=== PRUEBAS COMPLETADAS ===");
	    }

}
