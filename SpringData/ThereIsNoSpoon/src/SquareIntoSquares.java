public class SquareIntoSquares {
    public static String decompose(long n) {

        for (long i = n - 1;i > 1;i--){
            long squareRem = n * n; // n^2
            StringBuilder stringBuilder = new StringBuilder();

            for (long j = i; j > 0; j--) {

                if (j * j < squareRem){
                    stringBuilder.insert(0, " " + j);

                    squareRem -= j * j;
                }else if (j * j == squareRem){
                    stringBuilder.insert(0,j);
                    return stringBuilder.toString();
                }
            }
        }

        return null;
    }
}
