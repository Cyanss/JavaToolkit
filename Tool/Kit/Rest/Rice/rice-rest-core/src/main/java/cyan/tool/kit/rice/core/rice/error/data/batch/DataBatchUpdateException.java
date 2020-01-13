package cyan.tool.kit.rice.core.rice.error.data.batch;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;

/**
 * <p>DataBatchUpdateException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 14:13 2019/12/24
 */
public class DataBatchUpdateException extends RestErrorException {
    public DataBatchUpdateException() {
        super(RestErrorStatus.DATA_UPDATE_ALL_FAILED);
    }

    public DataBatchUpdateException(String resource) {
        super(RestErrorStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_UPDATE_ALL_FAILED));
    }

    public DataBatchUpdateException(String resource, String message) {
        super(RestErrorStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, RestErrorStatus.DATA_UPDATE_ALL_FAILED, message));
    }

    public DataBatchUpdateException(String resource, Object value, String message) {
        super(RestErrorStatus.DATA_UPDATE_ALL_FAILED, RestError.error(resource, value, RestErrorStatus.DATA_UPDATE_ALL_FAILED, message));
    }

    @Override
    public DataBatchUpdateException get() {
        return new DataBatchUpdateException();
    }

    @Override
    public String getName() {
        return RestErrorStatus.DATA_UPDATE_ALL_FAILED.getName();
    }
}
