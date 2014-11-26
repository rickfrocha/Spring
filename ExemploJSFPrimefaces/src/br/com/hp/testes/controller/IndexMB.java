package br.com.hp.testes.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.hp.testes.service.FinanceiroService;
import br.com.hp.testes.service.IndexService;

@Controller
@Scope("request")
@ManagedBean(name = "indexMB")
public class IndexMB extends AbstractMB{

	private static final long serialVersionUID = 1L;
	
	private String mensagemBoasVindas;
	private Date dtAtual;
	private PieChartModel pieModel1;
	
	@Autowired
	private IndexService service;
	
	@Autowired
	private FinanceiroService financeiroService;
	
	public IndexMB() {
		System.out.println(">>> Criando managed bean index.");
	}
	
	@PostConstruct
    public void init() {
        createPieModels();
    }

	public String getMensagemBoasVindas() {
		if(mensagemBoasVindas == null){
			mensagemBoasVindas = service.obterMensagemBoasVindas();
		}
		return mensagemBoasVindas;
	}

	public void setMensagemBoasVindas(String mensagemBoasVindas) {
		this.mensagemBoasVindas = mensagemBoasVindas;
	}

	public Date getDtAtual() {
		return dtAtual;
	}

	public void setDtAtual(Date dtAtual) {
		this.dtAtual = dtAtual;
	}
	
	
	
	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	
	private void  createPieModels(){
		pieModel1 = new PieChartModel();        
		Map<String,Double> resultadoFinanceiro = financeiroService.obterPosicaoFinanceiraUltimosMeses();		
		for(String key : resultadoFinanceiro.keySet()){
			pieModel1.set(key, resultadoFinanceiro.get(key) );
		}         
        pieModel1.setTitle("Grafico: Posicao financeira ultimos meses");
        pieModel1.setLegendPosition("w");		
        pieModel1.setShowDataLabels(true);
        
	}
	
	

}
