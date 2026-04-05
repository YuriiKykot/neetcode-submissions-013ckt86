public class TreeNode{
    HashMap<Character, TreeNode> children = new HashMap<>();
    boolean end = false;
}

class WordDictionary {
    private TreeNode root;
    

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c,new TreeNode());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(root,word.toCharArray(),0);
    }

    public boolean dfs(TreeNode root, char[] arr, int i){
        if(i >= arr.length){
            if(root.end){
                return true;
            }else{
                return false;
            }
        }

        char a = arr[i];

        if(a != '.' && !root.children.containsKey(a)) return false;

        if(i == arr.length && root.end) return true;

        boolean res = false;
        i++;
        if(a != '.'){
            res = dfs(root.children.get(a),arr,i);
        }else{
            for(TreeNode n : root.children.values()){
                if(dfs(n,arr,i)) return true;
            }
        }

        return res;
    }
}
