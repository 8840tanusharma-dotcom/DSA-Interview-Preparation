class Solution {
    public int scoreOfParentheses(String s) {
      int score =0;
      int result = 0;
      for(int i=0;i<s.length();++i){
        if(s.charAt(i)== '('){
            ++result;
        }else{
            --result;
        
        if(s.charAt(i-1) == '('){
            score += 1 << result;
        }
        }
      }
      
      return score;
    }
}