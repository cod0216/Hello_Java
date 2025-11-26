package lambda.lambda1;

import lambda.Procedure;

public class ProcedureMain1 {
    public static void main(String[] args) {
        Procedure procedure = () -> {
                System.out.println("Hello Lamda");
        };

        procedure.run();
    }
}
