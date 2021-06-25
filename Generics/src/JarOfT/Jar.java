package JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> container = new ArrayDeque<>();

    public void add(T element){
        container.push(element);
    }

    public T remove (){
        return container.pop();
    }
}
