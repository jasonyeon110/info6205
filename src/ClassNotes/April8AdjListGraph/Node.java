package ClassNotes.April8AdjListGraph;

import java.util.LinkedList;

public class Node {
    public String name;
    public boolean visited;
    public LinkedList<Edge> listEdges;
    public Node parent;
    public int rank;

    public String cameFrom = "";
    public int distance = Integer.MAX_VALUE;

    public Node(String name) {
        this.name = name.toUpperCase();
        this.visited = false;
        this.listEdges = new LinkedList<Edge>();
        this.parent = this;
        this.rank = 0;
    }

    public void addEdge(String endNode, int weight){
        endNode = endNode.toUpperCase();
        for (Edge edge: listEdges) {
            if(edge.endNode == endNode){
                return;
            }
        }

        Edge edge = new Edge(name, endNode, weight);
        listEdges.add(edge);
    }

    public void deleteEdge(String endNode){
        endNode = endNode.toUpperCase();
        for (Edge edge: listEdges) {
            if(edge.endNode == endNode){
                listEdges.remove(edge);
                return;
            }
        }
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }


    public LinkedList<String> getNeighbours(){
        LinkedList<String> list = new LinkedList<>();
        for (Edge edge: listEdges) {
            list.add(edge.endNode);
        }
        return list;
    }


}
