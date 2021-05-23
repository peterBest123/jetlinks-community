package com.troila.datacoll.dashboard;

public interface DimensionDefinition extends Definition {
    static DimensionDefinition of(String id, String name) {
        return new DimensionDefinition() {

            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getName() {
                return name;
            }
        };
    }

}