package com.projeto.alfaeduca.domain.usuario.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projeto.alfaeduca.domain.usuario.UserAccount;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendWelcomeEmail(UserAccount user) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getLogin());
        message.setFrom("AlfaEduca <appalfaeduca@gmail.com>");
        message.setSubject("Bem-vindo ao nosso serviço!");
        message.setText("Olá " + user.getNome() + ",\n\nObrigado por se cadastrar em nosso serviço. Estamos felizes em tê-lo conosco.\n\nAtenciosamente,\nEquipe do Serviço");
        emailSender.send(message);
    }

    public void sendResetPasswordEmail(UserAccount user, String novaSenha){
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getLogin());
        message.setFrom("AlfaEduca <appalfaeduca@gmail.com>");
        message.setSubject("Redefinição de senha");
        message.setText("Olá " + user.getNome() + ",\n\nVocê solicitou a redefinição de sua senha. Para isso, sua nova senha é "+novaSenha+"\n\nAtenciosamente,\nEquipe do Serviço");
        emailSender.send(message);
    }

    public void sendPasswordChangeEmail(UserAccount user){
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getLogin());
        message.setFrom("AlfaEduca <appalfaeduca@gmail.com>");
        message.setSubject("Alteração de senha");
        message.setText("Olá " + user.getNome() + ",\n\nSua senha foi alterada com sucesso.\n\nAtenciosamente,\nEquipe do Serviço");
        emailSender.send(message);
    }

    public void sendAccountDeletionEmail(UserAccount user){
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(user.getLogin());
        message.setFrom("AlfaEduca <appalfaeduca@gmail.com>");
        message.setSubject("Exclusão de conta");
        message.setText("Olá " + user.getNome() + ",\n\nSua conta foi excluída com sucesso.\n\nAtenciosamente,\nEquipe do Serviço");
        emailSender.send(message);
    }
}