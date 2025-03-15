import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Convertidor de expresion Infija a Postfija ***");       // Imprime el titulo del programa
        Scanner sc = new Scanner(System.in); // metodo de entrada por consola
        System.out.print("Ingresa una expresion algebraica en notacion infija: ");
        String expresionInfija = sc.nextLine();                 // Se pide una expresion algebraica en notacion infija, recibida en formato String

        while(!VerificadorParentesis.verificar(expresionInfija)){           // Si el verificador de parentesis retorna los parentesis no estan balanceados
            System.out.print("La expresion no esta balanceada. Ingresa una expresion balanceada: ");
            expresionInfija = sc.nextLine();                                // entra en un bucle hasta que se ingrese una expresion balanceada
        }

        var expresionPostfija = InfijaAPostfija.conversionPostfija(expresionInfija);        // se convierte la expresion infija a postfija y se guarda en una variable
        var resultado = EvaluadorPostfijo.solucionarTermino(expresionPostfija);             // Esta variable se ingresa en el evaluador de terminos postfijos y se guarda el resultado en la variable " resultado "
        System.out.printf("""
                %nExpresion Infija = %s
                Expresion Postfija = %s
                Resultado de la expresion = %d
                """,expresionInfija,expresionPostfija,resultado);                       // Se imprime el resultado de las conversiones y el resultado de la expresion algebraica
    }
}
