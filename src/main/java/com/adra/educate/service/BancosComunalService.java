package com.adra.educate.service;

import com.adra.educate.entity.BancosComunal;
import com.adra.educate.entity.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface BancosComunalService {

    List<BancosComunal> listBancoComunal();

    Optional<BancosComunal> findBancoComunal(Integer idBancoComunal);

    BancosComunal saveBancoComunal(BancosComunal bancosComunal);

    BancosComunal updateBancoComunal(Integer idBancoComunal, BancosComunal bancosComunal);

    BancosComunal deleteBancoComunal(Integer idBancoComunal);

}
