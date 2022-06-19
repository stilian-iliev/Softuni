public class OnlyPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String common = "";
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) shortest = s;
        }
        String longestMatch = "";
        String curr = "";
        for (int i = 0; i<shortest.length(); i++) {
            curr += shortest.charAt(i);
            boolean allContains = true;
            for(String s: strs) {
                if (!(s.charAt(i) == shortest.charAt(i))) allContains = false;
            }

            if(!allContains) {
                return longestMatch;
            } else if(longestMatch.length() < curr.length()){
                longestMatch = curr;
            }

        }
        return longestMatch;
    }
}
