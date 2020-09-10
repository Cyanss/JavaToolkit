package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseMapException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseMapException extends RestErrorException {
    public JsonParseMapException() {
        super(RestErrorStatus.JSON_PARSE_MAP);
    }

    public JsonParseMapException(String resource) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, RestErrorStatus.JSON_PARSE_MAP));
    }

    public JsonParseMapException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_MAP));
    }

    public JsonParseMapException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, RestErrorStatus.JSON_PARSE_MAP, message));
    }

    public JsonParseMapException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_MAP, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_MAP, message));
    }

    @Override
    public JsonParseMapException get() {
        return new JsonParseMapException();
    }

    @Override
    public String name() {
        return RestErrorStatus.JSON_PARSE_MAP.name();
    }
}
