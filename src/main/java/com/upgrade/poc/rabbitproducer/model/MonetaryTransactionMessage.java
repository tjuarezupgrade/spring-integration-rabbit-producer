package com.upgrade.poc.rabbitproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MonetaryTransactionMessage implements SpectrumMessage {

    private Long id;

    private String messageType;

    private String company;

    private String opsArea;

    private BigDecimal amount;
}
