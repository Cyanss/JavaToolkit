package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>AuthErrorException</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:56 2019/12/19
 */
public class AuthErrorException extends RestErrorException {

    public AuthErrorException() {
        super(RestErrorStatus.AUTH_ERROR);
    }

    public AuthErrorException(RestErrorStatus status) {
        super(status);
    }

    public AuthErrorException(String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(RestErrorStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(RestStatus status) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(status));
    }

    public AuthErrorException(RestStatus status, String error) {
        super(RestErrorStatus.AUTH_ERROR,RestError.error(status, error));
    }

    public AuthErrorException(String user, String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(null, user, null, RestErrorStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String user, Object auth) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(null, user, auth, RestErrorStatus.AUTH_ERROR));
    }

    public AuthErrorException(String user, Object auth, RestStatus status) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(null, user, auth, status));
    }

    public AuthErrorException(String user, Object auth, String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(null, user, auth, RestErrorStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String user, Object auth, RestStatus status, String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(null, user, auth, status, error));
    }

    public AuthErrorException(String resource, String user, Object auth) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(resource, user, auth, RestErrorStatus.AUTH_ERROR));
    }

    public AuthErrorException(String resource, String user, Object auth, RestStatus status) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(resource, user, auth, status));
    }

    public AuthErrorException(String resource, String user, Object auth, String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(resource, user, auth, RestErrorStatus.AUTH_ERROR, error));
    }

    public AuthErrorException(String resource, String user, Object auth, RestStatus status, String error) {
        super(RestErrorStatus.AUTH_ERROR, RestError.error(resource, user, auth, status, error));
    }

    @Override
    public AuthErrorException get() {
        return new AuthErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.AUTH_ERROR).getName();
    }
}
