package org.example.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class TransactionDto {

    @Min(10)
    @Max(50)
    private Integer amount;


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
