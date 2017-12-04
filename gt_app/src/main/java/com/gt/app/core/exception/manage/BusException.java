package com.gt.app.core.exception.manage;

import com.gt.app.common.enums.ResponseEnums;
import com.gt.app.common.exception.SystemException;

/**
 * @author psr
 *         Created by psr on 2017/10/10 0010.
 */
public class BusException extends SystemException {

    public BusException(String message) {
        super(message);
    }

    public BusException(int code, String message) {
        super(code, message);
    }

    public BusException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
