package br.com.codeup.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class PedidoData {

    private String codigo;

    private String nomeProduto;

    private BigDecimal valor;

}