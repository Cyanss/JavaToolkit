package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>FileErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:51 2019/12/19
 */
public class FileErrorException extends RestErrorException {

    public FileErrorException() {
        super(RestErrorStatus.FILE_ERROR);
    }

    public FileErrorException(RestErrorStatus status) {
        super(status);
    }

    public FileErrorException(String error) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(RestErrorStatus.FILE_ERROR,error));
    }

    public FileErrorException(RestStatus status) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(status));
    }

    public FileErrorException(RestStatus status, String error) {
        super(RestErrorStatus.FILE_ERROR,RestError.error(status, error));
    }

    public FileErrorException(String file, Object value) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, value, RestErrorStatus.FILE_ERROR));
    }

    public FileErrorException(String file, String error) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, RestErrorStatus.FILE_ERROR, error));
    }

    public FileErrorException(String file, Object value, String error) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, value, RestErrorStatus.FILE_ERROR, error));
    }

    public FileErrorException(String file, RestStatus status) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, status));
    }

    public FileErrorException(String file, Object value, RestStatus status) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, value, status));
    }

    public FileErrorException(String file, RestStatus status, String error) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, status, error));
    }

    public FileErrorException(String file, Object value, RestStatus status, String error) {
        super(RestErrorStatus.FILE_ERROR, RestError.error(file, value, status, error));
    }


    @Override
    public FileErrorException get() {
        return new FileErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.FILE_ERROR).getName();
    }
}
