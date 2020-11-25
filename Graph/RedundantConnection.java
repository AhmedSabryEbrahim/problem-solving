//https://leetcode.com/problems/redundant-connection
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length);
        for(int i=0;i<edges.length;i++){
           if(dsu.find(edges[i][0])==dsu.find(edges[i][1]))return edges[i];
             dsu.union(edges[i][1],edges[i][0]);
        }
        return null;
    }
}

class DSU {
    int []parent;
    public DSU(int N) {
        parent=new int [N+1];
        for(int i=0;i<=N;i++)parent[i]=i;
    }
    public int find(int x) {
        return (x==parent[x])?parent[x]:find(parent[x]);
    }
    public void union(int x,int y) {
        parent[find(x)]=find(y);
    }
   public boolean isRoot(int x) {
        return (find(x)==x);
    }
}