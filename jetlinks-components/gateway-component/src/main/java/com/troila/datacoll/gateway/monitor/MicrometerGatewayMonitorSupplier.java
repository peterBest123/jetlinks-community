package com.troila.datacoll.gateway.monitor;

import com.troila.datacoll.micrometer.MeterRegistryManager;
import org.springframework.stereotype.Component;

@Component
public class MicrometerGatewayMonitorSupplier implements DeviceGatewayMonitorSupplier {

    private final MeterRegistryManager meterRegistryManager;

    public MicrometerGatewayMonitorSupplier(MeterRegistryManager meterRegistryManager) {
        this.meterRegistryManager = meterRegistryManager;
        GatewayMonitors.register(this);

    }


    @Override
    public DeviceGatewayMonitor getDeviceGatewayMonitor(String id, String... tags) {
        return new MicrometerDeviceGatewayMonitor(meterRegistryManager.getMeterRegister(GatewayTimeSeriesMetric.deviceGatewayMetric, "target"), id, tags);
    }
}
