// https://leetcode.com/problems/clone-graph/ 
// 133. Clone Graph
class Solution {
    public Node dfs(Node node,Map<Integer,Node>map){
      if(node == null)return node;  
      if(map.containsKey(node.val))return map.get(node.val);
      
      Node copyNode = new Node(node.val);
      map.put(copyNode.val,copyNode);  
      for(Node n:node.neighbors)
          copyNode.neighbors.add(dfs(n,map));
      return  copyNode; 
    }
    public Node cloneGraph(Node node) {
        return dfs(node,new HashMap<Integer,Node>());
    }
}