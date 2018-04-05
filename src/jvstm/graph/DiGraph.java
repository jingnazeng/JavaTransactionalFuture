
package jvstm.graph;

import java.util.*;

class DiGraph<V> {
	
	static class Edge<V>{
		V to_vertex;
		
		Edge(V v){
			this.to_vertex = v;		
		}
		
	/**
	 * a map is used to map a vertex to its adjacent list
	 * */	
	Map<V,List<Edge<V>>> neighbours = new HashMap<V,List<Edge<V>>>();
	
	 public String toString(){
		StringBuffer s = new StringBuffer();
		for(V v: neighbours.keySet())
			s.append("\n    "+v+" -> "+neighbours.get(v));
		return s.toString();
		
	}
	 
	 
	 /**
	  * add a vertex to the DAG
	  * */
	 public void addVertex(V vertex){
		 if(neighbours.containsKey(vertex))
			 return;
		 neighbours.put(vertex, new ArrayList<Edge<V>>());
	 }
	 
	/**
	 * add a edge to the DAG, from source to destination
	 * */
	 public void addEdge(V source, V destination){
		 this.addVertex(source);
		 this.addVertex(destination);
		 neighbours.get(source).add(new Edge<V>(destination));
	 }
	 
	 public List<V> outboundNeighbors(V vertex){
		 List<V> list = new ArrayList<V>();
		 for(Edge<V> e: neighbours.get(vertex))
			 list.add(e.to_vertex);
		 return list;
	 }
	 
	 public List<V> inboundNeighbours(V vertex){
		 List<V> inList = new ArrayList<V>();
		 for(V from: neighbours.keySet()){
			 for(Edge<V> to: neighbours.get(from)){
				 if(to.to_vertex.equals(vertex))
					 inList.add(from);
			 }
		 }
		 return inList;
	 }
	 
	 public void deleteVertex(V vertex){
		 neighbours.remove(vertex);
		 for(V v: inboundNeighbours(vertex)){
			 neighbours.get(v).remove(vertex);
		 }
		 
	 }
	 
	 public void deleteEdge(V source, V destination){
		 neighbours.get(source).remove(destination);
	 }
	 
	}

}
