package pkg;

public class Empleado {
	
	public enum TipoEmpleado{Vendedor, Encargado};
	
	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtras) {
		float salario = 0;
		if (ventasMes < 0 || horasExtras < 0) {
			return -1;
		}
		if (tipo == TipoEmpleado.Vendedor) {
				salario = 2000;
		} else {
			salario = 2500;
		}
		if (ventasMes >= 1000 && ventasMes < 1500) {
			salario += 100;
		} 
		else if (ventasMes >= 1500) {
			salario += 200;
		}
		salario += (horasExtras * 30);
		return salario;
	}
	
	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;
		if (nominaBruta < 0) {
			return -1;
		}
		if (nominaBruta > 2100 && nominaBruta < 2500) {
			retencion = 0.15f;
		}
		else if (nominaBruta >= 2500) {
			retencion = 0.18f;
		}
		return (nominaBruta * (1 - retencion));
	}

}
