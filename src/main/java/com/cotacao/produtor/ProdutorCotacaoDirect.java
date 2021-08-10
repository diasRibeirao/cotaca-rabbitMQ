package com.cotacao.produtor;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.cotacao.configuracao.Configuracao;
import com.cotacao.enums.CotacaoDia;

public class ProdutorCotacaoDirect {

	public static void main(String[] args) {

		RabbitAdmin admin = new RabbitAdmin(Configuracao.getConnection());
		Queue queueDolar = new Queue("cotacao.dolar");
		Queue queueEuro = new Queue("cotacao.euro");

		final String exchange = "exchange.cotacao";

		admin.declareQueue(queueDolar);
		admin.declareQueue(queueEuro);

		DirectExchange exchangeTorcedor = new DirectExchange(exchange);
		admin.declareExchange(exchangeTorcedor);

		admin.declareBinding(BindingBuilder.bind(queueDolar).to(exchangeTorcedor).with("dolar"));
		admin.declareBinding(BindingBuilder.bind(queueEuro).to(exchangeTorcedor).with("euro"));

		RabbitTemplate template = new RabbitTemplate(Configuracao.getConnection());

		template.convertAndSend(exchange, "dolar", CotacaoDia.getCotacaoDia("dolar"));
		template.convertAndSend(exchange, "euro", CotacaoDia.getCotacaoDia("euro"));
	}

}
