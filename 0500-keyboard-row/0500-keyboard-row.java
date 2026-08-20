class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();

            int row = -1;

            for (int i = 0; i < 3; i++) {
                if (rows[i].indexOf(w.charAt(0)) != -1) {
                    row = i;
                    break;
                }
            }

            boolean valid = true;

            for (char c : w.toCharArray()) {
                if (rows[row].indexOf(c) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                ans.add(word);
        }

        return ans.toArray(new String[0]);
    }
}