package com.ryf.appbackend.core.controller.models;

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
