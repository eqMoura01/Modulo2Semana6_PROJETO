package entidades.pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String telefone;
    private LocalDate dataNasc;
    private String cpf;
    private int id;
    private static List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private static List<Pessoa> funcionarios = new ArrayList<Pessoa>();

    // Construtor...
    public Pessoa(String nome, String telefone, LocalDate dataNasc, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.id = GeradorId.gerarId();
    }

    // Getters && Setters...
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Metodos
    public static void adicionaPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static void listarPessoas() {
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + pessoas.get(i).toString());
        }
    }

    public static void adicionaFuncionario(Pessoa pessoa) {
        funcionarios.add(pessoa);
    }

    public static void listarFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + funcionarios.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", CPF: " + this.getCpf()
                + ", Codigo: " + this.getId();
    }

    public static String cpf() {
        Scanner s = new Scanner(System.in);
        boolean controlador = false;
        String cpf = "";

        while (controlador == false) {
            System.out.println("Digite o CPF(deve conter 11 digitos):");
            cpf = s.nextLine();

            if (cpf.length() == 11) {
                controlador = true;
                return cpf;
            } else {
                System.out.println("ERRO! FORMATO DE CPF INVALIDO");
            }
        }

        return cpf;
    }

    public static String telefone() {
        String telefone = "";
        Scanner s = new Scanner(System.in);
        boolean controlador = false;

        while (controlador == false) {
            System.out.println("Digite o Telefone:");
            System.out.println("(Deve conter 12 digitos)");
            System.out.println("Sendo os 3 primeiros referentes ao DDD e o restante referente ao Nº de telefone");
            telefone = s.nextLine();

            if (telefone.length() == 12) {
                controlador = true;
                return telefone;
            } else {
                System.out.println("ERRO! FORMATO DE TELEFONE INVALIDO");
            }
        }
        return telefone;
    }

    public static LocalDate dataNasc() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner s = new Scanner(System.in);
        boolean controlador = false;

        while (controlador == false) {
            System.out.println("Data de nascimento:");
            System.out.println("(Deve ser no formato 'dd/mm/aaaa'):");

            String dataAFormatar = s.nextLine();

            try {
                LocalDate dataNasc = LocalDate.parse(dataAFormatar, formato);
                controlador = true;
                return dataNasc;
            } catch (Exception e) {
                System.out.println("ERRO! FORMATO DE DATA INVALIDA!");
            }
        }

        return LocalDate.now();

    }
}
