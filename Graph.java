import java.util.*;

public class Graph {

    private LinkedHashMap<String, Vertex> graph;

    public Graph(ArrayList<String> vertices) {

        this.graph = makeGraph(vertices);

    }

    public LinkedHashMap<String, Vertex> makeGraph(ArrayList<String> vertices) {

        LinkedHashMap<String, Vertex> graph = new LinkedHashMap<>();
        for (String vertex : vertices) {
            if (!graph.containsKey(vertex)) {
                graph.put(vertex, new Vertex(vertex));
            }
        }
        for (int i = 0; i < vertices.size(); i = i + 2) {
            graph.get(vertices.get(i)).getAdjacencies().add(vertices.get(i + 1));
            graph.get(vertices.get(i + 1)).getAdjacencies().add(vertices.get(i));
        }
        return graph;

    }

    public LinkedHashMap<String, Vertex> getGraph() {

        return graph;

    }

    public String addVertex(String id) {

        if (graph.containsKey(id)) {
            return null;
        }
        graph.put(id, new Vertex(id));
        return "The vertex has been added";
    }

    public Vertex getVertex(String id) {

        if (graph.containsKey(id)) {
            return graph.get(id);
        }
        return null;

    }

    public void addEdge(String v1, String v2) {

        graph.get(v1).getAdjacencies().add(v2);
        graph.get(v2).getAdjacencies().add(v1);

    }

    public ArrayList<String> listVertices() {

        ArrayList<String> keys = new ArrayList<>();
        for (String vertex : graph.keySet()) {
            keys.add(vertex);
        }
        Collections.sort(keys);
        return keys;

    }

    public ArrayList<ArrayList<String>> connectedComponents() {

        ArrayList<ArrayList<String>> components = new ArrayList<>();
        for (String vertex : graph.keySet()) {
            if (this.graph.get(vertex).getVisited() == false) {
                components.add(dfs(this.graph.get(vertex).getId()));
            }
        }
        return components;

    }

    public ArrayList<String> dfs(String v) {
        
        StackArray<String> dfs_stack = new StackArray<>(this.graph.size());
        ArrayList<String> result_list = new ArrayList<>();
        dfs_stack.push(v);
        this.graph.get(v).setVisited(true);
        while (!dfs_stack.isEmpty()) {
            String vertex = dfs_stack.pop();
            result_list.add(vertex);
            ArrayList<String> adjacent_list = this.graph.get(vertex).getAdjacencies();
            Collections.sort(adjacent_list);
            for (String adjacent : adjacent_list) {
                if (!this.graph.get(adjacent).getVisited()) {
                    dfs_stack.push(adjacent);
                    this.graph.get(adjacent).setVisited(true);
                }
            }
        }
        Collections.sort(result_list);
        return result_list;

    }

    public boolean is_bipartite() {

        for (String vertex : this.graph.keySet()) {
            if (this.graph.get(vertex).getColor() == null) {
                if (!this.bfs(vertex)) {
                    return false;
                }
            }
        }
        return true;

    }
    
    public boolean bfs(String v) {

        QueueArray<String> bfs_queue = new QueueArray<>(100);
        bfs_queue.enqueue(v);
        this.graph.get(v).setColor("Blue");
        while (!bfs_queue.isEmpty()) {
            String vertex = bfs_queue.dequeue();
            ArrayList<String> adjacencies = this.graph.get(vertex).getAdjacencies();
            Collections.sort(adjacencies);
            for (String adjacent : adjacencies) {
                if (this.graph.get(adjacent).getColor() != null && this.graph.get(adjacent).getColor().equals(this.graph.get(vertex).getColor())) {
                    return false;
                }
                else if (this.graph.get(adjacent).getColor() == null) {
                    bfs_queue.enqueue(adjacent);
                    if (this.graph.get(vertex).getColor().equals("Blue")) {
                        this.graph.get(adjacent).setColor("Red");
                    }
                    else {
                        this.graph.get(adjacent).setColor("Blue");
                    }
                }
            }
        }
        return true;

    }

}