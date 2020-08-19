package com.leyou.auth.client;

import com.leyou.user.Api;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service")
public interface UserClient extends Api {
}
