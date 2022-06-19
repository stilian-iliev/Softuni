import java.util.Scanner;

public class ThereIsNoSpoon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[][] matrix = new char[width][height];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            matrix[i] = line.toCharArray();
        }

        for(int i = 0; i< height;i++){
            for(int j = 0;j< width ;j++){
                System.err.print(matrix[i][j] + " ");
            }
            System.err.println();
        }
        System.err.println(width+ " " + height);
        for(int y = 0; y< height;y++){
            for(int x = 0;x< width ;x++){
                if(matrix[y][x] == '0'){
                    String result = ""+(x)+" "+(y)+" ";
                    int i1 = y + 1;
                    int j1 = x + 1;
                    while(i1 < height){
                        if(matrix[i1][x] == '0'){
                            break;
                        }
                        i1++;
                    }
                    while(j1 < width){
                        if(matrix[y][j1] == '0'){
                            break;
                        }
                        j1++;
                    }
                    if(j1 >= width){
                        result = result + "-1 -1 ";
                    }else{
                        result = result + (j1) + " "+(y)+" ";
                    }
                    if(i1 >= height){
                        result = result + "-1 -1";
                    }else{
                        result = result + (x) + " "+(i1)+"";
                    }

                    System.out.println(result);
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        // System.out.println("0 0 1 0 0 1");
    }
}
