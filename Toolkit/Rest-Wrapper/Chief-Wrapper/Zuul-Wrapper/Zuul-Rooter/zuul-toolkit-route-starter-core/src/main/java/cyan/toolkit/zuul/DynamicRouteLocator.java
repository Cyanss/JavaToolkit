package cyan.toolkit.zuul;

import cyan.toolkit.rest.util.common.GeneralUtils;
import cyan.toolkit.rest.util.common.JsonUtils;
import cyan.toolkit.zuul.configure.ZuulRouteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>DiscoveryRouteLocator</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:15 2021/6/9
 */
@Slf4j
public class DynamicRouteLocator extends DiscoveryClientRouteLocator implements RefreshableRouteLocator,InitializingBean {

    protected ZuulRouteProperties routeProperties;

    protected ZuulProperties zuulProperties;

    protected static final PathMatcher MATCHER = new AntPathMatcher();

    private static DynamicRouteLocator instance = null;

    public DynamicRouteLocator(String servletPath, DiscoveryClient discovery, ZuulProperties properties, ServiceRouteMapper serviceRouteMapper, ServiceInstance localServiceInstance, ZuulRouteProperties routeProperties) {
        super(servletPath, discovery, properties, serviceRouteMapper, localServiceInstance);
        this.routeProperties = routeProperties;
        this.zuulProperties = properties;
    }

    @Override
    public void afterPropertiesSet() {
        instance = this;
        log.info("routeProperties: {}",JsonUtils.parseJson(routeProperties));
        reloadWhites();
        loadWhites();
        loadRoutes();
    }

    public void loadWhites() {
    }

    public void loadRoutes() {
    }

    public void reloadWhites() {
    }

    public synchronized static boolean existWhite(String white) {
        boolean exist = false;
        if (GeneralUtils.isNotEmpty(instance.routeProperties.getWhites())) {
            for (String path : instance.routeProperties.getWhites()) {
                if (MATCHER.isPattern(path)) {
                    exist = MATCHER.match(path, white);
                } else {
                    exist = path.equals(white);
                }
                if (exist) {
                    break;
                }
            }
        }
        return exist;
    }

    public void addRoute(String path, String location) {
        cyan.toolkit.zuul.DynamicRoute result = new cyan.toolkit.zuul.DynamicRoute(path, location);
        if (GeneralUtils.isNotEmpty(result)) {
            zuulProperties.getRoutes().put(result.getPath(), result);
            refresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", result.getPath(), result.getLocation());
        }
    }

    public void addRoute(ZuulProperties.ZuulRoute route) {
        cyan.toolkit.zuul.DynamicRoute result = new cyan.toolkit.zuul.DynamicRoute(route.getPath(), route.getLocation());
        if (GeneralUtils.isNotEmpty(result)) {
            zuulProperties.getRoutes().put(result.getPath(), result);
            refresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", result.getPath(), result.getLocation());
        }
    }

    public void addRoute(cyan.toolkit.zuul.DynamicRoute routeModel) {
        if (GeneralUtils.isNotEmpty(routeModel)) {
            zuulProperties.getRoutes().put(routeModel.getPath(), routeModel);
            refresh();
            log.info("the route list has added one, path: {}, location: {}, the route list will be refreshed !", routeModel.getPath(), routeModel.getLocation());
        }
    }

    public void addRoutes(Collection<cyan.toolkit.zuul.DynamicRoute> routes) {
        if (GeneralUtils.isNotEmpty(routes)) {
            Map<String, ZuulProperties.ZuulRoute> zuulRouteMap = routes.stream().collect(Collectors.toMap(ZuulProperties.ZuulRoute::getPath, Function.identity()));
            zuulProperties.getRoutes().putAll(zuulRouteMap);
            refresh();
            log.info("the route list has added {} routes, the route list will be refreshed !", routes.size());
        }
    }

    public void removeRoute(String route) {
        if (GeneralUtils.isNotEmpty(route)) {
            Map<String, ZuulProperties.ZuulRoute> routeList = zuulProperties.getRoutes();
            if (!routeList.isEmpty()) {
                ZuulProperties.ZuulRoute remove = routeList.remove(route);
                if (GeneralUtils.isNotEmpty(remove)) {
                    log.info("the route list has removed one, path: {}, location: {}", remove.getPath(), remove.getLocation());
                    refresh();
                    log.info("the route list will be refreshed !");
                }
            }
        }
    }

    public void removeRoutes(Collection<String> routes) {
        if (GeneralUtils.isNotEmpty(routes)) {
            Map<String, ZuulProperties.ZuulRoute> routeList = zuulProperties.getRoutes();
            if (!routes.isEmpty()) {
                AtomicBoolean isRemove = atomicRemoveRoutes(routes,routeList);
                if (isRemove.get()) {
                    refresh();
                    log.info("the route list will be refreshed !");
                }

            }
        }
    }


    protected AtomicBoolean atomicRemoveRoutes(Collection<String> routes,Map<String, ZuulProperties.ZuulRoute> routeList) {
        AtomicBoolean isRemove = new AtomicBoolean(false);
        for (String route : routes) {
            ZuulProperties.ZuulRoute remove = routeList.remove(route);
            if (GeneralUtils.isNotEmpty(remove)) {
                isRemove.set(true);
                log.info("the route list has removed one, path: {}, location: {}", remove.getPath(), remove.getLocation());
            }
        }
        return isRemove;
    }

    public void addWhite(String white) {
        if (GeneralUtils.isNotEmpty(white)) {
            instance.routeProperties.getWhites().add(white);
            log.info("the white list has added one, path: {}, the white list will be refreshed !", white);
        }
    }

    public void addWhites(Collection<String> whites) {
        if (GeneralUtils.isNotEmpty(whites)) {
            instance.routeProperties.getWhites().addAll(whites);
            log.info("the white list has added {} whites, the white list will be refreshed !", whites.size());
        }
    }

    public void removeWhite(String white) {
        if (GeneralUtils.isNotEmpty(white)) {
            instance.routeProperties.getWhites().remove(white);
            log.info("the white list has removed one, path: {}, the white list will be refreshed !", white);
        }
    }

    public void removeWhites(Collection<String> whites) {
        if (GeneralUtils.isNotEmpty(whites)) {
            instance.routeProperties.getWhites().removeAll(whites);
            log.info("the white list has removed {} whites, the white list will be refreshed !", whites.size());
        }
    }

    @Override
    public void refresh() {
        if (routeProperties.getEnabled()) {
            ZuulRouteProperties.Refreshed refreshed = routeProperties.getRefreshed();
            if (refreshed.getRoutesEnabled()) {
                refreshRoutes();
            }
            if (refreshed.getWhitesEnabled()) {
                refreshWhites();
            }
        }
        doRefresh();
    }

    protected void refreshWhites() {
    }

    protected void refreshRoutes() {
    }

}
