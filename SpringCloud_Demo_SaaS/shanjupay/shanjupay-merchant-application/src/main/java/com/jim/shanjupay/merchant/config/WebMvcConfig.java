package com.jim.shanjupay.merchant.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jim
 * @Description
 * @createTime 2023年03月05日
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler(("swagger-ui.html"))
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler(("/webjars/**"))
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

//@Component
//public class WebMvcConfig implements WebMvcConfigurer {
//    /**
//     * 添加静态资源文件，外部可以直接访问地址
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//}
