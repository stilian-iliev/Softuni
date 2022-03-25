package ReusingClasses;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {
    public Object getRandomElement(){
        return super.remove(new Random().nextInt(super.size()));
    }
}
