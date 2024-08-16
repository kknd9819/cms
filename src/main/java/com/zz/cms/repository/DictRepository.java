package com.zz.cms.repository;

import com.zz.cms.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictRepository extends JpaRepository<Dict, String> {
    Dict findByDictCode(String dictCode);
}
