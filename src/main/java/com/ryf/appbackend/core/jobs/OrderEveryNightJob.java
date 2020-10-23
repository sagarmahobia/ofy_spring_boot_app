package com.ryf.appbackend.core.jobs;


import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.util.calendar.BaseCalendar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@Component
public class OrderEveryNightJob {

    @Autowired
    OpportunityDao opportunityDao;

    @Scheduled(cron = "0 30 2 * * *")
    public void run() {

        List<OpportunityEntity> currentOpportunities = new ArrayList<>();
        List<OpportunityEntity> closedOpportunities = new ArrayList<>();
        List<OpportunityEntity> alwaysOpenOpportunities = new ArrayList<>();


        List<OpportunityEntity> daoAll = opportunityDao.findAll();
        List<OpportunityEntity> all = new ArrayList<>();

        Date today = new Date();
        daoAll.forEach(opportunityEntity -> {
            if (opportunityEntity.getDeadline() == null) {
                alwaysOpenOpportunities.add(opportunityEntity);

            } else if (opportunityEntity.getDeadline().before(today)) {
                closedOpportunities.add(opportunityEntity);

            } else {
                currentOpportunities.add(opportunityEntity);
            }
        });

        currentOpportunities.sort(Comparator.comparing(OpportunityEntity::getDeadline));
        alwaysOpenOpportunities.sort((o1, o2) -> -(o1.getId().compareTo(o2.getId())));
        closedOpportunities.sort((o1, o2) -> -(o1.getDeadline().compareTo(o2.getDeadline())));


        int order = 0;
        for (OpportunityEntity current : currentOpportunities) {
            current.setOrdering(order++);
            all.add(current);
        }
        for (OpportunityEntity alwaysOpen : alwaysOpenOpportunities) {
            alwaysOpen.setOrdering(order++);
            all.add(alwaysOpen);

        }
        for (OpportunityEntity closed : closedOpportunities) {
            closed.setOrdering(order++);
            all.add(closed);
        }

        opportunityDao.saveAll(all);
    }

}
