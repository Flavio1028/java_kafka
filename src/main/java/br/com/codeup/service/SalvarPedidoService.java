package br.com.codeup.service;

import br.com.codeup.data.PedidoData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SalvarPedidoService {

    @KafkaListener(topics = "SalvarPedido", groupId = "MicroServicoSalvaPedido")
    public void executar(ConsumerRecord<String, String> record) {

        log.info("Chave = {}", record.key());
        log.info("Cabecalho = {}", record.headers());
        log.info("Particao = {}", record.partition());

        String dados = record.value();

        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedido = null;

        try{
            pedido = mapper.readValue(dados, PedidoData.class);
            log.info(pedido.toString());
        } catch (Exception e) {
            log.error("Falha converter evento = {} ", dados, e);
        }

        log.info("Evento processado.");
    }

}