package com.ryf.appbackend.core.controller.models;

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
