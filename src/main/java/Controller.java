import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        View.createMessage();
        DAO.createTable();
        Integer menuoption = 0;
        do {
            menuoption = option();
        } while (menuoption != 9);
        View.exitMessage();
        System.exit(0);
    }

    public static Integer option() {
        View.menu();
        Scanner scanner = new Scanner(System.in);
        Integer option = 0;
        try {
            option = scanner.nextInt();
        } catch (Exception e) {
            View.invalidValueMessageException();
            option();
        }
        if (option == 1) {
            Model model = new Model();
            View.insertName();
            model.setNome(scanner.next());
            View.insertAgency();
            try {
                model.setIdagencia(scanner.nextInt());
            } catch (Exception e) {
                View.invalidValueMessageException();
                option();
            }
            View.insertAccount();
            try {
                model.setIdcontacorrente(scanner.nextInt());
            } catch (Exception e) {
                View.invalidValueMessageException();
                option();
            }
            View.insertMoneyAmount();
            try {
                model.setSaldoatualizado(scanner.nextDouble());
            } catch (Exception e) {
                View.invalidValueMessageException();
                option();
            }
            DAO.insertIntoTable(model.getNome(), model.getIdagencia().toString(), model.getIdcontacorrente().toString(), model.getSaldoatualizado().toString());
            model = null;
            View.insertFinish();
            return 1;
        }
        if (option == 2) {
            View.readInputAgencia();
            String agencia = scanner.next();
            View.readInputContaCorrente();
            String cc = scanner.next();
            try {
                DAO.searchContaCorrente(agencia, cc);
            } catch (Exception e) {
                option();
            }
            return 2;
        }

        if (option == 3) {
            Integer agencia = 0;
            Integer cc = 0;
            View.readInputAgencia();
            try {
                agencia = scanner.nextInt();
            } catch (Exception e) {
                View.invalidValueMessageException();
                option();
            }
            View.readInputContaCorrente();
            try {
                cc = scanner.nextInt();
            } catch (Exception e) {
                View.invalidValueMessageException();
                option();
            }
            try {
                Double saldo = Double.parseDouble(DAO.retrieveSaldo(agencia.toString(), cc.toString()));
                View.menuDepositWithdraw();
                Integer option2 = scanner.nextInt();
                Double inputAmount = 0.0;
                if (option2 == 1 || option2 == 2) {
                    try {
                        View.insertMoneyAmountForDP();
                        inputAmount = scanner.nextDouble();
                    } catch (Exception e) {
                        View.invalidValueMessageException();
                        option();
                    }
                } else {
                    View.invalidValueMessageException();
                    option();
                }
                if (option2 == 1) {
                    saldo = saldo + inputAmount;
                }
                if (option2 == 2) {
                    if (saldo > inputAmount) {
                        saldo = saldo - inputAmount;
                    } else {
                        View.insuficientAmount();
                    }
                }
                DAO.depositWithdraw(agencia.toString(), cc.toString(), saldo.toString());
            } catch (Exception e) {
                View.genericError();
                option();
            }
            return 2;
        }

        if (option == 9) {
            return 9;
        }
        View.invalidValueMessage();
        return 0;
    }
}
