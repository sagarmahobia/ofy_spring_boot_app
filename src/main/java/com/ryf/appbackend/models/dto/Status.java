package com.ryf.appbackend.models.dto;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Status {

    private String status;

    private boolean newState;

    private boolean currentState;

}
