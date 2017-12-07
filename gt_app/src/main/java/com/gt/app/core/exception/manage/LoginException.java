package com.gt.app.core.exception.manage;

import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.common.exception.SystemException;

/**
 * @author psr
 *         Created by psr on 2017/10/10 0010.
 */
public class LoginException extends SystemException {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(int code, String message) {
        super(code, message);
    }

    public LoginException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
