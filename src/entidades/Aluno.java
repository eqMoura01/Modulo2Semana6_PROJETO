package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entidades.pessoa.Pessoa;

public class Aluno extends Pessoa {

    private String condicaoMatricula;
    private Double notaDeCorte;
    private int totalAtendimentos;
    private static List<Aluno> alunos = new ArrayList<Aluno>();

    // Construtor...
    public Aluno(String nome, String telefone, LocalDate dataNasc, String cpf, Double notaDeCorte,
            String condicaoMatricula) {
        super(nome, telefone, dataNasc, cpf);
        this.notaDeCorte = notaDeCorte;
        this.condicaoMatricula = condicaoMatricula;
        this.totalAtendimentos = 0;
    }

    // Getters && Setters...
    public String getCondicaoMatricula() {
        return condicaoMatricula;
    }

    public void setCondicaoMatricula(String condicaoMatricula) {
        this.condicaoMatricula = condicaoMatricula;
    }

    public Double getNotaDeCorte() {
        return notaDeCorte;
    }

    public void setNotaDeCorte(Double notaDeCorte) {
        this.notaDeCorte = notaDeCorte;
    }

    public Integer getTotalAtendimentos() {
        return totalAtendimentos;
    }

    public void setTotalAtendimentos(int totalAtendimentos) {
        this.totalAtendimentos = totalAtendimentos;
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    // Metodos...
    public static void cadastrarAluno() {

        Scanner s = new Scanner(System.in);

        System.out.println("Digite um nome:");
        String nome = s.nextLine();

        String telefone = Pessoa.telefone();

        LocalDate dataNasc = Pessoa.dataNasc();

        String cpf = Pessoa.cpf();

        Double notaDeCorte = notaDeCorte();

        String condicaoMatricula = situacaoAluno();

        Aluno aluno = new Aluno(nome, telefone, dataNasc, cpf, notaDeCorte, condicaoMatricula);

        alunos.add(aluno);
        Pessoa.adicionaPessoa(aluno);
    }

    public static void listarAlunos() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + alunos.get(i).toString());
        }
    }

    public static void listarAlunosBySituacaoMatricula() {
        ArrayList<Aluno> alunoSelecionado = new ArrayList<Aluno>();

        Scanner s = new Scanner(System.in);
        System.out.println("Qual a situação de matricula que deseja filtrar?");
        String statusMatricula = situacaoAluno();

        for (int i = 0; i < alunos.size(); i++) {
            if (statusMatricula.equalsIgnoreCase(alunos.get(i).getCondicaoMatricula())) {
                alunoSelecionado.add(alunos.get(i));
            }
        }

        for (int i = 0; i < alunoSelecionado.size(); i++) {
            System.out.println(alunoSelecionado.get(i).toString());
        }
    }

    public static void listarAlunoByNumAtendimento() {
        alunos.sort(new Comparator<Aluno>() {

            @Override
            public int compare(Aluno o1, Aluno o2) {
                return o1.getTotalAtendimentos().compareTo(o2.getTotalAtendimentos());
            }

        }.reversed());

        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + alunos.get(i).toString());
        }
    }

    public static void mudarSituacaoAluno() {
        listarAlunos();

        System.out.println("Deseja mudar a Situação de matricula de qual aluno?");
        System.out.println("(Deve ser selecionado através da posição na listagem!)");

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        n = n - 1;

        alunos.get(n).setCondicaoMatricula(situacaoAluno());

    }

    public void adicionaAtendimento() {
        this.totalAtendimentos += 1;
        this.setCondicaoMatricula("Em Atendimento Pedagogico");
    }

    @Override
    public String toString() {
        return "Aluno: " + this.getNome() + ", Nota de corte: " + this.getNotaDeCorte() + ", CPF: " + this.getCpf()
                + ", Codigo: " + this.getId() + ", Situação de Matricula: " + this.getCondicaoMatricula()
                + ", Total de atendimentos recebidos: "
                + this.getTotalAtendimentos();
    }

    private static Double notaDeCorte() {

        Scanner s = new Scanner(System.in);
        boolean controlador = false;

        while (controlador == false) {
            System.out.println("Nota de corte do Aluno");
            System.out.println("(Entre 0 e 10)");

            Double notaCorteDbl = -1d;
            String notaCorteStr = s.nextLine();

            try {
                notaCorteDbl = Double.parseDouble(notaCorteStr);
            } catch (Exception e) {
                e = new Exception("ERRO! DIGITE UM NUMERO!");
                System.out.println(e);
            }

            if (notaCorteDbl >= 0 && notaCorteDbl <= 10) {
                controlador = true;
                return notaCorteDbl;
            } else {
                System.out.println("ERRO! NOTA INVALIDA");
            }
        }

        return 0d;
    }

    private static String situacaoAluno() {
        Scanner s = new Scanner(System.in);
        boolean controlador = false;
        String situacaoAluno = "";

        while (controlador == false) {
            System.out.println("Situação do Aluno:");
            System.out.println("[1] Ativo");
            System.out.println("[2] Inativo");
            System.out.println("[3] Irregular");
            System.out.println("[4] Em Atendimento Pedagogico");

            int respScannerInt = -1;
            String respScannerStr = s.nextLine();

            try {
                respScannerInt = Integer.parseInt(respScannerStr);
            } catch (Exception e) {
                e = new Exception("ERRO! INSIRA UM NUMERO!");
                System.out.println(e.getMessage());
            }

            switch (respScannerInt) {
                case 1:
                    situacaoAluno = "Ativo";
                    controlador = true;
                    break;
                case 2:
                    situacaoAluno = "Inativo";
                    controlador = true;
                    break;
                case 3:
                    situacaoAluno = "Irregular";
                    controlador = true;
                    break;
                case 4:
                    situacaoAluno = "Em Atendimento Pedagico";
                    controlador = true;
                    break;
                case default:
                    System.out.println("ERRO! OPÇÃO INVALIDA!");
                    break;
            }
        }

        return situacaoAluno;
    }

    public static boolean verificaExistenciaAlunos(List<Aluno> alunos) {
        boolean existe = false;

        if (alunos.size() > 0) {
            existe = true;
        } else {
            System.out.println("ERRO! NENHUM ALUNO ENCONTRADO!");
        }

        return existe;
    }
}
