class Solution {
    public String[] createGrid(int m, int n) {
       List<String> grid = new ArrayList<>();
       for(int i=0;i<m;i++){
        char[] row = new char[n];
        Arrays.fill(row, '#');
        if(i == 0){
            Arrays.fill(row, '.');
        }else{
            row[n-1] = '.';
        }
        grid.add(new String(row));
       }
       return grid.toArray(new String[0]);
    }
}