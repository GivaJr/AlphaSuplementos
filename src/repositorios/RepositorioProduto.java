package repositorios;

import classesInicias.Produto;

public class RepositorioProduto {

private Produto[] repositorioProduto;
private int numeroDeProduto;

public RepositorioProduto(int tamanho){
	this.repositorioProduto = new Produto[tamanho];
	this.numeroDeProduto = 0 ;
	}
	
public void adicionarProduto(Produto produto){
	if(produto != null && this.numeroDeProduto < repositorioProduto.length){
		this.repositorioProduto[numeroDeProduto]= produto;
		this.numeroDeProduto ++;
	}
	
}

public Produto buscarProduto(String codigo){
	int i;
	Produto retorno = null;
	for(i=0; i < numeroDeProduto; i ++ ){
		if(this.repositorioProduto[i].getCodigo() == codigo){
			retorno = this.repositorioProduto[i];
		}
	}
	return retorno; 
}


public void removerProduto(String codigo){
	int i;
	for(i=0; i< numeroDeProduto ; i++){
	  if(this.repositorioProduto[i].getCodigo()== codigo){
		  this.repositorioProduto[i]= this.repositorioProduto[numeroDeProduto-1];
		  this.repositorioProduto[numeroDeProduto-1] = null;
		  this.numeroDeProduto--;
	  }	
	}
	
}


public boolean atualizarProduto(String codigo , Produto produto){
	boolean retorno = false;
	int i;
	for(i=0;i <numeroDeProduto;i++){
		if(this.repositorioProduto[i].getCodigo() == codigo){
			this.repositorioProduto[i] = produto;
			retorno = true;
			
		}
	}
	return retorno;
}

}
