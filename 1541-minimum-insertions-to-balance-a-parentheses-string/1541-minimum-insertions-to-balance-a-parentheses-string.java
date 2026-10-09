class Solution {
    public int minInsertions(String s) {
       int a =0;
       int k =0;
       for(int i =0;i<s.length();i++){
        char c = s.charAt(i);
        if(c == '('){
            a += 2;
            if((a&1) == 1){
                k++;
                a--;
            }
        }else{
            a--;
            if(a<0){
                k++;
                a += 2;
            }
        }
       } 
       return a+k;
    }
}