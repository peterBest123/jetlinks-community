package com.troila.datacoll.device.measurements;

import com.troila.datacoll.dashboard.DashboardDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeviceDashboardDefinition implements DashboardDefinition {

    instance("device","设备信息");

   private String id;

   private String name;
}
