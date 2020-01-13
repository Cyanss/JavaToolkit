package cyan.tool.kit.rice.core.rice.error.supply;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

/**
 * <p>JsonParseException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 10:31 2019/12/20
 */
public class JsonParseException extends RestErrorException {
    public JsonParseException() {
        super(RestErrorStatus.JSON_PARSE_ERROR);
    }

    public JsonParseException(String resource, String json) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, json, RestErrorStatus.JSON_PARSE_ERROR));
    }

    public JsonParseException(String resource, String json, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, json, RestErrorStatus.JSON_PARSE_ERROR, message));
    }

    public JsonParseException(String resource, String json, String className, String message) {
        super(RestErrorStatus.JSON_PARSE_ERROR, RestError.error(resource, json, className, RestErrorStatus.JSON_PARSE_ERROR, message));
    }

    public JsonParseException(String resource, String json, RestStatus status, String message) {
        super(status, RestError.error(resource, json, status, message));
    }

    public JsonParseException(String resource, String json, String className, RestStatus status, String message) {
        super(status, RestError.error(resource, json, className, status, message));
    }

    @Override
    public JsonParseException get() {
        return new JsonParseException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.JSON_PARSE_ERROR.getName();
    }
}
