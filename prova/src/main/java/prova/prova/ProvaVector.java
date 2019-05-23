package prova.prova;

import java.util.Vector;

public class ProvaVector {
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(3);
        System.out.println("contenuto di v: "+v);
        System.out.println("capacita' di v: "+v.capacity());
        System.out.println("n.elementi di v: "+v.size());
        v.add("a");
        v.add("b");
        v.add("d");
        v.add("e");
        System.out.println("contenuto di v: "+v);
        System.out.println("capacita' di v: "+v.capacity());
        System.out.println("n.elementi di v: "+v.size());
        v.add(2,"c");
        System.out.println("contenuto di v: "+v);
        System.out.println("capacita' di v: "+v.capacity());
        System.out.println("n.elementi di v: "+v.size());
        for (int i=0; i < v.size(); i++)
            System.out.println("elemento "+ i+": "+v.get(i));
        String first = v.get(0);
        System.out.println("primo elemento di v: "+ first);
        System.out.println("ultimo elemento di v: "+v.get(v.size()-1));
    }
}
