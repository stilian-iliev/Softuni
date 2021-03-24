package songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("_");
            Song song = new Song(input[0],input[1],input[2]);
            songs.add(song);
        }
        String album = sc.nextLine();
        if (album.equals("all")){
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (album.equals(song.getTypeList())){
                    System.out.println(song.getName());
                }
            }
        }
    }
}
