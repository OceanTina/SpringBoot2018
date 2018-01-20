package com.huawei.huawei.config;

import com.huawei.huawei.model.User;
import com.huawei.huawei.repository.UserRepositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Configuration
public class RouterFunctionConfiguration {

    /**
     * (1)Servlet
     * 请求接口：ServletRequest 或者HttpServletRequest
     * 响应接口：ServletResponse 或者HttpServletResponse
     * (2)Spring 5.0重新定义了服务请求和响应接口
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 即可支持Servelet 规范，也可支持自定义，比如Netty(Web Server)
     * 如，本例子
     * 定义GET请求，并返回所有的用户对象 URI:/person/find/all
     * (3)Flux 是0-N个对象集合
     * Mono 是0-1个对象集合
     * Reactive中的Flux或者Mono 它是异步处理（非阻塞）处理大数据高并发有优势
     * 集合对象基本上是同步处理（阻塞）
     * Flux 或者Mono都是Publisher
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepositoryInf userRepositoryInf)
    {
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
            request ->{
            //返回所有的用户对象
                Collection<User> users = userRepositoryInf.getAll();
                Flux<User> userFlux = Flux.fromIterable(users);
                return ServerResponse.ok().body(userFlux, User.class);
            });
    }
}
