public class Prefix {
    public static String longestCommonPrefix(String[] strs) {
        String common = "";
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) shortest = s;
        }
        String longestMatch = "";
        String curr = "";
        for (int i = 0; i<shortest.length(); i++) {
            for(int j = i; j<shortest.length(); j++){
                curr += shortest.charAt(i);
                boolean allContains = true;
                for(String s: strs) {
                    if (!s.contains(curr)) allContains = false;
                }

                if(!allContains) {
                    curr = "";
                    break;
                } else if(longestMatch.length() < curr.length()){
                    longestMatch = curr;
                }
            }

        }
        return longestMatch;
    }
}
