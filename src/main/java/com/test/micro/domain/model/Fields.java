package com.test.micro.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fields {
    private Boolean priority;
    private Integer productId;
    private String price;
    private String currency;

}