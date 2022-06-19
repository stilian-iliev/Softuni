package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public void create(List<String> list) {
        this.list = list;
        currentIndex = 0;
    }

    public boolean next() {
        if (hasNext()) {
            currentIndex++;
            return true;
        } else return false;
    }

    public boolean hasNext() {
        return (currentIndex + 1) < list.size();
    }

    public void print(){
        if (list.isEmpty()){
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(currentIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < list.size();
            }

            @Override
            public String next() {
                return list.get(i++);
            }
        };
    }
}
