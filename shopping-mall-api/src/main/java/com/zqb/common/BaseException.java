package com.zqb.common;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.util.*;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/7/25
 *
 * @author zengqb
 * @version 1.0
 */
public class BaseException extends Exception {
    private Logger logger = Logger.getLogger(this.getClass());
    public static final int WARN = 4;
    public static final int ERROR = 5;
    private static final long serialVersionUID = 200901080101009010L;
    private static final String CRLT_DELIM = "\n";
    protected String errName;
    protected int level = 5;
    protected String errCode;
    protected String errDesc;
    protected HashMap<String, String> context = null;
    protected ArrayList<String> listMessage;
    protected boolean printFlag = true;

    public BaseException(String errName, String message, Throwable cause) {
        super(message, cause);
        this.context = null;
        this.listMessage = null;
        if (errName != null && errName.length() != 0) {
            this.setErrName(errName);
        } else if (cause instanceof BaseException) {
            this.errName = ((BaseException) cause).getErrName();
            this.errCode = ((BaseException) cause).getErrCode();
            this.errDesc = ((BaseException) cause).getErrDesc();
        } else {
            this.setErrName((String) null);
        }

        if (cause instanceof VirtualMachineError) {
            logger.error(this);
        }

    }

    public BaseException(String errName, Throwable cause) {
        super(cause);
        this.context = null;
        this.listMessage = null;
        if (errName != null && errName.length() != 0) {
            this.setErrName(errName);
        } else if (cause instanceof BaseException) {
            this.errName = ((BaseException) cause).getErrName();
            this.errCode = ((BaseException) cause).getErrCode();
            this.errDesc = ((BaseException) cause).getErrDesc();
        } else {
            this.setErrName((String) null);
        }

        if (cause instanceof VirtualMachineError) {
            logger.error(this);
        }

    }

    public BaseException(String errName, String message) {
        super(message);
        this.context = null;
        this.listMessage = null;
        this.setErrName(errName);
    }

    public BaseException(String errName) {
        this.context = null;
        this.listMessage = null;
        this.setErrName(errName);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
        this.context = null;
        this.listMessage = null;
        this.setErrName(this.errName);
    }

    public BaseException() {
        this.context = null;
        this.listMessage = null;
        this.setErrName((String) null);
    }

    public String getErrName() {
        return this.errName;
    }

    private void setErrName(String errName) {
        if (errName != null && errName.length() != 0) {
            int ptr = errName.indexOf(58);
            if (ptr > 0) {
                this.errName = "NA";
                this.errCode = errName.substring(0, ptr);
                this.errDesc = errName.substring(ptr + 1);
            } else {
                this.errName = errName;
                this.errCode = errName;
                this.errDesc = "";
            }
        } else {
            this.errName = "NA";
            this.errCode = "999999";
            this.errDesc = "";
        }

    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getErrDesc() {
        return this.errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void addMessage(String message) {
        if (this.listMessage == null) {
            this.listMessage = new ArrayList();
        }

        this.listMessage.add(message);
    }

    public void addMessage(String className, String message) {
        if (this.listMessage == null) {
            this.listMessage = new ArrayList();
        }

        this.listMessage.add(className + " : " + message);
    }

    @Override
    public String getMessage() {
        StringBuilder str = new StringBuilder(64);
        String s = super.getMessage();
        if (s != null) {
            str.append(s);
        }

        if (this.listMessage != null) {
            for (int ii = 0; ii < this.listMessage.size(); ++ii) {
                str.append("\n").append((String) this.listMessage.get(ii));
            }
        }

        return str.toString();
    }

    public String getExceptionMessage() {
        return super.getMessage();
    }

    public List<String> getListMessage() {
        return this.listMessage;
    }

    public void putValue(String name, String value) {
        if (this.context == null) {
            this.context = new HashMap();
        }

        this.context.put(name, value);
    }

    public HashMap<String, String> getContext() {
        return this.context;
    }

    @Override
    public String toString() {
        StringBuilder errLog = new StringBuilder();
        errLog.append("错误代码：").append(this.errCode).append("\n");
        errLog.append("错误描述：").append(this.errDesc).append("\n");
        errLog.append("错误信息：").append(super.getMessage()).append("\n");
        if (this.listMessage != null) {
            for (int c = 0; c < this.listMessage.size(); ++c) {
                errLog.append("  >>：").append((String) this.listMessage.get(c)).append("\n");
            }
        }

        if (this.context != null) {
            errLog.append("错误时上下文信息:\n");
            Set var6 = this.context.entrySet();
            Iterator var3 = var6.iterator();

            while (var3.hasNext()) {
                Map.Entry e = (Map.Entry) var3.next();
                String value = (String) e.getValue();
                if (value != null) {
                    errLog.append("  >>:").append((String) e.getKey()).append(" = ").append(value).append("\n");
                }
            }
        }

        Throwable var7 = this.getCause();
        if (var7 != null) {
            errLog.append("错误原因:").append("\n");
            errLog.append(var7.toString());
        }

        return errLog.toString();
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        if (this.printFlag) {
            this.printFlag = false;
            super.printStackTrace(s);
        }

    }
}
