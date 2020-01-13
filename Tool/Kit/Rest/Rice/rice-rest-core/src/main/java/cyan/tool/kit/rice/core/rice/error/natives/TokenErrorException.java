package cyan.tool.kit.rice.core.rice.error.natives;

import cyan.tool.kit.rice.core.rice.defaults.RestError;
import cyan.tool.kit.rice.core.rice.defaults.RestErrorException;
import cyan.tool.kit.rice.core.rice.rest.RestErrorStatus;
import cyan.tool.kit.rice.core.rice.rest.RestStatus;

import java.util.Optional;

/**
 * <p>TokenErrorException</p>
 * @version V.0.0.1
 * @tokenor Cyan (snow22314@outlook.com)
 * @group cyan.tool.kit
 * @date 10:15 2019/12/19
 */
public class TokenErrorException extends RestErrorException {

    public TokenErrorException() {
        super(RestErrorStatus.TOKEN_ERROR);
    }

    public TokenErrorException(RestErrorStatus status) {
        super(status);
    }

    public TokenErrorException(String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(RestErrorStatus.TOKEN_ERROR, error));
    }

    public TokenErrorException(RestStatus status) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(status));
    }

    public TokenErrorException(RestStatus status, String error) {
        super(RestErrorStatus.TIME_OUT, RestError.error(status, error));
    }

    public TokenErrorException(String auth, String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(null, auth, null, RestErrorStatus.TOKEN_ERROR, error));
    }

    public TokenErrorException(String auth, Object token) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(null, auth, token, RestErrorStatus.TOKEN_ERROR));
    }

    public TokenErrorException(String auth, Object token, RestStatus status) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(null, auth, token, status));
    }

    public TokenErrorException(String auth, Object token, String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(null, auth, token, RestErrorStatus.TOKEN_ERROR, error));
    }

    public TokenErrorException(String auth, Object token, RestStatus status, String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(null, auth, token, status, error));
    }

    public TokenErrorException(String resource, String auth, Object token) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(resource, auth, token, RestErrorStatus.TOKEN_ERROR));
    }

    public TokenErrorException(String resource, String auth, Object token, RestStatus status) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(resource, auth, token, status));
    }

    public TokenErrorException(String resource, String auth, Object token, String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(resource, auth, token, RestErrorStatus.TOKEN_ERROR, error));
    }

    public TokenErrorException(String resource, String auth, Object token, RestStatus status, String error) {
        super(RestErrorStatus.TOKEN_ERROR, RestError.error(resource, auth, token, status, error));
    }

    @Override
    public TokenErrorException get() {
        return new TokenErrorException();
    }

    @Override
    public String getName() {
        return Optional.ofNullable((RestStatus) this.error).orElse(RestErrorStatus.TOKEN_ERROR).getName();
    }
}
