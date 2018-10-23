package collections;

import oo_better.Circle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Collections {
    static HashMap<String, String> CEO = new HashMap<>();
    static {
        CEO.put("a1234", "Steve Jobs");
        CEO.put("a1235", "Scott McNealy");
        CEO.put("a1236", "Jeff Bezos");
        CEO.put("a1237", "Larry Ellison");
        CEO.put("a1238", "Bill Gates");
    }

    public static void main(String[] args) {
        List<Circle> circles = Collections.largeCircles();
        for (Circle circle: circles) {
            System.out.println(circle);
        }

        System.out.println(Collections.getCEO("A1234"));
        System.out.println(Collections.getCEO("a1234"));
        System.out.println(Collections.getCEO("b1234"));
    }

    private static List<Circle> largeCircles() {
        List<Circle> circles = new LinkedList<>();
        double nextRadius = Math.random();
        while (nextRadius > 0.1) {
            circles.add(new Circle(nextRadius));
            nextRadius = Math.random();
        }
        return circles;
    }

    private static String getCEO(String id) {
        return CEO.get(id.toLowerCase());
    }
}
