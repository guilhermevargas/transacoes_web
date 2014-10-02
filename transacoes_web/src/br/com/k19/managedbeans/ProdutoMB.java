package br.com.k19.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Produto;
import br.com.k19.sessionbean.RepositoriosProdutos;

@ManagedBean
public class ProdutoMB {
	@EJB
	private RepositoriosProdutos repositorio;
	private Produto produto = new Produto();
	private List<Produto> produtosCache;
	
	public void adiciona() {
		this.repositorio.adiciona(this.produto);
		this.produto = new Produto();
		this.produtosCache = null;
	}
	
	public List<Produto> getProdutos() {
		if (this.produtosCache == null) {
			this.produtosCache = this.repositorio.getProdutos();
		}
		
		return this.produtosCache;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
