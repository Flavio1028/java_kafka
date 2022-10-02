package br.com.codeup.controller;

import br.com.codeup.data.PedidoData;
import br.com.codeup.service.RegistraEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    @Autowired
    private RegistraEventoService service;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedido) {
        this.service.adicionarEvento("SalvarPedido", pedido);
        return ResponseEntity.ok("Sucesso");
    }

}