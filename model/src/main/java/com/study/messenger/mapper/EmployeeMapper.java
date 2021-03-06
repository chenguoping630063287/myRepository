package com.study.messenger.mapper;

import com.study.messenger.entiry.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}