public class Edge implements Comparable<Edge> {

    private vertex src;
    private vertex dest;
    private double weight;

    /* Creates an Edge (SRC, DEST) with edge weight WEIGHT. */
    Edge(vertex src, vertex dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    /* Returns the edge's source node. */
    public vertex getSource() {
        return src;
    }

    /* Returns the edge's destination node. */
    public vertex getDest() {
        return dest;
    }

    /* Returns the weight of the edge. */
    public double getWeight() {
        return weight;
    }

    public int compareTo(Edge other) {
        double cmp =  weight - other.weight;
        if(cmp > 0){
            return 1;
        }
        else if(cmp == 0)
            return 0;
        else
            return -1;
        //return cmp == 0 ? 1 : cmp;
    }

    /* Returns true if two Edges have the same source, destination, and
       weight. */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge e = (Edge) o;
        return (src == e.src && dest == e.dest && weight == e.weight)
                || (src == e.dest && dest == e.src && weight == e.weight);
    }

    /* Returns the hashcode for this instance.
    public int hashCode() {
        int hash = src ^ (src >>> 32);
        hash = 31 * hash + dest ^ (dest >>> 32);
        hash = 31 * hash + weight ^ (weight >>> 32);
        return hash;
    }
    */

    /* Returns the string representation of an edge. */
    public String toString() {
        return "{" + src + ", " + dest + "} -> " + weight;
    }
}

