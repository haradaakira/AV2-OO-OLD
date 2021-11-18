public class View {

    public static void menu() {
        System.out.print("\n<<< MENU PRINCIPAL >>>\n1 - Inserir os dados na tabela\n2 - Procurar por agencia e conta corrente\n3 - Sacar/depositar por agencia e conta corrente\n9 - Encerrar\nEscolha: ");
    }

    public static void menuDepositWithdraw() {
        System.out.print("1 - Deposito\n2 - Saque\nEscolha: ");
    }

    public static void createMessage() {
        System.out.println("\n--- Criando a tabela ---");
    }

    public static void insertName() {
        System.out.print("Insira o nome: ");
    }

    public static void insertAgency() {
        System.out.print("Insira a agencia: ");
    }

    public static void insertAccount() {
        System.out.print("Insira o numero da conta: ");
    }

    public static void insertMoneyAmount() {
        System.out.print("Insira o saldo: ");
    }

    public static void insertMoneyAmountForDP() {
        System.out.print("Insira o valor: ");
    }

    public static void insertFinish() {
        System.out.println("--- Inserindo na tabela ---");
    }

    public static void readInputAgencia() {
        System.out.print("Insira a agencia: ");
    }

    public static void readInputContaCorrente() {
        System.out.print("Insira a conta corrente: ");
    }

    public static void exitMessage() {
        System.out.println("--- Encerrando ---");
    }

    public static void invalidValueMessageException() {
        System.out.println("\n!!! INSIRA UM NUMERO !!!");
    }

    public static void invalidValueMessage() {
        System.out.println("!!! VALOR INVALIDO !!!\n");
    }

    public static void insuficientAmount() {
        System.out.println("!!! SALDO INSUFICIENTE !!!");
    }

    public static void genericError() {
        System.out.println("!!! ERRO !!!");
    }
}
