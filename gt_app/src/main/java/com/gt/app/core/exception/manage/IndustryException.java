package com.gt.app.core.exception.manage;

import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.common.exception.SystemException;

/**
 * @author psr
 *         Created by psr on 2017/10/10 0010.
 */
public class IndustryException extends SystemException {

    public IndustryException(String message) {
        super(message);
    }

    public IndustryException(int code, String message) {
        super(code, message);
    }

    public IndustryException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
