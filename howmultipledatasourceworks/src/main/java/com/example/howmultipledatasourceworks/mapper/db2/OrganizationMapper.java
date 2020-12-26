package com.example.howmultipledatasourceworks.mapper.db2;

import com.example.howmultipledatasourceworks.model.db2.Organization;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationMapper {
    Organization selectById(@Param("id") long id);
}
