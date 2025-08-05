class WordDictionary {
    class Trie{
        Trie child[] = new Trie[26];
        boolean isEnd;
        Trie(){
            this.isEnd = false;
        }
    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.child[c-'a'] == null){
                node.child[c-'a'] = new Trie();
            }
            node = node.child[c-'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return helper(0,word,root);
    }
    public boolean helper(int idx,String word,Trie node){
        if(idx == word.length()){
            return node.isEnd;
        }
        boolean ans = false;
        char ch = word.charAt(idx);

        if(ch == '.'){
            for(char c='a';c<='z';c++){
                if(node.child[c-'a'] == null) continue;
                ans = ans | helper(idx+1,word,node.child[c-'a']);
            }
        }
        else{
            if(node.child[ch-'a'] == null) return false;
            else{
                ans = ans | helper(idx+1,word,node.child[ch-'a']);
            }
        }
        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */