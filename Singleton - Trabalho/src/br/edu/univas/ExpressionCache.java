package br.edu.univas;

import java.util.HashMap;
import java.util.Map;

public class ExpressionCache {

	private static ExpressionCache instance;
	
	private Map<String, Double> cache;
	
	private ExpressionCache() {
		cache = new HashMap();
	}
	
	public static ExpressionCache getInstance() {
		if (instance == null) {
			instance = new ExpressionCache();
		}
		return instance;
	}
	
	
	public void add(String expression, Double result) {
		cache.put(expression, result);
	}
	
	public Double get(String expression) {
		return cache.get(expression);
	}
	
}
