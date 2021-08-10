package com.cotacao.configuracao;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class Configuracao {
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("elk-01.rmq2.cloudamqp.com");//TODO add hostname
            connectionFactory.setUsername("kvyhuxtk");//TODO add username
            connectionFactory.setPassword("3FwvdehXqM22tYoynbpiAZEjlHFv3kEL");//TODO add password
            connectionFactory.setVirtualHost("kvyhuxtk");//TODO add virtualhost

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
