package com.troila.datacoll.timeseries.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AggregationTerm {

    private String property;

    private Aggregation aggregation;

}
