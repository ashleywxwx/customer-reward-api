package com.recursivechaos.customerrewardapi.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RewardsController {

    /*
        [
            {
                "userId": <UUID String>,
                "totalRewards: <int>,
                "details": [
                    {
                        "startDate": <datestamp>,
                        "rewards": <int>
                    }
                ]
            }
        ]
     */

    @GetMapping("/rewards")
    public String calculateRewards() {

        // Fetch last 90 days of transactions
        // Group by userId

        return "true";
    }

}
