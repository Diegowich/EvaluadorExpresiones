import java.util.Stack;

public class InfijaAPostfija {

    public static boolean esOperador(char terminoInfijo) {
        return "+-*/^()".indexOf(terminoInfijo) != -1;
    }

    public static int prioridad(char operador) {
        return switch (operador) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String conversionPostfija(String terminoInfijo) {
        StringBuilder terminoConvertido = new StringBuilder();  // Se construye el espacio donde se ira creando el termino postfijo
        Stack<String> pila = new Stack<>();                     // Se crea la pila

        for (char c : terminoInfijo.toCharArray()) {        // Recorre cada caracter de un arreglo hecho con los operandos y operadores del termino en notacion infija
            if (Character.isDigit(c)) {
                terminoConvertido.append(c);                // Si encuentra un numero, lo añade al termino postfijo
            } else if (c == '(') {
                pila.push("(");                         // Si encuentra un "(" lo añade
            } else if (c == ')') {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {       // Si se encuentra ")" y la pila no esta vacia, saca todos los items
                    terminoConvertido.append(pila.pop());                   // que hay en la pila y los añade al termino postfijo
                }
                pila.pop(); // Elimina el '('
            } else if (esOperador(c)) {
                while (!pila.isEmpty() && prioridad(pila.peek().charAt(0)) >= prioridad(c)) {
                    terminoConvertido.append(pila.pop());                                       // Si se encuentra un operador, mientras que la pila no esta vacia
                }                                                                               // y la prioridad del operador ultimo operador que hay en la pila
                pila.push(String.valueOf(c));                                                   // es mayor o igual que la prioridad del operador que se ha encontrado
            }                                                                                   // se vaciaran los terminos y se colocaran dentro del termino postfijo
        }                                                                                        // Despues de esto, apila dentro de la pila el operador que se ha encontrado

        while (!pila.isEmpty()) {
            terminoConvertido.append(pila.pop());  // Tras la verificacion entera, añade al termino postfijo los items que queden dentro de la pila
        }

        return terminoConvertido.toString();       // Retorna el termino convertido en postfijo
    }

}
