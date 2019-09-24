package br.edu.univas;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class App {

	/* 
	 * Valor: 5 pontos
	 * Data Entrega: 23/09/2019
	 * Como Entregar: Subir o c�digo para o Github do aluno e enviar o link do Github para o email: rodrigolfsi@gmail.com
	 * Descri��o:
	 * Foi desenvolvido uma aplica��o para resolver equa��es matem�ticas simples. Essa aplica��o funciona da seguinte forma:
	 * Ao rodar a aplica��o o usu�rio ir� digitar uma equa��o, como por exemplo "10+3-2*5", e ao clicar no "ENTER" a 
	 * aplica��o ir� imprimir o resultado.
	 * A aplica��o s� ir� parar quando o usu�rio digitar somente "-1".
	 * Pensando em performance, foi desenvolvido um esquema de cache e ele est� funcionando bem para a aplica��o.
	 * O problema a ser resolvido �: e se tivermos mais de uma parte do mesmo sistema acessando esse cache?
	 * Utilizando algum padr�o de projeto estudado em sala, altere o programa para que o cache seje unico para todo o sistema.
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("JavaScript");

		ExpressionCache cache = ExpressionCache.getInstance();		

		try {
			while (true) {
				String expression = scanner.nextLine();

				if (expression.equals("-1")) {
					break;
				}
				
				Double doubleResult = cache.get(expression);
				
				if (doubleResult == null) {
					Object result = engine.eval(expression);
					
					if (result instanceof Integer) {
						Integer aux = (Integer) result;
						doubleResult = aux.doubleValue();
					} else if (result instanceof Double) {
						doubleResult = (Double) result;
					}
					
					cache.add(expression, doubleResult);
				}
				System.out.println(doubleResult);					
				
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye Bye!");
		scanner.close();
	}
}
