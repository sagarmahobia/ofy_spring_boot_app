package com.ryf.appbackend.core.opportunity.models;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Status {

    private String status;

    private boolean newState;

}
