package cn.tycoding.scst.common.security.exception;

import cn.tycoding.scst.common.core.constant.enums.ScstHttpStatus;
import cn.tycoding.scst.common.security.component.ScstOAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 身份认证异常
 *
 * @author tycoding
 * @date 2020/7/16
 * @see org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator
 */
@JsonSerialize(using = ScstOAuth2ExceptionSerializer.class)
public class BadClientCredentialsException extends ScstOAuth2Exception {

    public BadClientCredentialsException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return ScstHttpStatus.UNAUTHORIZED.getMsg();
    }

    @Override
    public int getHttpErrorCode() {
        return ScstHttpStatus.UNAUTHORIZED.getCode();
    }
}
