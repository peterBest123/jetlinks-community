package com.troila.datacoll.gateway.monitor;

public interface DeviceGatewayMonitorSupplier {
      DeviceGatewayMonitor getDeviceGatewayMonitor(String id, String... tags);

}
