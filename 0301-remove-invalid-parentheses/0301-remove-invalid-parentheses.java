class Solution {
    private Set<String> result = new HashSet<>();
    private int minRemoved;
    public List<String> removeInvalidParentheses(String s) {
        minRemoved = Integer.MAX_VALUE;
        dfs(s,0,new StringBuilder(),0,0,0);
        return new ArrayList<>(result);
    }
    private void dfs(String s, int index, StringBuilder path, int open, int close, int removed){
        if(index == s.length()){
            if(open == close){
                if(removed < minRemoved){
                    result.clear();
                    minRemoved = removed;
                }
                if(removed == minRemoved){
                    result.add(path.toString());
                }
            }
            return ;
        }
        char c = s.charAt(index);
        int len = path.length();
        if(c == '('){
            dfs(s, index+1, path, open, close, removed+1);
            path.append(c);
            dfs(s, index+1, path, open+1, close, removed);
            path.setLength(len);
        }else if(c == ')'){
            dfs(s, index+1, path, open, close, removed+1);
            if(open > close){
                path.append(c);
                dfs(s, index+1, path, open, close+1, removed);
                path.setLength(len);
            }
        }else{
            path.append(c);
            dfs(s,index+1, path, open, close, removed);
            path.setLength(len);
        }
    }
}