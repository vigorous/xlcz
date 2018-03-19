/**************************************************************************
 * Copyright (c) 2006-2018 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：西柳场站管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package cn.gov.zjport.xlcz.common.context;

/**
 * 系统上下文
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public class SystemContext {

    public static final String SAVE_SUCCESS = "SAVE_SUCCESS";
    public static final String SAVE_FAIL = "SAVE_FAIL";
    public static final String MODIFY_SUCCESS = "MODIFY_SUCCESS";
    public static final String MODIFY_FAIL = "MODIFY_FAIL";
    public static final String DELETE_SUCCESS = "DELETE_SUCCESS";
    public static final String DELETE_FAIL = "DELETE_FAIL";

    public static final Integer CODE_SUCCESS = 1;
    public static final Integer CODE_FAIL = 0;
    public static final Integer CODE_SAME = 2;

    /**
     * 操作类型
     *
     * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
     * @version $Id$
     * @since 1.0
     */
    public enum MessageType {
        /** 操作类型 */
        SAVE_SUCCESS("SAVE_SUCCESS", "保存成功"),
        SAVE_FAIL("SAVE_FAIL", "保存失败"),
        MODIFY_SUCCESS("MODIFY_SUCCESS", "修改成功"),
        MODIFY_FAIL("MODIFY_FAIL", "修改失败"),
        DELETE_SUCCESS("DELETE_SUCCESS", "删除成功"),
        DELETE_FAIL("DELETE_FAIL", "删除失败");

        /** 值 */
        private String value;
        /** 标题 */
        private String title;

        /**
         * 方法说明：
         *
         * @param value 参数
         * @param title 参数
         */
        MessageType(String value, String title) {
            this.value = value;
            this.title = title;
        }

        /**
         * @return 标题
         */
        public String getTitle() {
            return this.title;
        }

        /**
         * @return 值
         */
        public String getValue() {
            return this.value;
        }

        /**
         * 方法说明：
         *
         * @param i 参数
         * @return 枚举值
         */
        public static MessageType parse(String i) {
            for (MessageType v : MessageType.values()) {
                if (v.value.equals(i)) {
                    return v;
                }

            }
            return null;
        }
    }
}
