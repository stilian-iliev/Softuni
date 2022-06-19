package workingWithAbstraction.jediGalaxy;

public class Matrix {
    private int[][] matrix;
    private int collectedStars;

    public int[][] fill(int x, int y) {
        int value = 0;
        int[][] matrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        this.matrix = matrix;
        return matrix;
    }

    public void destroy(int[] evilCoordinates) {
        int evilX = evilCoordinates[0];
        int evilY = evilCoordinates[1];

        while (evilX >= 0 && evilY >= 0) {
            if (inBounds(evilX, evilY, matrix)) matrix[evilX][evilY] = 0;
            evilX--;
            evilY--;
        }
    }

    private boolean inBounds(int evilX, int evilY, int[][] matrix) {
        return evilX >= 0 && evilX < matrix.length && evilY >= 0 && evilY < matrix[evilX].length;
    }

    public void collectStars(int[] ivoCoordinates) {
        int ivoX = ivoCoordinates[0];
        int ivoY = ivoCoordinates[1];

        while (ivoX >= 0 && ivoY < matrix[0].length) {
            if (inBounds(ivoX, ivoY, matrix)) collectedStars += matrix[ivoX][ivoY];
            ivoX--;
            ivoY++;
        }
    }

    public int getCollectedStars() {
        return collectedStars;
    }
}
