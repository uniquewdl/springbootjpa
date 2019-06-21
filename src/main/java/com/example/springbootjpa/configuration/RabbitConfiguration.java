package com.example.springbootjpa.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: weidl
 * @Description:
 * @Date: Created in 10:42 2019/6/21
 */
@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue helloQueue(){
        return new Queue("helloQueue");
    }
    @Bean
    public Queue userQueue(){
        return new Queue("user");
    }
    @Bean
    public Queue queueuMesage(){
        return new Queue("topic.message");
    }
    @Bean
    public Queue queueuMesages(){
        return new Queue("topic.messages");
    }
    //===============以上是验证topic Exchange的队列==========


    //===============以下是验证Fanout Exchange的队列==========
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    //===============以上是验证Fanout Exchange的队列==========

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * @param
     * @param
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueuMesage, TopicExchange exchange) {
        return BindingBuilder.bind(queueuMesage).to(exchange).with("topic.message");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * @param
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueuMesages, TopicExchange exchange) {
        return BindingBuilder.bind(queueuMesages).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}