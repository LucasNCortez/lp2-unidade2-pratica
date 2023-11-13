package imd.ufrn.br.modelo;

public class ContaCorrente implements ITributavel{

  private String agencia;
  private String numero;
  private double saldo;
  private static final double taxaContaCorrente = 0.0038; //final??

  public ContaCorrente(){
    
  }

  public double getSaldo(){
    return this.saldo;
  }
  public void setSaldo(double saldo){
    this.saldo = saldo;
  }

  public String getNumero(){
    return this.numero;
  }
  public void setNumero(String numero){
    this.numero = numero;
  }

  public String getAgencia(){
    return agencia;
  }
  public void setAgencia(String agencia){
    this.agencia = agencia;
  }

  public double calcularTributos() {
    return this.getSaldo() * taxaContaCorrente;
  }

  // public double salarioTaxaDescontada(double getSalario()) {
  //   void salarioDescontado = getSalario() - taxaFixaSeguroVida;
  //   return salarioDescontado;
  // }

  public Boolean sacar(double valor) {
    if (valor <= 0 || valor > saldo){
      return false;
    }
    this.saldo -= valor;
    return true;
  }

  public void depositar(double valor){
    this.saldo += valor;
  }

  public Boolean transferir(double valor, ContaCorrente cc) {
    Boolean err = this.sacar(valor);
    if (err == false){
      return false;
    }
    cc.depositar(valor);
    return true;
  }
}

