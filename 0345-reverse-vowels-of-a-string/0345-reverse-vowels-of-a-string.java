class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;

        while (i < j) {
            if (!isVowel(ch[i])) {
                i++;
                continue;
            }
            if (!isVowel(ch[j])) {
                j--;
                continue;
            }

            
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++;
            j--;
        }
        return new String(ch);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
