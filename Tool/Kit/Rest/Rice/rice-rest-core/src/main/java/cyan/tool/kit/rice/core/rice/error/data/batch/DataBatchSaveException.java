package cyan.tool.kit.rice.core.rice.error.data.batch;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>DataBatchSaveException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:14 2019/12/24
 */
public class DataBatchSaveException extends RestErrorException {
    public DataBatchSaveException() {
        super(RestErrorStatus.DATA_SAVE_ALL_FAILED);
    }

    public DataBatchSaveException(String resource) {
        super(RestErrorStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_SAVE_ALL_FAILED));
    }

    public DataBatchSaveException(String resource, String message) {
        super(RestErrorStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_SAVE_ALL_FAILED, message));
    }

    public DataBatchSaveException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_SAVE_ALL_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_SAVE_ALL_FAILED, message));
    }

    @Override
    public DataBatchSaveException get() {
        return new DataBatchSaveException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_SAVE_ALL_FAILED.getName();
    }
}