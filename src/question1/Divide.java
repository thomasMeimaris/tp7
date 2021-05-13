package question1;

public class Divide implements Operation{

    @Override
    public int calcul(int a, int b) {
        int result = 0;
        try {
            result = (int) a / b;
        } catch (ArithmeticException ex){
            System.err.println("Vous avez tenté une division par zéro !");
            ex.printStackTrace();
        }
        return result;
    }
}