package algo3.algothief;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Grafo<T,K> {
	
	HashMap<T, HashMap<T, K>> vertices;

	public Grafo(){
		
		vertices = new HashMap<T, HashMap<T, K>>();
	}
	
	boolean agregarVertice(T vertice){
		if (vertices.containsKey(vertice)) return false;
		vertices.put(vertice, new HashMap<T, K>());
		return true;
	}
	
	void borrarVertice(T vertice){
		Collection<HashMap<T, K>> lista = vertices.values();
		for(HashMap<T, K> unVertice  : lista){
			unVertice.remove(vertice);
		}
		vertices.remove(vertice);
	}
	
	boolean agregarArista(T vertice, T otroVertice, K peso){
		if(vertices.containsKey(vertice)&&(vertices.containsKey(otroVertice))){
			(vertices.get(vertice)).put(otroVertice, peso);
			(vertices.get(otroVertice)).put(vertice, peso);
			return true;
		}
		return false;
	}
	
	void borrarArista(T vertice, T otroVertice){
		(vertices.get(vertice)).remove(otroVertice);
		(vertices.get(otroVertice)).remove(vertice);
	}
	
	Set<T> listarAristas(T vertice){
		return ((vertices.get(vertice)).keySet());
	}
	
	K obtenerPeso(T vertice, T otroVertice){
		return((vertices.get(vertice)).get(otroVertice));
	}
	
	int size(){
		return(vertices.size());
	}
}


