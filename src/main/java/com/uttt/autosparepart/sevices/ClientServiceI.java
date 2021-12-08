package com.uttt.autosparepart.sevices;

import com.uttt.autosparepart.entities.ClientDO;
import com.uttt.autosparepart.entities.ResponseTO;

public interface ClientServiceI {
    ClientDO save(ClientDO clientDO);
    ClientDO update(ClientDO clientDO);
    ClientDO login(String email, String password);
    void sendSimpleMessage(String email, String code);
    ResponseTO sendCode(String email);
    ResponseTO verifyCode(String email);
    String generateCode();
    ResponseTO restorePassword(ClientDO clientDO);
}
