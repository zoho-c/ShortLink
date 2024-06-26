package cn.zhouhao.shortlink.admin.common.convention.exception;

import cn.zhouhao.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import cn.zhouhao.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * @author hiroshi
 * @version 1.0
 */
public class RemoteException extends AbstractException {
    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
