package com.adra.educate.service.implementation;

import com.adra.educate.entity.BancosComunal;
import com.adra.educate.entity.BancosComunalReport;
import com.adra.educate.repository.BancosComunalReportRespository;
import com.adra.educate.repository.BancosComunalRepository;
import com.adra.educate.service.BancosComunalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancosComunalServiceImp implements BancosComunalService {

    @Autowired
    private BancosComunalRepository bancosComunalRepository;
    @Autowired
    private BancosComunalReportRespository bancosComunalReportRespository;


    @Override
    public List<BancosComunal> listBancoComunal() {
        return bancosComunalRepository.listBancoComunal();
    }

    @Override
    public Optional<BancosComunal> findBancoComunal(Integer idBancoComunal) {
        return bancosComunalRepository.findBancoComunal(idBancoComunal);
    }

    @Override
    public BancosComunal saveBancoComunal(BancosComunal bancosComunal) {
        return bancosComunalRepository.saveBancoComunal(bancosComunal.getNoBancoComunal(), bancosComunal.getIdBcDistrito());
    }

    @Override
    public BancosComunal updateBancoComunal(Integer idBancoComunal, BancosComunal bancosComunal) {
        return bancosComunalRepository.updateBancoComunal(idBancoComunal, bancosComunal.getNoBancoComunal(), bancosComunal.getIdBcDistrito());
    }

    @Override
    public BancosComunal deleteBancoComunal(Integer idBancoComunal) {
        return bancosComunalRepository.deleteBancoComunal(idBancoComunal);
    }

    @Override
    public List<BancosComunalReport> listBancosComunalReport() {
        return bancosComunalReportRespository.findAllBancosComunalReport();
    }
}
