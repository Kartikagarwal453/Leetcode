class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int[] temp = new int[n];
        int c = 0;
        int i = n-1;
        int j = m-1;
        while(i>=0){
            if(j>=0 && w1.charAt(i) == w2.charAt(j)){
                c++;
                j--;
            }
            temp[i] = c;
            i--;
        }

        int[] ans = new int[m];
        boolean pow = true;

        int p = 0;
        i=0;
        j=0;
        while(i<n && j<m){
            if(w1.charAt(i) == w2.charAt(j)){
                ans[p] = i;
                p++;
                j++;
            }
            else if(pow == true && i+1 < n && temp[i+1] >= m-j-1){
                ans[p] = i;
                p++;
                j++;
                pow = false;
            }
            i++;
        }
        return (j==m ? ans : new int[0]);
    }
}