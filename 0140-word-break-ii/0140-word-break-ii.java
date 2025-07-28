class Solution {
    class Trie{
        Trie child[] = new Trie[26];
        boolean isEnd;

        Trie(){
            isEnd = false;
        }
    }

    Trie root = new Trie();
    public List<String> wordBreak(String s, List<String> wordDict) {
        insertBegin(s);

        List<String> ans = new ArrayList<>();
        helper(root,wordDict,new ArrayList<>(),ans);

        return ans;
    }
    public void insertBegin(String s){
        Trie node = root;
        int n = s.length();

        for(int i=0;i<n;i++){
            int idx = s.charAt(i)-'a';

            if(node.child[idx] == null){
                node.child[idx] = new Trie();
            }
            node = node.child[idx];
        }
        node.isEnd = true;
    }
    public void helper(Trie node,List<String> word,List<String> path,List<String> ans){
        if(node.isEnd){
            StringBuffer sb = new StringBuffer();
            for(String s : path) sb.append(s).append(" ");
            sb.deleteCharAt(sb.length()-1);

            ans.add(sb.toString());
            return;
        }

        for(String s : word){
            Trie temp = node;
            boolean flag = true;
            
            for(int i=0;i<s.length();i++){
                int idx = s.charAt(i)-'a';
                if(temp.child[idx] == null){
                    flag = false;
                    break;
                }
                temp = temp.child[idx];
            }

            if(flag){
                path.add(s);
                helper(temp,word,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
}