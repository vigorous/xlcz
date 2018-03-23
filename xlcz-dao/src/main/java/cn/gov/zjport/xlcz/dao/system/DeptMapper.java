package cn.gov.zjport.xlcz.dao.system;

import cn.gov.zjport.xlcz.domain.json.DeptJo;
import cn.gov.zjport.xlcz.domain.vo.Dept;

import java.util.List;

public interface DeptMapper {
    /**
     * 物理删除
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param dept 部门
     * @return int
     */
    int insertSelective(Dept dept);

    /**
     * 通过主键查询
     *
     * @param id 主键
     * @return Dept
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * 修改
     *
     * @param dept 部门
     * @return int
     */
    int updateByPrimaryKeySelective(Dept dept);

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