public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            int j = (int) Math.round( (Math.log(n)/Math.log(i)));
            if (Math.pow(i,j) == n) return new int[]{i, j};

        }
        return null;
    }
}