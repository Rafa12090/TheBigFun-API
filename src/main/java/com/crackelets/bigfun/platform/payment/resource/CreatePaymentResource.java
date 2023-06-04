package com.crackelets.bigfun.platform.payment.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResource {
    private Date date;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String qrImg;
}
