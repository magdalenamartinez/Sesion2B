package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	float ventasMes = 1100;
	float horasExtra = 6;
	float nominaBruta = 2300;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
	}

	@Test
	void testCalculoNominaBruta_vendedor() {
		float expected = 2280;
		float actual = Empleado.calculoNominaBruta( TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBruta_encargado() {
		float expected = 2780;
		float actual = Empleado.calculoNominaBruta( TipoEmpleado.Encargado, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	
	@Test
	void testCalculoNominaBruta_ventassnegativas() {
		ventasMes = -5;
		float expected = -1;
		float actual = Empleado.calculoNominaBruta(TipoEmpleado.Encargado, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBruta_ventas0_1000() {
		ventasMes = 500;
		float expected = 2180;
		float actual = Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBruta_ventas1000_1500() {
		float expected = 2280;
		float actual = Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBruta_ventasmayor1500() {
		ventasMes = 1600;
		float expected = 2380;
		float actual = Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}

	@Test
	void testCalculoNominaBruta_horasextrasnegativas() {
		horasExtra = -2;
		float expected = -1;
		float actual = Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaBruta_horasextraspositivas() {
		float expected = 2280;
		float actual = Empleado.calculoNominaBruta( TipoEmpleado.Vendedor, ventasMes, horasExtra);
		assertEquals(expected, actual);
	}


	@Test
	void testCalculoNominaNetaNegativa() {
		nominaBruta = -100;
		float expected = -1;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMenos2100() {
		nominaBruta = 2000;
		float expected = 2000;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		float expected = 1955;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		nominaBruta = 2600;
		float expected = 2132;
		float actual = Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}

}
