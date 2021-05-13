package question1;

public class Calculator {

    private int a = 0, b = 0;

    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int returnResult(Operation operation){
        return operation.calcul(this.a, this.b);
    }

}
