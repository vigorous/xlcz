package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    /**
     * 分页查询部门
     *
     * @param dept 部门对象
     * @return List<Dept>
     */
    List<Dept> findByPage(Dept dept);

    /**
     * 通过部门名称查询部门
     *
     * @param dept 部门对象
     * @return List<Dept>
     */
    List<Dept> findByDeptName(Dept dept);

    /**
     * 部门下拉框
     *
     * @return List<DeptJo>
     */
    List<DeptJo> findAll();
}