package cyan.tool.kit.chip.flux.rice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.error.ParseErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>RiceJsonFlux</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:42 2019/12/19
 */
@Slf4j
public class RiceJsonFlux {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 序列化为Json字符串
     * @param target 目标数据
     * @param <T> 目标类型
     * @return String json字符串
     */
    public static <T> String parserJson(T target) throws ParseErrorException {
        try {
            return MAPPER.writeValueAsString(target);
        } catch (JsonProcessingException exception) {
            log.error("It is failed during bean to parse as json!",exception);
            throw new ParseErrorException(target.getClass().getName(), target, exception.getMessage());
        }
    }

    /**
     * json字符串解析为Bean
     * @param json json字符串数据
     * @param clazz bean类
     * @param <T> bean类型
     * @return T Bean
     */
    public static <T> T parserBean(String json, Class<T> clazz) throws ParseErrorException {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException exception) {
            log.error("It is failed during json to parse as bean!",exception);
            throw new ParseErrorException(json, clazz.getName(),RestResultStatus.JSON_PARSE_BEAN,RestError.error(exception.getMessage()));
        }
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param listType 序列化指定的CollectionType类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parserList(String json, CollectionType listType) throws ParseErrorException {
        try {
            return MAPPER.readValue(json, listType);
        } catch (JsonProcessingException exception) {
            log.error("It is failed during json to parse as list of bean!",exception);
            throw new ParseErrorException(json, listType.getTypeName(),RestResultStatus.JSON_PARSE_LIST,RestError.error(exception.getMessage()));
        }
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param parserClazz List类
     * @param clazz Bean类
     * @param <Z> List类型
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <Z extends List,T> List<T> parserList(String json, Class<Z> parserClazz, Class<T> clazz) throws ParseErrorException {
        CollectionType listType = MAPPER.getTypeFactory().constructCollectionType(parserClazz, clazz);
        return parserList(json,listType);
    }

    /**
     * json字符串解析为BeanList
     * @param json json字符串数据
     * @param clazz Bean类
     * @param <T> Bean类型
     * @return List<T> BeanList
     */
    public static <T> List<T> parserList(String json, Class<T> clazz) throws ParseErrorException {
        return parserList(json,List.class,clazz);
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param setType 序列化指定的CollectionType类型
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parserSet(String json, CollectionType setType) throws ParseErrorException {
        try {
            return MAPPER.readValue(json, setType);
        } catch (JsonProcessingException exception) {
            log.error("It is failed during json to parse as set of bean!",exception);
            throw new ParseErrorException(json, setType.getTypeName(),RestResultStatus.JSON_PARSE_SET,RestError.error(exception.getMessage()));
        }
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param parserClazz Set类
     * @param clazz Bean类
     * @param <Z> Set类型
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <Z extends Set,T> Set<T> parserSet(String json, Class<Z> parserClazz, Class<T> clazz) throws ParseErrorException {
        CollectionType setType = MAPPER.getTypeFactory().constructCollectionType(parserClazz, clazz);
        return parserSet(json,setType);
    }

    /**
     * json字符串解析为BeanSet
     * @param json json字符串数据
     * @param clazz Bean类
     * @param <T> Bean类型
     * @return Set<T> BeanSet
     */
    public static <T> Set<T> parserSet(String json, Class<T> clazz) throws ParseErrorException {
        return parserSet(json,Set.class,clazz);
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param mapType 序列化指定的MapType类型
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T, K> BeanMap
     */
    public static <T,K> Map<T, K> parserMap(String json, MapType mapType) throws ParseErrorException {
        try {
            return MAPPER.readValue(json, mapType);
        } catch (JsonProcessingException exception) {
            log.error("It is failed during json to parse as map of bean!",exception);
            throw new ParseErrorException(json, mapType.getTypeName(),RestResultStatus.JSON_PARSE_MAP,RestError.error(exception.getMessage()));
        }
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param parserClazz Map类
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <Z> Map类型
     * @param <T> key类型
     * @param <K> value类型
     * @return
     */
    public static <Z extends Map,T,K> Map<T, K> parserMap(String json, Class<Z> parserClazz, Class<T> keyClazz, Class<K> valueClazz) throws ParseErrorException {
        MapType mapType = MAPPER.getTypeFactory().constructMapType(parserClazz, keyClazz, valueClazz);
        return parserMap(json,mapType);
    }

    /**
     * json字符串解析为BeanMap
     * @param json json字符串数据
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T, K> BeanMap
     */
    public static <T,K> Map<T, K> parserMap(String json, Class<T> keyClazz, Class<K> valueClazz) throws ParseErrorException {
        return parserMap(json, Map.class,keyClazz,valueClazz);
    }


    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param parserListClazz List类
     * @param parserMapClazz Map类
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <H> List类型
     * @param <Y> Map类型
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T,List<K>> BeanMapList
     */
    public static <H extends List,Y extends Map,T,K> Map<T,List<K>> parserMapList(String json, Class<H> parserListClazz, Class<Y> parserMapClazz, Class<T> keyClazz, Class<K> valueClazz) throws ParseErrorException {
        CollectionType collectionType = MAPPER.getTypeFactory().constructCollectionType(parserListClazz, valueClazz);
        MapType mapType = MAPPER.getTypeFactory().constructMapType(parserMapClazz, keyClazz, collectionType.getRawClass());
        return parserMap(json,mapType);
    }

    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param keyClazz key类
     * @param valueClazz value类
     * @param <T> key类型
     * @param <K> value类型
     * @return Map<T,List<K>> BeanMapList
     */
    public static <T,K> Map<T,List<K>> parserMapList(String json, Class<T> keyClazz, Class<K> valueClazz) throws ParseErrorException {
        return parserMapList(json,List.class,Map.class,keyClazz,valueClazz);
    }

    /**
     *
     * json字符串解析为BeanMapList
     * @param json json字符串数据
     * @param wrapMapClazz 外层Map类
     * @param contentMapClazz 内层Map类
     * @param wrapKeyClazz 外层key类型
     * @param contentKeyClazz 内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <H> 外层Map类型
     * @param <Y> 内层Map类型
     * @param <Z> 外层mapKey类型
     * @param <T> 内层mapKey类型
     * @param <K> 内层mapValue类型
     * @return Map<Z, Map<T, K>> BeanMapMap
     */
    public static<H extends Map,Y extends Map,Z,T,K> Map<Z, Map<T, K>> parserMapMap(String json, Class<H> wrapMapClazz, Class<Y> contentMapClazz, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws ParseErrorException {
        MapType contentType = MAPPER.getTypeFactory().constructMapType(contentMapClazz, contentKeyClazz,contentValueClazz);
        MapType mapType = MAPPER.getTypeFactory().constructMapType(wrapMapClazz, wrapKeyClazz, contentType.getRawClass());
        return parserMap(json,mapType);
    }

    /**
     * json多层map数据解析
     * @param json json数据
     * @param wrapKeyClazz 外层mapKey
     * @param contentKeyClazz 内层mapKey
     * @param contentValueClazz 内层mapValue
     * @param <Z> 外层mapKey类型
     * @param <T> 内层mapKey类型
     * @param <K> 内层mapValue类型
     * @return Map<Z,Map<T, K>> BeanMapMap
     */
    public static <Z,T,K> Map<Z, Map<T, K>> parserMapMap(String json, Class<Z> wrapKeyClazz, Class<T> contentKeyClazz, Class<K> contentValueClazz) throws ParseErrorException {
        return parserMapMap(json,Map.class,Map.class,wrapKeyClazz,contentKeyClazz,contentValueClazz);
    }
}