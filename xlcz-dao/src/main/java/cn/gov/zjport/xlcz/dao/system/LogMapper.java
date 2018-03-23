package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.dto.LogDto;
import cn.gov.zjport.xlcz.domain.vo.Log;

import java.util.List;

public interface LogMapper {
    /**
     * 物理删除
     *
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param log 日志
     * @return
     */
    int insertSelective(Log log);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return
     */
    Log selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param log 日志
     * @return int
     */
    int updateByPrimaryKeySelective(Log log);

    /**
     * 分页查询
     *
     * @param logDto 日志查询对象
     * @return List<LogDto>
     */
    List<LogDto> findByPage(LogDto logDto);
}