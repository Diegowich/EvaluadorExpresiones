import java.util.Stack;

public class EvaluadorPostfijo {

   public static int solucionarTermino(String expresion){

        Stack<Integer> pila = new Stack<>();        // Pila nueva inicializada

        int resultado = 0;                          // Variable de resultado donde se almacenaran los resultados de las operaciones
        for(char c:expresion.toCharArray()){        // Itera los objetos de un arreglo hecho con la expresion ingresada en la funcion
            if (Character.isDigit(c)){              // si se encuentra un digito se debe meter dentro de la pila
                pila.push(c - '0');             // pasamos de char a int con c - '0'
            }
            else {
                if(pila.size()>= 2){                // Si no se encuentra un operando, es que ha encontrado un operador
                    int operando2 = pila.pop();        // Contamos con que en notacion postfija, si se ha encontrado con un operador, ya hemos encontrado antes dos operandos que se han metido ya a la pila
                    int operando1 = pila.pop();        // asi que se sacan y se meten en dos variables

                    switch(c){
                        case '+' ->  resultado = operando1 + operando2;
                        case '-' ->  resultado = operando1 - operando2;             // Segun el tipo de operador que se ha encontrado el iterador se hara la operacion
                        case '*' -> resultado = operando1 * operando2;              // y el resultado se guardara en la variable " resultado "
                        case '/' -> {
                            if(operando2 == 0){
                                throw new ArithmeticException("No se puede dividir por 0");
                            }
                            else
                                resultado = resultado / operando2;
                        }

                        default -> throw new IllegalArgumentException("Operador inválido: " + c); // Si se encuentra un operador diferente se envia un mensaje de error
                    }
                }   pila.push(resultado);    // el resultado dentro de la variable resultado se añade a la pila

            }
        }
        if(pila.size() != 1){       // Al finalizar solo debe quedar dentro de la pila el resultado de la operacion entera
            throw new IllegalArgumentException("Expresion prefija inválida."); // Si quedan mas de dos items dentro de la pila se muestra un mensaje de error
        }
        return pila.pop(); // Al finalizar, retorna el unico valor que debe haber dentro de la pila, el resultado de la operacion postfija
   }
}

