package com.example.produtos;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ricardo on 27/12/17.
 */
public class ProductVO {

    public static List<ProductVO> voList = Arrays.asList(
            new ProductVO("Perfume","Cosmetico"),//
            new ProductVO("Arroz","Alimento"), //
            new ProductVO("Batata","Alimento"), //
            new ProductVO("Sabao","Limpeza"), //
            new ProductVO("Carne","Alimento") //
    );

    private String nome;
    private String categoria;

    public ProductVO() {
        super();
    }

    public ProductVO(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public ProductVO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductVO productVO = (ProductVO) o;

        return nome != null ? nome.equals(productVO.nome) : productVO.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}
