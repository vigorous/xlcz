package cn.gov.zjport.xlcz.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类BaseVo
 *
 * @author <a href="mailto:cjun@zjport.gov.cn">cjun</a>
 * @version $Id$
 * @since 1.0
 */
public abstract class BaseVo extends PageSo implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 5905628003360925229L;
    /** 主键ID */
    private Integer id;
    /** 备注 */
    private String remark;
    /** 删除标志（0-未删除，1-已删除） */
    private String deletedFlag;
    /** 创建人 */
    private Integer createId;
    /** 创建时间 */
    private Date createTime;
    /** 修改人 */
    private Integer modifyId;
    /** 修改时间 */
    private Date modifyTime;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the deletedFlag
     */
    public String getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * @param deletedFlag the deletedFlag to set
     */
    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    /**
     * @return the createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * @param createId the createId to set
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyId
     */
    public Integer getModifyId() {
        return modifyId;
    }

    /**
     * @param modifyId the modifyId to set
     */
    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
