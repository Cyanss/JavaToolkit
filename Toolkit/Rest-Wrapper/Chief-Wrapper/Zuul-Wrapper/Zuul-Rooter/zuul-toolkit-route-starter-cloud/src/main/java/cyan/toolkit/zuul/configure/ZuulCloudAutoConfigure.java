package cyan.toolkit.zuul.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>ZuulRouterAutoConfigure</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 8:52 2021/6/1
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = {"cyan.toolkit.zuul"})
@MapperScan(basePackages={"cyan.toolkit.zuul.mapper"})
public class ZuulCloudAutoConfigure {
    public ZuulCloudAutoConfigure() {
        log.debug("================= zuul-toolkit-route-starter-cloud initiated ！ ===================");
    }
}