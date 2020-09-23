package tutorialJava.capitulo1;

public class Ejemplo05_OperadoresANivelDeBits {

	public static void main(String[] args) {
	    // Declaraci�n de variables enteras, e inicializaci�n de las mismas.
	    // Llamamos "inicializaci�n de la variable" a la primera vez que
	    // esa variable toma un valor cualquiera en un operador de asignaci�n.
	    // En la siguiente l�nea de c�digo, se han declarado e inicializado
	    // dos variables.
	    // Por favor, recuerda el significado de "inicializaci�n de variable",
	    // es muy importante y muy utilizado entre programadores.
	    int entero1 = 30, entero2 = 3;

	    // Operaci�n l�gica AND. Esta operaci�n, al igual que todas las de
	    // este ejercicio, actua a nivel de los bits que forman el valor
	    // contenido dentro de la variable. En concreto, en este ejemplo,
	    // intervienen el "entero1" toma el valor 30, que presentado en 
	    // binario es 11110, y el "entero2" que toma el valor 3, que en
	    // binario es 00011.
	    // Al aplicar la operaci�n l�gica AND, el resultado en binario
	    // queda 00010, que corresponde al n�mero 2 en decimal.
	    System.out.println("Operaci�n l�gica AND: " + (entero1 & entero2));
	    
	    // Operaci�n l�gica OR. Al igual que antes, partimos del valor
	    // 11110 (30) y del valor 00011 (3). Al aplicar la operaci�n OR,
	    // queda el valor 11111 (31). El car�cter "|" se obtiene con la
	    // combinaci�n de "Alt Gr + 1".
	    System.out.println("\nOperaci�n l�gica OR: " + (entero1 | entero2));
	    
	    // Operaci�n l�gica NOT. Esta operaci�n cambia todos los bits
	    // del valor sobre el que actua. El operador NOT tambi�n es
	    // llamado "complemento a uno". 
	    // En DevC, se utilizan 4 Bytes para representar cada entero,
	    // por tanto, ya que 1 Byte = 8 bits, se utilizan 32 bits para
	    // cada valor definido como "int". De esta forma, el valor 30
	    // estar� representado como:
	    //        00000000 00000000 00000000 00011110
	    // Al negar quedar�:
	    //        11111111 11111111 11111111 11000001
	    // 
	    // En C, los n�meros enteros pueden ser positivos o negativos.
	    // El signo positivo o negativo de un n�mero viene dado por el
	    // bit que tiene situado a su izquierda, de manera que un valor
	    // 0 (cero) indica un n�mero positivo, y un valor 1 (uno) indica
	    // un n�mero negativo. 
	    // Sin embargo, a la hora de imprimir, podemos utilizar el forma-
	    // teador %u, que viene de la palabra "unsigned". Es decir, mos-
	    // mostrar� el valor contenido en la variable sin tener en cuenta
	    // que el bit de la izquierda indique un signo o no. De hecho, al
	    // imprimir en forma "unsigned", no podr�n existir los n�meros
	    // negativos.
	    // Para escribir en pantalla el s�mbolo "~", si tienes un teclado
	    // configurado como "Espa�ol Tradicional", podr�s utilizar la 
	    // combinaci�n "Alt gr + 4", y deber�s pulsar el cuatro un par de
	    // veces.
	    System.out.println("\nOperaci�n l�gica NOT: " + ~entero1);

	    // Operaci�n l�gica XOR. Para escribir en pantalla el s�mbolo "^", 
	    // si tienes un teclado configurado como "Espa�ol Tradicional", 
	    // podr�s utilizar la combinaci�n "May�sculas + `" (tecla situada
	    // a la izquierda del s�mbolo "+", y deber�s pulsar el ` un par de
	    // veces.
	    System.out.println("\nOperaci�n l�gica XOR: " + (entero1 ^ entero2));
	    
	    // Operaci�n de desplazamiento de bits. Si representamos el valor
	    // 30 de la siguiente forma:
	    //       00000000 00000000 00000000 00011110
	    // y desplazamos la "tira de bits" un lugar a la izquierda, ahora
	    // se representar� el valor:
	    //       00000000 00000000 00000000 00111100, que corresponde al
	    // valor 60, es decir, hemos multiplicado el n�mero por 2.
	    // Sin embargo, si en lugar de desplazar a la izquierda, se 
	    // desplaza a la derecha, el valor obtenido ser�:
	    //       00000000 00000000 00000000 00001111, que corresponde al 
	    // valor decimal 15, es decir, se ha dividido entre 2.
	    // Para desplazar, se utilizan los operadores << y >>. De manera que
	    // la expresi�n:   entero2 << 1, quiere decir que se desplacen un 
	    // lugar a la izquierda los bits de entero2. De esta forma, la 
	    // expresi�n: entero2 >> 2, quiere decir que se desplacen dos lugares
	    // a la derecha los bits de entero2.
	    System.out.println("\nOperaci�n de desplazamiento izquierda: " + (entero2 << 1));
	    System.out.println("\nOperaci�n de desplazamiento derecha: " + (entero1 >> 2));

	}

}
