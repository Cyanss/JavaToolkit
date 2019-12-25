package cyan.tool.kit.chip.core.rice.error.supply;

import cyan.tool.kit.chip.core.rice.defaults.RestError;
import cyan.tool.kit.chip.core.rice.defaults.RestErrorException;
import cyan.tool.kit.chip.core.rice.rest.RestResultStatus;

/**
 * <p>JsonDeserializeException</p>
 *
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 17:10 2019/12/25
 */
public class JsonDeserializeException extends RestErrorException {
    public JsonDeserializeException() {
        super(RestResultStatus.JSON_DESERIALIZE_ERROR);
    }

    public JsonDeserializeException(String message) {
        super(RestResultStatus.JSON_DESERIALIZE_ERROR, RestError.error(RestResultStatus.JSON_DESERIALIZE_ERROR, message));
    }

    @Override
    public JsonDeserializeException get() {
        return new JsonDeserializeException();
    }

    @Override
    public String getName() {
        return RestResultStatus.JSON_DESERIALIZE_ERROR.getName();
    }
}
