
package post;
import javax.swing.JLabel;


/**
 *
 * @author godie007
 */
public class NotacionPostFicaPrefija {
 public void analizar(String entrada,JLabel salida,JLabel Infija,JLabel Postfija) {

    
    //Depurar la expresion algebraica
    String expr = depurar(entrada);
    String[] arrayInfix = expr.split(" ");

    //Declaración de las pilas
    PilaEnlazada E = new PilaEnlazada(); //Pila entrada
    PilaEnlazada P = new PilaEnlazada(); //Pila temporal para operadores
    PilaEnlazada S = new PilaEnlazada(); //Pila salida

    //Añadir la array a la Pila de entrada (E)
    for (int i = arrayInfix.length - 1; i >= 0; i--) {
      E.push(arrayInfix[i]);
    }

    try {
      //Algoritmo Infijo a Postfijo
      while (!E.isEmpty()) {
        switch (pref((String) E.peek())){
          case 1:
            P.push(E.pop());
            break;
          case 3:
          case 4:
            while(pref((String) P.peek()) >= pref((String) E.peek())) {
              S.push(P.pop());
            }
            P.push(E.pop());
            break; 
          case 2:
            while(!P.peek().equals("(")) {
              S.push(P.pop());
            }
            P.pop();
            E.pop();
            break; 
          default:
            S.push(E.pop()); 
        } 
      } 

      //Eliminacion de `impurezas´ en la expresiones algebraicas
      String infix = expr.replace(" ", "");
      String postfix = S.toString().replaceAll("[\\]\\[,]", "");

      //Mostrar resultados:
      Infija.setText("Expresion Infija: " + infix);
      Postfija.setText("Expresion Postfija: " + postfix);

    }catch(Exception ex){ 
      salida.setText("Error en la expresión algebraica");
    }
  } 

  //Depurar expresión algebraica
  private static String depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    s = "(" + s + ")";
    String simbols = "+-*/()";
    String str = "";
  
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

  //Jerarquia de los operadores
  private static int pref(String op) {
    int prf = 99;
    if (op.equals("^")) prf = 5;
    if (op.equals("*") || op.equals("/")) prf = 4;
    if (op.equals("+") || op.equals("-")) prf = 3;
    if (op.equals(")")) prf = 2;
    if (op.equals("(")) prf = 1;
    return prf;
  }
}