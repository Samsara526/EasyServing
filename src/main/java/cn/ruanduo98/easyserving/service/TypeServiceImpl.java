package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.TypeRepository;
import cn.ruanduo98.easyserving.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
