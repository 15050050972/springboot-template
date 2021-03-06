package wang.joye.springboottemplate.global;

import wang.joye.springboottemplate.util.TResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 汪继友
 * 全局controller advice
 * 包装请求成功的返回结果
 */
@RestControllerAdvice("wang.joye.springboottemplate.controller")
public class GlobalControllerAdvice implements ResponseBodyAdvice<Object> {

    /*
     * 此组件是否支持给定的控制器方法返回类型
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getGenericParameterType().getTypeName().equals(TResult.class.getTypeName());
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return TResult.success(o);
    }
}
