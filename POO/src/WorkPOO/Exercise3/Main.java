package WorkPOO.Exercise3;

import WorkPOO.Exercise3.Classes.BankAccount;

public class Main {
    public static void main(String[] args) {
/*        3. Cuenta Bancaria: Implementa una clase CuentaBancaria con los atributos
        titular y balance. Añade métodos para depositar dinero, retirar dinero (no
        permitas que el balance se vuelva negativo) y mostrar el balance actual.*/
        BankAccount account = new BankAccount("Jhonatan", 100000);
        account.showBalanceInScreen();
        account.depositMoney(50000);
        account.showBalanceInScreen();
        account.withdrawMoney(60500);
        account.showBalanceInScreen();
    }
}
