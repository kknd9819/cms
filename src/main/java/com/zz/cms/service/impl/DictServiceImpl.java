package com.zz.cms.service.impl;

import com.zz.cms.entity.Dict;
import com.zz.cms.repository.DictRepository;
import com.zz.cms.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {

    private final DictRepository dictRepository;

    @Override
    public Dict getByDictCode(String dictCode) {
        return dictRepository.findByDictCode(dictCode);
    }
}
