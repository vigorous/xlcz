package cn.gov.zjport.xlcz.common.base;

/**
 * 统一返回结果类
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class BaseResult {
    /** 状态码：1成功，其他为失败 */
    public int code;

    /** 成功为success，其他为失败原因 */
    public String message;

    /** 数据结果集 */
    public Object data;

    /**
     * 有参构造
     *
     * @param code    状态码
     * @param message 成功或失败信息
     * @param data    数据结果集
     */
    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
