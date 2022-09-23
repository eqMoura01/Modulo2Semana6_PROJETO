package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entidades.pessoa.Pessoa;

public class Pedagogo extends Pessoa {
    private int totalAtendimentos;
    private static List<Pedagogo> pedagogos = new ArrayList<Pedagogo>();

    // Construtor...
    public Pedagogo(String nome, String telefone, LocalDate dataNasc, String cpf) {
        super(nome, telefone, dataNasc, cpf);
        this.totalAtendimentos = 0;
    }

    // Getters && Setters...
    public Integer getTotalAtendimentos() {
        return totalAtendimentos;
    }

    public void setTotalAtendimentos(int totalAtendimentos) {
        this.totalAtendimentos = totalAtendimentos;
    }

    public static List<Pedagogo> getPedagogos() {
        return pedagogos;
    }

    // Metodos...
    public static void cadastrarPedagogo() {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite um nome:");
        String nome = s.nextLine();

        String telefone = Pessoa.telefone();

        LocalDate dataNasc = Pessoa.dataNasc();

        String cpf = Pessoa.cpf();

        Pedagogo pedagogo = new Pedagogo(nome, telefone, dataNasc, cpf);

        pedagogos.add(pedagogo);
        Pessoa.adicionaPessoa(pedagogo);
        Pessoa.adicionaFuncionario(pedagogo);

    }

    public static void listarPedagogos() {
        for (int i = 0; i < pedagogos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + pedagogos.get(i).toString());
        }
    }

    public static void realizarAtendimento() {

        if (Aluno.verificaExistenciaAlunos(Aluno.getAlunos())) {
            if (verificaExistenciaPedagogos(pedagogos)) {
                Aluno.listarAlunos();
                Scanner s = new Scanner(System.in);

                System.out.println("Selecione o aluno a ser atendido:");
                System.out.println("(Deve ser selecionado através da posição na listagem!)");
                int respScannerInt = Integer.parseInt(s.nextLine());
                respScannerInt = respScannerInt - 1;

                Aluno aluno = Aluno.getAlunos().get(respScannerInt);

                listarPedagogos();
                System.out.println("Selecione o pedagogo que vai atender:");
                System.out.println("(Deve ser selecionado através da posição na listagem!)");
                respScannerInt = Integer.parseInt(s.nextLine());
                respScannerInt = respScannerInt - 1;

                Pedagogo pedagogo = getPedagogos().get(respScannerInt);

                System.out.println("O pedagogo " + pedagogo.getNome() + ", está atendendo o aluno " + aluno.getNome());

                aluno.adicionaAtendimento();

                pedagogo.adicionaAtendimento();
            }
        }

    }

    public static void listarPedagogosByNumAtendimentos() {

        pedagogos.sort(new Comparator<Pedagogo>() {

            @Override
            public int compare(Pedagogo o1, Pedagogo o2) {
                return o1.getTotalAtendimentos().compareTo(o2.getTotalAtendimentos());

            }

        }.reversed());

        for (int i = 0; i < pedagogos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + pedagogos.get(i));
        }
    }

    public void adicionaAtendimento() {
        this.totalAtendimentos += 1;
    }

    @Override
    public String toString() {
        return "Pedagogo: " + this.getNome() + ", Total de atendimentos: " + this.getTotalAtendimentos();
    }

    public static boolean verificaExistenciaPedagogos(List<Pedagogo> pedagogos) {
        boolean existe = false;

        if (pedagogos.size() > 0) {
            existe = true;
        } else {
            System.out.println("ERRO! NENHUM PEDAGOGO ENCONTRADO!");
        }

        return existe;
    }

}
