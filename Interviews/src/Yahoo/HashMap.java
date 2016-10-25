package Yahoo;

/**
 * @author: basavakanaparthi
 * on 19,Oct,2016 at 8:21 PM.
 */

import java.util.Map.Entry;
class MyEntry<K,V> implements Entry<K,V>{
    K key;
    V value;
    MyEntry<K,V> next;

    public MyEntry(K key, V value)
    {
        this.key = key;
        this.value = value;
        next = null;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }
}

public class HashMap {
    private MyEntry[] map;
    private int capacity;

    public HashMap(int size)
    {
        this.capacity = size;
        map = new MyEntry[size];
    }

    public boolean put(Integer k, Integer v)
    {
        if (k == null)
            return false;
        int hashValue = hash(k);

        MyEntry<Integer, Integer> newEnt = new MyEntry<>(k,v);
        if (map[hashValue] == null)
        {
            map[hashValue] = newEnt;
            return true;
        }
        else
        {
            MyEntry<Integer, Integer> curr = map[hashValue];
            if (curr == null)
            {
                map[hashValue] = newEnt;
                return true;
            }
            while(curr.next != null)
            {
                if (curr.key == k)
                {
                    curr.value = v;
                    return true;
                }
                curr = curr.next;
            }
            curr.next = newEnt;
            return true;
        }
    }

    public Integer get(Integer k)
    {
        if (k == null)
            return null;
        int hashCode = hash(k);
        if (map[hashCode] == null)
            return null;
        MyEntry<Integer, Integer> curr = map[hashCode];
        while(curr != null)
        {
            if(curr.key.equals(k))
            {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean remove(Integer k)
    {
        if (k == null)
            return false;
        int hashCode = hash(k);
        if (map[hashCode] == null)
            return false;
        MyEntry<Integer, Integer> curr = map[hashCode];
        MyEntry<Integer, Integer> prev = null;
        while(curr != null)
        {
            if (curr.key.equals(k))
            {
                if (prev == null)
                {
                    map[hashCode] = map[hashCode].next;
                    return true;
                }
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    private int hash(Integer k)
    {
        return Math.abs(k)%capacity;
    }

    public static void main(String[] args) {
        HashMap m = new HashMap(5);
        m.put(1,2);
        System.out.println(m.get(1));
    }
}

