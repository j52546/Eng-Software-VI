package br.edu.univas;

import java.util.List;

public class App {

	public static void main(String[] args) {
		FlightDAO flightDAO = new FlightDAO();
		List<Flight> flights = flightDAO.getAll();
		FlightAdapter adapter = new FlightAdapterImpl(flightDAO);
		
		for (Flight flight : flights) {
			System.out.println(flight);
		}
		
		for (Flight flight : adapter.getAll()) {
			System.out.println(flight);
		}
		
		
		/* 
		 * Valor: 5 pontos
		 * Data Entrega: 19/09/2019
		 * Como Entregar: Subir o código para o Github do aluno e enviar o link do Github para o email: rodrigolfsi@gmail.com
		 * Descrição:
		 * Um segundo cliente apareceu para nossa aplicação. Mas esse cliente gostaria de saber as horas do voo no fuso horário
		 * de Los Angeles - EUA. Atualmente a aplicação entrega os horarios dos voos no fuso horário de São Paulo.
		 * Utilizando algum design pattern aprendido, altere a aplicação, sem mexer nas classes FlightDAO e Fligh, para 
		 * atender esse novo cliente.
		 */
	}
}

