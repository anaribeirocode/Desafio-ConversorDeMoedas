import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConversorDeMoedas consulta = new ConversorDeMoedas(); // Instanciando nossa classe auxiliar

        String apiKey = "2f42bad32424095e260d73e1";

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("*************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moedas!");
            System.out.println("1) Dólar (USD) => Peso argentino (ARS)");
            System.out.println("2) Peso argentino (ARS) => Dólar (USD)");
            System.out.println("3) Dólar (USD) => Real brasileiro (BRL)");
            System.out.println("4) Real brasileiro (BRL) => Dólar (USD)");
            System.out.println("5) Dólar (USD) => Peso colombiano (COP)");
            System.out.println("6) Peso chileno (CLP) => Dólar (USD)");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*************************************************");

            opcao = leitura.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando o programa...");
                break;
            }

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida! Tente novamente.\n");
                continue;
            }

            System.out.println("Digite o valor que deseja converter:");
            double valorParaConverter = leitura.nextDouble();

            String moedaBase = "";
            String moedaAlvo = "";

            switch (opcao) {
                case 1: moedaBase = "USD"; moedaAlvo = "ARS"; break;
                case 2: moedaBase = "ARS"; moedaAlvo = "USD"; break;
                case 3: moedaBase = "USD"; moedaAlvo = "BRL"; break;
                case 4: moedaBase = "BRL"; moedaAlvo = "USD"; break;
                case 5: moedaBase = "USD"; moedaAlvo = "COP"; break;
                case 6: moedaBase = "CLP"; moedaAlvo = "USD"; break;
            }

            try {
                double taxa = consulta.buscaTaxa(moedaBase, moedaAlvo, apiKey);
                if (taxa != 0) {
                    double valorFinal = valorParaConverter * taxa;
                    System.out.printf("Valor %.2f [%s] corresponde ao valor final de => %.2f [%s]\n\n",
                            valorParaConverter, moedaBase, valorFinal, moedaAlvo);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        leitura.close();
    }
}