class Pair{
    int val;
    Set<Pair> neighboors;

    public Pair(int val){
        this.val = val;
        this.neighboors = new HashSet<>();
    }
}

class Graph {

    private static Map<Integer,Pair> map;

    public Graph() {
        this.map = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!map.containsKey(src)) map.put(src, new Pair(src));
        if(!map.containsKey(dst)) map.put(dst, new Pair(dst));
        Pair x = map.get(src);
        Pair y = map.get(dst);
        x.neighboors.add(y);
        //y.neighboors.add(x);
    }

    public boolean removeEdge(int src, int dst) {
        if(!map.containsKey(src) || !map.containsKey(dst)) return false;
        Pair x = map.get(src);
        Pair y = map.get(dst);
        x.neighboors.remove(y);
        y.neighboors.remove(x);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        if (!map.containsKey(src) || !map.containsKey(dst)) return false;
        return dfs(map.get(src), map.get(dst), new HashSet<>());
    }

    private boolean dfs(Pair node, Pair target, Set<Pair> visit) {
        if (visit.contains(node)) return false;
        if (node == target) return true;

        visit.add(node);

        for (Pair neighbor : node.neighboors) {
            if (dfs(neighbor, target, visit)) {
                return true;
            }
        }

        return false;
    }
}
