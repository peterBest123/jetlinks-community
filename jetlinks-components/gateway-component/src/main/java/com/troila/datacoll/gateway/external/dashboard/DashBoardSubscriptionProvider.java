package com.troila.datacoll.gateway.external.dashboard;

import com.troila.datacoll.dashboard.DashboardManager;
import com.troila.datacoll.dashboard.MeasurementParameter;
import com.troila.datacoll.gateway.external.Message;
import com.troila.datacoll.gateway.external.SubscribeRequest;
import com.troila.datacoll.gateway.external.SubscriptionProvider;
import org.jetlinks.core.utils.TopicUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Map;

@Component
public class DashBoardSubscriptionProvider implements SubscriptionProvider {

    private final DashboardManager dashboardManager;

    public DashBoardSubscriptionProvider(DashboardManager dashboardManager) {
        this.dashboardManager = dashboardManager;
    }

    @Override
    public String id() {
        return "dashboard";
    }

    @Override
    public String name() {
        return "仪表盘";
    }

    @Override
    public String[] getTopicPattern() {
        return new String[]{"/dashboard/**"};
    }

    @Override
    public Flux<Message> subscribe(SubscribeRequest request) {
        return Flux.defer(() -> {
            try {
                Map<String, String> variables = TopicUtils.getPathVariables(
                    "/dashboard/{dashboard}/{object}/{measurement}/{dimension}", request.getTopic());
                return dashboardManager.getDashboard(variables.get("dashboard"))
                    .flatMap(dashboard -> dashboard.getObject(variables.get("object")))
                    .flatMap(object -> object.getMeasurement(variables.get("measurement")))
                    .flatMap(measurement -> measurement.getDimension(variables.get("dimension")))
                    .flatMapMany(dimension -> dimension.getValue(MeasurementParameter.of(request.getParameter())))
                    .map(val -> Message.success(request.getId(), request.getTopic(), val));
            } catch (Exception e) {
                return Flux.error(new IllegalArgumentException("topic格式错误,正确格式:/dashboard/{dashboard}/{object}/{measurement}/{dimension}", e));
            }
        });
    }
}
