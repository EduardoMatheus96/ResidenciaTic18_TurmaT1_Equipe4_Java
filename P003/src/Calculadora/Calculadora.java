package Calculadora;

public class Calculadora {


	public static float  soma(float numero1, float numero2) {
		return (numero1 + numero2);
	}
	
	public static float  subtracao(float numero1, float numero2) {
		return (numero1 - numero2);
	}
	
		public static float multiplicacao(float numero1, float numero2) {
		return (numero1 * numero2);
		
	}
	public static float dividir(float numero1, float numero2) throws DivisionByZeroException {
        if (numero2 == 0) {
            throw new DivisionByZeroException("Divisão por zero não permitida.");
        }
        return numero1 / numero2;
    }
	public static void main(String[] args) {
		try {
			float num1 = 100;
			float num2 = 0;
			float resultado = dividir(num1, num2);
			System.out.println(num1 + " / " + num2 + " = " + resultado);
		} catch (DivisionByZeroException e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}
