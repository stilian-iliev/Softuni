package PointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean compare(Point a, Point b) {
        return a.x <= x && a.y <= y && b.x >= x && b.y >= y;
    }
}
