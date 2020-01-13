package cyan.tool.kit.rice.core.rice.error.often.json;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>JsonParseSetException</p>
 *
 * @author liuqingpo(snow22314 @ outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 16:45 2019/12/25
 */
public class JsonParseSetException extends RestErrorException {
    public JsonParseSetException() {
        super(RestErrorStatus.JSON_PARSE_SET);
    }

    public JsonParseSetException(String resource) {
        super(RestErrorStatus.JSON_PARSE_SET, RestError.error(resource, RestErrorStatus.JSON_PARSE_SET));
    }

    public JsonParseSetException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_SET, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_SET));
    }

    public JsonParseSetException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_SET, RestError.error(resource, RestErrorStatus.JSON_PARSE_SET, message));
    }

    public JsonParseSetException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_SET, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_SET, message));
    }

    @Override
    public JsonParseSetException get() {
        return new JsonParseSetException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.JSON_PARSE_SET.getName();
    }
}
