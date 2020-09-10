package cyan.toolkit.rest.error.json;

import cyan.toolkit.rest.RestError;
import cyan.toolkit.rest.RestErrorException;
import cyan.toolkit.rest.RestErrorStatus;

/**
 * <p>JsonParseListException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:06 2019/12/24
 */
public class JsonParseListException extends RestErrorException {
    public JsonParseListException() {
        super(RestErrorStatus.JSON_PARSE_LIST);
    }

    public JsonParseListException(String resource) {
        super(RestErrorStatus.JSON_PARSE_LIST, RestError.error(resource, RestErrorStatus.JSON_PARSE_LIST));
    }

    public JsonParseListException(String resource, Object value) {
        super(RestErrorStatus.JSON_PARSE_LIST, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_LIST));
    }

    public JsonParseListException(String resource, String message) {
        super(RestErrorStatus.JSON_PARSE_LIST, RestError.error(resource, RestErrorStatus.JSON_PARSE_LIST, message));
    }

    public JsonParseListException(String resource, Object value, String message) {
        super(RestErrorStatus.JSON_PARSE_LIST, RestError.error(resource, value, RestErrorStatus.JSON_PARSE_LIST, message));
    }

    @Override
    public JsonParseListException get() {
        return new JsonParseListException();
    }

    @Override
    public String name() {
        return RestErrorStatus.JSON_PARSE_LIST.name();
    }
}
