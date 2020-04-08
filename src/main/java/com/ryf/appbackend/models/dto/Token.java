package com.ryf.appbackend.models.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {

    private int status;

    private String token;

}
