import java.math.BigDecimal;


public class HelloWorld {
    public static void main(String args[]) {
        double dblX;
        dblX = 3 + .2;
        System.out.println(dblX);
        System.out.printf("Sum of 3 and .2 as %f\n", dblX);

        BigDecimal x = new BigDecimal(3);
        BigDecimal y = new BigDecimal(.2);
        System.out.printf("Sum of BigDecimal 3 and .2 %f\n", x.add(y));
        System.out.printf("Sum of BigDecimal 3 and .2 toString %s\n", x.add(y).toString());

        BigDecimal foo = new BigDecimal(100.0);
        BigDecimal zero = new BigDecimal(.0);
        System.out.printf("Is Zero %s\n", foo.compareTo(zero));
        System.out.printf("Is Zero %s\n", foo.compareTo(BigDecimal.ZERO));
    }
}
