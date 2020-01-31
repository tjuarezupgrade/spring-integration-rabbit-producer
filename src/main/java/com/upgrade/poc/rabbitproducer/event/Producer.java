package com.upgrade.poc.rabbitproducer.event;

import com.upgrade.poc.rabbitproducer.model.MonetaryTransactionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void produce() {
        MonetaryTransactionMessage monetaryTransactionMessage = MonetaryTransactionMessage.builder()
                .company("1234")
                .opsArea("ACTIVE")
                .messageType("monetaryTransaction")
                .amount(BigDecimal.valueOf(100))
                .build();

        rabbitTemplate.convertAndSend(queue.getName(), monetaryTransactionMessage);

        log.info("Sending spectrum message={}, queue={}", monetaryTransactionMessage, queue.getName());
    }
}
