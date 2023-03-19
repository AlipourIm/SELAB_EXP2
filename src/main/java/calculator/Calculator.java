package calculator;

public class Calculator {
    public int add (int a, int b) {
        return a + b;
    }

    public double func(int a, String opt) throws Exception {
        if (opt.equals("rvs")){
            if (a == 0){
                throw new Exception("cannot divide by zero");
            }
            return 1/a;
        } else if (opt.equals("sqr")) {
            if (a < 0){
                throw new Exception("sqrt is not defined for negative numbers");
            }
            return Math.sqrt(a);
        }
        throw new Exception("undefined opt");
    }
}
