package imd.ufrn.br.dao;

import java.util.ArrayList;

import imd.ufrn.br.controle.GeradorImpostoRenda;
import imd.ufrn.br.modelo.Pessoa;
import imd.ufrn.br.modelo.SeguroVida;

public class PessoaDAO {
  private ArrayList<Pessoa> pessoas = new ArrayList<>();

  public PessoaDAO(){

  }

  public ArrayList<Pessoa> getPessoas(){
    return this.pessoas;
  }

  public void cadastrarPessoa(Pessoa novaPessoa){
    this.pessoas.add(novaPessoa);
  }
  public void removerPessoa(Pessoa pessoaParaRemover){
    this.pessoas.remove(pessoaParaRemover);
  }
  public void listarPessoas(){
    System.out.print("\n");
    for(Pessoa pessoa : this.pessoas){
      System.out.println("\nNome: " + pessoa.getNome());
      System.out.printf("Salário: R$%.2f\n", pessoa.getSalario());
      System.out.println("Agencia de conta: " + pessoa.getConta().getAgencia());
      System.out.println("Numero de conta: " + pessoa.getConta().getNumero());
      System.out.printf("Saldo de conta: R$%.2f\n", pessoa.getConta().getSaldo());
      System.out.println("Numero de seguro: " + pessoa.getSeguro().getNumero());
      System.out.println("Beneficiado de seguro: " + pessoa.getSeguro().getBeneficiado());
      System.out.printf("Valor de seguro: R$%.2f\n", pessoa.getSeguro().getValor());
    }
  }

  public double calcularTributosPessoas(){
    double totalImpostos = 0;

    GeradorImpostoRenda geradorDeTributos = new GeradorImpostoRenda();

    for(Pessoa pessoa: this.pessoas){
      double impostoDePessoa = geradorDeTributos.calcularValorTotalTributo(pessoa);
      totalImpostos += impostoDePessoa;
    }

    return totalImpostos;
  }
  public void imprimeImpostoTotal(){
    GeradorImpostoRenda geradorDeTributos = new GeradorImpostoRenda();
    Pessoa maiorPagadorDeImpostos = new Pessoa();
    SeguroVida seguroComMaiorValor = new SeguroVida();

    for(Pessoa pessoa: this.pessoas){
      if (geradorDeTributos.calcularValorTotalTributo(maiorPagadorDeImpostos) < geradorDeTributos.calcularValorTotalTributo(pessoa)){
        maiorPagadorDeImpostos = pessoa;
      }
      if(seguroComMaiorValor.getValor() < pessoa.getSeguro().getValor()){
        seguroComMaiorValor = pessoa.getSeguro();
      }
    }

    System.out.printf("\nTotal de imposto a ser recolhido: R$ %.2f", this.calcularTributosPessoas());
  
    System.out.printf("\nMaior pagador de impostos: %s", maiorPagadorDeImpostos.getNome());

    System.out.printf("\nBeneficiado do seguro de maior valor: %s", seguroComMaiorValor.getBeneficiado());
  }
  
}
