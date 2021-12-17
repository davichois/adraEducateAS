package com.adra.educate.service.implementation;

import com.adra.educate.entity.BCC;
import com.adra.educate.repository.BCCRepository;
import com.adra.educate.service.BCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BCCServiceImp implements BCCService {

    @Autowired
    private BCCRepository bccRepository;

    @Override
    public BCC saveBCC(Integer idBanco, Integer idCapacitacion) {
        return bccRepository.saveBCC(idBanco, idCapacitacion);
    }

}
