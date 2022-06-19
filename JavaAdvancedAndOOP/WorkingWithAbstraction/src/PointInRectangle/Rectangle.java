package PointInRectangle;

public class Rectangle {
    private Point A;
    private Point B;

    public Rectangle(Point a, Point b) {
        A = a;
        B = b;
    }

    public boolean contains(Point p){
        return p.compare(A,B);
    }
}
