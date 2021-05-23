package com.troila.datacoll.dashboard.web.response;

import lombok.Getter;
import lombok.Setter;
import com.troila.datacoll.dashboard.DashboardObject;

@Getter
@Setter
public class ObjectInfo {

    private String id;

    private String name;


    public static ObjectInfo of(DashboardObject object){
        ObjectInfo objectInfo=new ObjectInfo();
        objectInfo.setName(object.getDefinition().getName());
        objectInfo.setId(object.getDefinition().getId());

        return objectInfo;
    }

}
