package imd.ufrn.br.modelo;

public class Pessoa implements ITributavel{
  private String nome;
  private double salario;
  private ContaCorrente conta;
  private SeguroVida seguro;
  private static final double taxaSalario = 0.11;

  public Pessoa(){

  }

  public double getTaxaSalario(){
    return taxaSalario;
  }

  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }

  public double getSalario() { return salario; }
  public void setSalario(double salario) { this.salario = salario;}

  public ContaCorrente getConta() {
    return conta;
  }
  public void setConta(ContaCorrente conta){
    this.conta = conta;
  }

  public SeguroVida getSeguro() {
    return this.seguro;
  }
  public void setSeguro(SeguroVida seguro){
    this.seguro = seguro;
  }


  public double calcularTributos(){
    return this.getSalario() * taxaSalario;
  }
}
