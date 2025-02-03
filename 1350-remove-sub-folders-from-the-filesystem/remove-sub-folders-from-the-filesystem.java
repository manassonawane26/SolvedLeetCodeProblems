class Solution {
    List<String> ans;
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(a,b)->a.length()-b.length());
        TrieNode root = new TrieNode();
        for(String s: folder)
            addToTrie(s,root);
        ans = new ArrayList();
        trieTraversal(root,"");
        return ans;
    }
    void trieTraversal(TrieNode root,String s)
    {
        if(root.flag)
            ans.add(s);
        
        int childSize = root.child.size();
        for(String key: root.child.keySet())
        {
            if(root.child.containsKey(key))
            {
                System.out.println(key);
                trieTraversal(root.child.get(key),s+"/"+key);
            
            }
        }
    }
    void addToTrie(String s, TrieNode root)
    {
        TrieNode temp = root;
        String[] stringArray = s.split("/");
        for(String c: stringArray)
        {
            if(c.equals("")) continue;
            if(!temp.child.containsKey(c))
                temp.child.put(c,new TrieNode());
            if(temp.child.get(c).flag)
                return;
            temp=temp.child.get(c);
        }
        temp.flag=true;
    }
    class TrieNode
    {
        Map<String,TrieNode> child;
        boolean flag;
        TrieNode()
        {
            child = new HashMap();
            flag = false;
        }

    }
}
