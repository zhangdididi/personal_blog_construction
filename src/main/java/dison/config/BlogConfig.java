package dison.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BlogConfig implements WebMvcConfigurer {


    /**
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除路径，静态资源是需要排除的
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/plugins/editor/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/a/*");
        // *匹配一级路径，例如/a/1,多级不能匹配,如/a/1/2
        // **匹配的是多级路径
    }
}
