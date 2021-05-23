package com.troila.datacoll.network.manager.debug;

import com.troila.datacoll.gateway.external.SubscribeRequest;
import org.hswebframework.web.authorization.exception.AccessDenyException;

public class DebugAuthenticationHandler {

    public static void handle(SubscribeRequest request){
        if (!request.getAuthentication().hasPermission("network-config", "save")) {
          throw new AccessDenyException();
        }
    }

}
