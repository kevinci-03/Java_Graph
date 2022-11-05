import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Testing {

    @Test
    public void test1() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v1", "v3", "v1", "v4", "v1", "v5", "v6", "v7", "v7", "v9", "v9", "v8", "v8", "v6"));
        ArrayList<String> actual = new ArrayList<>(Arrays.asList("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9"));
        Graph graph = new Graph(vertices);
        assertEquals(graph.listVertices(), actual);
    }

    @Test
    public void test2() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v2", "v3", "v3", "v1", "v4", "v6", "v4", "v7", "v4", "v8"));
        var actual = new ArrayList<>(Arrays.asList("v1", "v2", "v3", "v4", "v6", "v7", "v8"));
        var graph = new Graph(vertices);
        assertEquals(graph.listVertices(), actual);
    }

    @Test
    public void test3() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v1", "v3", "v1", "v4", "v1", "v5", "v6", "v7", "v7", "v9", "v9", "v8", "v8", "v6"));
        var graph = new Graph(vertices);
        assertEquals(graph.getVertex("v1").getId(), "v1");
        assertEquals(graph.getVertex("v10"), null);
    }

    @Test
    public void test4() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v1", "v3", "v1", "v4", "v1", "v5", "v6", "v7", "v7", "v9", "v9", "v8", "v8", "v6"));
        var graph = new Graph(vertices);
        var adj1 = new ArrayList<>(Arrays.asList("v2", "v3", "v4", "v5", "v6"));
        var adj2 = new ArrayList<>(Arrays.asList("v7", "v8", "v1"));
        graph.addEdge("v1", "v6");
        assertEquals(graph.getVertex("v1").getAdjacencies(), adj1);
        assertEquals(graph.getVertex("v6").getAdjacencies(), adj2);
    }

    @Test
    public void test5() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v1", "v3", "v1", "v4", "v1", "v5", "v6", "v7", "v7", "v9", "v9", "v8", "v8", "v6"));
        var graph = new Graph(vertices);
        var vert = new Vertex("v10");
        assertNull(graph.addVertex("v1"));
        graph.addVertex("v10");
        assertEquals(vert.getId(), graph.getVertex("v10").getId()); 
    }

    @Test
    public void test6() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v1", "v3", "v1", "v4", "v1", "v5", "v6", "v7", "v7", "v9", "v9", "v8", "v8", "v6"));
        var graph = new Graph(vertices);
        var comp = new ArrayList<ArrayList<String>>();
        comp.add(new ArrayList<>(Arrays.asList("v1", "v2", "v3", "v4", "v5")));
        comp.add(new ArrayList<>(Arrays.asList("v6", "v7", "v8", "v9")));
        assertEquals(graph.connectedComponents(), comp);
        assertTrue(graph.is_bipartite());
    }

    @Test
    public void test7() {
        var vertices = new ArrayList<>(Arrays.asList("v1", "v2", "v2", "v3", "v3", "v1", "v4", "v6", "v4", "v7", "v4", "v8"));
        var graph = new Graph(vertices);
        var comp = new ArrayList<ArrayList<String>>();
        comp.add(new ArrayList<>(Arrays.asList("v1", "v2", "v3")));
        comp.add(new ArrayList<>(Arrays.asList("v4", "v6", "v7", "v8")));
        assertEquals(graph.connectedComponents(), comp);
        assertFalse(graph.is_bipartite());
    }

}