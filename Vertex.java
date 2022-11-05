import java.util.*;

public class Vertex {

    private String id;
    private ArrayList<String> adjacencies = new ArrayList<>();
    private boolean visited = false;
    private String color = null;

    public Vertex(String id) {

        this.id = id;

    }

    public String getId() {

        return id;

    }

    public ArrayList<String> getAdjacencies() {

        return adjacencies;

    }

    public boolean getVisited() {

        return visited;

    }

    public String getColor() {

        return color;

    }

    public void setVisited(boolean visited) {

        this.visited = visited;

    }

    public void setColor(String color) {

        this.color = color;

    }

}