import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int qtdFuncionarioCadastrado = 0;
        int idFuncionario = 0;
        int idadeRegistrado = 0;
        try (Scanner sc = new Scanner(System.in)) {
            List<Funcionario> list = new ArrayList<>();

            while (true) {
                sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("===========================");
                System.out.println("O QUE DESEJA FAZER?");
                System.out.println("===========================");
                System.out.println("[1] CADASTRAR FUNCIONARIOS!");
                System.out.println("[2] VER FUNCIONARIOS CADASTRADOS");
                System.out.println("[3] AUMENTAR SALARIO");
                System.out.println("[4] SAIR");
                System.out.print("ESCOLHA: ");
                String opcao = sc.nextLine();
                System.out.println("===========================");

                if (opcao.equals("1")) {
                    System.out.println("===========================");
                    System.out.print("QUANTOS PERFIS VOCE QUER REGISTRAR: ");
                    int qtdPerfil = sc.nextInt();
                    for (int i = 0; i < qtdPerfil; i++) {
                        sc.nextLine();
                        System.out.println("===========================");
                        System.out.println("NUMEROS DE USUARIOS CADASTRADOS: " + qtdFuncionarioCadastrado);
                        qtdFuncionarioCadastrado++;
                        System.out.print("DIGITE O NOME: ");
                        String nomeRegistrado = sc.nextLine();
                        System.out.print("DIGITE A IDADE: ");
                        idadeRegistrado = sc.nextInt();
                        System.out.print("DIGITE O CPF: ");
                        String cpfRegistrado = sc.nextLine();
                        cpfRegistrado = sc.nextLine();
                        System.out.print("DIGITE O SALARIO BASE: ");
                        double salarioBase = sc.nextDouble();
                        idFuncionario++;
                        Funcionario funcionarios = new Funcionario(nomeRegistrado, idFuncionario, idadeRegistrado,
                                cpfRegistrado, salarioBase);
                        list.add(funcionarios);
                        System.out
                                .println("USUARIO " + nomeRegistrado.toUpperCase() + " ID: " + idFuncionario
                                        + " CADASTRADO!!");
                    }

                } else if (opcao.equals("2")) {
                    System.out.println("===========================");
                    System.out.println("USUARIOS CADASTRADOS");
                    for (Funcionario valores : list) {
                        if (valores.getIdade() < 18) {
                            System.out.println("ID: " + valores.getId() + " NOME: " + valores.getName() + " SALARIO: "
                                    + valores.getSalario() + " (MENOR APRENDIZ)");
                        } else {
                            System.out.println("ID: " + valores.getId() + " NOME: " + valores.getName() + " SALARIO: "
                                    + valores.getSalario() + " (ADULTO)");
                        }

                    }

                } else if (opcao.equals("3")) {

                    if (list.isEmpty() == true) {
                        System.out.println("NENHUM USUARIO FOI CADASTRADO!");

                    } else {

                        System.out.print("DIGITE O ID DO FUNCIONARIO: ");
                        int idSalario = sc.nextInt();
                        Integer pos = localizarId(list, idSalario);
                        if (pos == null) {
                            System.out.println("USUARIO NAO EXISTE!");
                        } else {
                            System.out.print("DIGITE A PORCETAGEM DO AUMENTO: ");
                            double porcetagem = sc.nextDouble();
                            list.get(pos).aumentarSalario(porcetagem);
                        }
                    }

                } else if (opcao.equals("4")) {
                    System.out.println("PROGRAMA ENCERRADO!");
                    break;
                }
            }
        }
    }

    public static Integer localizarId(List<Funcionario> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
