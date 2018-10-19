package basic_syntax;

public class Syntax {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        Syntax.coinFlip(10);
        Syntax.staticArrayCreation();
        Syntax.dynamicArrayCreation(100);

        System.out.format("%d command line arguments were supplied\n", args.length);
        for(String arg: args) {
            System.out.format("Arg: %s\n", arg);
        }
    }

    private static void coinFlip(int numFlips) {
        for (int i = 0; i < numFlips; i++) {
            double result = Math.random();
            if (result < 0.5) {
                System.out.println("heads");
            } else {
                System.out.println("tails");
            }
        }
    }

    private static void staticArrayCreation() {
        double[] numbers = {
                Math.random(),
                Math.random(),
                Math.random(),
                Math.random()
        };
        for (int j = 0; j < 4; j++) {
            System.out.println(numbers[j]);
        }
    }

    private static void dynamicArrayCreation(int length) {
       double[] numbers = new double[length];
       for (int i = 0; i < length; i++) {
           numbers[i] = Math.random();
        }

        double sum = 0;
        for (double num: numbers) {
            sum += Math.sqrt(num);
        }
        System.out.format("Sum of Square Roots: %f\n", sum);
    }
}
