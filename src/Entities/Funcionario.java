
public class Funcionario {

    private String name;
    private int id;
    private int idade;
    private String cpf;
    private double salario;

    public Funcionario(String name, int id, int idade, String cpf, double salario) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.cpf = cpf;
        this.salario = salario;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double aumentarSalario(double porcetagem) {
        salario += salario * porcetagem / 100;
        return salario;

    }

    public int getId() {
        return id;
    }

   
}