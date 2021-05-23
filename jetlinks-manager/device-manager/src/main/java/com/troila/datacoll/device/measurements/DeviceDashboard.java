package com.troila.datacoll.device.measurements;

import com.troila.datacoll.dashboard.Dashboard;
import com.troila.datacoll.dashboard.DashboardDefinition;

public interface DeviceDashboard extends Dashboard {


    @Override
    default DashboardDefinition getDefinition() {
        return DeviceDashboardDefinition.instance;
    }
}
