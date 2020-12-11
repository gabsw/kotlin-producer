package demo.api.producer.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.rabbitmq.client.Channel
import demo.api.producer.configurations.RabbitMqProperties
import demo.api.producer.pojos.GameEvent

class RabbitMqSender (private val channel: Channel,
                      private val rabbitMqProperties: RabbitMqProperties,
                      private val objectMapper: ObjectMapper){
    fun send(message : GameEvent) {
        val sendMessage = objectMapper.writeValueAsString(message)
        channel.basicPublish("", rabbitMqProperties.queueName, null ,sendMessage.toByteArray())
        println("[x] Sent '$message'")
    }
}
