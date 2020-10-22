package com.ryf.appbackend.core.controller.admin;


import com.ryf.appbackend.core.repository.SubmittedOpportunityRepository;
import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import com.ryf.appbackend.models.dto.Opportunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class SubmittedOpportunityController {
    private final SubmittedOpportunityRepository submittedOpportunityRepository;
    private final
    OpportunityUtil opportunityUtil;

    @Autowired
    public SubmittedOpportunityController(SubmittedOpportunityRepository submittedOpportunityRepository, OpportunityUtil opportunityUtil) {
        this.submittedOpportunityRepository = submittedOpportunityRepository;
        this.opportunityUtil = opportunityUtil;
    }

    @GetMapping(path = "/v1/protected/admin/submitted_opportunities")
    @ResponseBody
    public List<Opportunity> getSubmittedOpportunities(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                       @RequestParam(value = "size", defaultValue = "10", required = false) int size) {

        List<SubmittedOpportunityEntity> all = submittedOpportunityRepository.findAll(page, size);

        return opportunityUtil.getOpportunityFromSubmittedEntityList(all);
    }
}
