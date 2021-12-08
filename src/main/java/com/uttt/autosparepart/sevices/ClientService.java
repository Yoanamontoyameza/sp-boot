package com.uttt.autosparepart.sevices;

import com.uttt.autosparepart.entities.ClientDO;
import com.uttt.autosparepart.entities.CodeDO;
import com.uttt.autosparepart.entities.ResponseTO;
import com.uttt.autosparepart.repository.ClientRepository;
import com.uttt.autosparepart.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Random;

@Service
public class ClientService implements ClientServiceI {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    CodeRepository codeRepository;

    public Random rand = new Random();

    @Override
    public ClientDO save(ClientDO clientDO) {
        try {
            ClientDO client = this.clientRepository.findByEmail(clientDO.getEmail());
            if (null == client) {
                return clientRepository.save(clientDO);
            }
            throw new Exception("Este usuario ya se encuentra registrado");
        } catch (Exception error) {
            throw new NullPointerException(error.getLocalizedMessage());
        }

    }

    @Override
    public ClientDO update(ClientDO clientDO) {
         return clientRepository.save(clientDO);
    }

    @Override
    public ClientDO login(String email, String password) {

        ClientDO clientDO = this.clientRepository.findByEmail(email);
        try {
            if (clientDO != null) {
                if (clientDO.getPassword().equals(password)) {
                    return clientDO;
                } else {
                    throw new Exception("Usuario no encontrado");
                }
            }
            throw new Exception("Usuario no encontrado");
        } catch (Exception error) {
            throw new NullPointerException(error.getLocalizedMessage());
        }
    }


    @Override
    public void sendSimpleMessage(String email, String code) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setTo(email);
            helper.setSubject("Recuperar contraseña");
            helper.setText(code, true);
            mailSender.send(message);
        } catch (Exception error) {
            throw new NullPointerException("No se pudo enviar el email");
        }
    }

    @Override
    public ResponseTO sendCode(String email) {
        try {
            boolean existClient = this.clientRepository.existsByEmail(email);
            if (existClient) {
                String code = generateCode();
                sendSimpleMessage(email, code);
                CodeDO codeDO = new CodeDO();
                codeDO.setUser_dx(email);
                codeDO.setCode(code);
                codeDO.setDate(LocalDate.now());
                CodeDO save = codeRepository.save(codeDO);
                ResponseTO response = new ResponseTO();
                if (save != null) {
                    response.setMessage("Codigo enviado");
                    response.setStatus(true);
                    return response;
                } else {
                    throw new Exception("Error al guardar el codigo");
                }
            }
            throw new Exception("Usuario no encontrado");
        } catch (Exception error) {
            throw new NullPointerException(error.getLocalizedMessage());
        }

    }

    @Override
    public ResponseTO verifyCode(String email) {
        try {
            ResponseTO response = new ResponseTO();
            String verify = this.codeRepository.getTopCode(email);
            if (null != verify) {
                response.setMessage("Codigo generado");
                response.setStatus(true);
                return response;
            }
            throw new Exception("Codigo incorrecto");
        } catch (Exception error) {
            throw new NullPointerException(error.getLocalizedMessage());
        }
    }

    @Override
    public String generateCode() {
        return String.format("%04d", rand.nextInt(10000));
    }

    @Override
    public ResponseTO restorePassword(ClientDO clientDO) {
        try {
            ResponseTO response = new ResponseTO();
            ClientDO byEmail = this.clientRepository.findByEmail(clientDO.getEmail());
            byEmail.setPassword(clientDO.getPassword());
            this.clientRepository.save(byEmail);
            response.setMessage("Contraseña actualizada");
            response.setStatus(true);
            return response;
        } catch (Exception error) {
            throw new NullPointerException(error.getLocalizedMessage());
        }
    }


}
