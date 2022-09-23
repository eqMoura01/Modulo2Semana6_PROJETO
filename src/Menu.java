import java.util.Scanner;

import entidades.Aluno;
import entidades.Pedagogo;
import entidades.Professor;
import entidades.pessoa.Pessoa;

public class Menu {

    public static void menuPrincipal() {
        Scanner s = new Scanner(System.in);

        boolean controlador = true;

        while (controlador == true) {
            System.out.println("Qual menu deseja acessar?");
            System.out.println("[1] Menu Aluno");
            System.out.println("[2] Menu Professor");
            System.out.println("[3] Menu Pedagogo");
            System.out.println("[4] Menu Pessoa");
            System.out.println("[0] Sair");

            String respScannerStr = s.nextLine();

            int respScannerInt = -1;

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuProfessor();
                    break;
                case 3:
                    menuPedagogos();
                    break;
                case 4:
                    menuPessoas();
                    break;
                case 0:
                    controlador = false;
                    break;
                case default:
                    System.out.println("ERRO! COMANDO INVALIDO!");
                    break;
            }

        }
    }

    public static void menuAluno() {

        Scanner s = new Scanner(System.in);
        boolean controlador = true;

        while (controlador == true) {
            System.out.println("O que você deseja fazer?");
            System.out.println("[1] Cadastrar Aluno");
            System.out.println("[2] Listar Alunos");
            System.out.println("[3] Listar Alunos pela situação da matricula");
            System.out.println("[4] Listar Alunos por numero de atendimentos");
            System.out.println("[5] Mudar a situação do aluno");
            System.out.println("[0] Voltar");

            String respScannerStr = s.nextLine();

            int respScannerInt = -1;

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    Aluno.cadastrarAluno();
                    break;
                case 2:
                    Aluno.listarAlunos();
                    break;
                case 3:
                    Aluno.listarAlunosBySituacaoMatricula();
                    break;
                case 4:
                    Aluno.listarAlunoByNumAtendimento();
                    break;
                case 5:
                    Aluno.mudarSituacaoAluno();
                    break;
                case 0:
                    controlador = false;
                    break;
                case default:
                    System.out.println("ERRO! COMANDO INVALIDO!");
                    break;
            }
        }
    }

    public static void menuProfessor() {
        Scanner s = new Scanner(System.in);
        boolean controlador = true;

        while (controlador == true) {
            System.out.println("O que você deseja fazer?");
            System.out.println("[1] Cadastrar Professor");
            System.out.println("[2] Listar Professores");
            System.out.println("[3] Listar Professores pela area de desenvolvimento");
            System.out.println("[0] Voltar");

            String respScannerStr = s.nextLine();

            int respScannerInt = -1;

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    Professor.cadastrarProfessor();
                    break;
                case 2:
                    Professor.listarProfessores();
                    break;
                case 3:
                    Professor.listarProfessoresByAreaDev();
                    break;
                case 0:
                    controlador = false;
                    break;
                case default:
                    System.out.println("ERRO! COMANDO INVALIDO!");
                    break;
            }
        }
    }

    public static void menuPedagogos() {
        Scanner s = new Scanner(System.in);
        boolean controlador = true;

        while (controlador == true) {
            System.out.println("O que você deseja fazer?");
            System.out.println("[1] Cadastrar Pedagogo");
            System.out.println("[2] Listar Pedagogo");
            System.out.println("[3] Listar Pedagogo pelo numero de antendimentos");
            System.out.println("[4] Realizar atendimento");
            System.out.println("[0] Voltar");

            String respScannerStr = s.nextLine();

            int respScannerInt = -1;

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    Pedagogo.cadastrarPedagogo();
                    break;
                case 2:
                    Pedagogo.listarPedagogos();
                    break;
                case 3:
                    Pedagogo.listarPedagogosByNumAtendimentos();
                    break;
                case 4:
                    Pedagogo.realizarAtendimento();
                    break;
                case 0:
                    controlador = false;
                    break;
                case default:
                    System.out.println("ERRO! COMANDO INVALIDO!");
                    break;
            }
        }
    }

    public static void menuPessoas() {
        Scanner s = new Scanner(System.in);
        boolean controlador = true;

        while (controlador == true) {

            System.out.println("============");
            System.out.println("MENU PESSOAS");
            System.out.println("============");

            System.out.println("O que você deseja fazer?");
            System.out.println("[1] Listar Pessoas");
            System.out.println("[2] Listar Alunos");
            System.out.println("[3] Listar Professores");
            System.out.println("[4] Listar Pedagogos");
            System.out.println("[5] Listar Funcionarios");
            System.out.println("[0] Voltar");

            String respScannerStr = s.nextLine();

            int respScannerInt = -1;

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    Pessoa.listarPessoas();
                    break;
                case 2:
                    Aluno.listarAlunos();
                    break;
                case 3:
                    Professor.listarProfessores();
                    break;
                case 4:
                    Pedagogo.listarPedagogos();
                    break;
                case 5:
                    Pessoa.listarFuncionarios();
                    break;
                case 0:
                    controlador = false;
                    break;
                case default:
                    System.out.println("ERRO! COMANDO INVALIDO!");
                    break;
            }
        }
    }

}
