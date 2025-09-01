package br.com.mariojp.solid.dip;

public class SmtpMailSender implements MailSender {
    private final SmtpClient smtp;

    public SmtpMailSender(SmtpClient smtpClient) {
        this.smtp = smtpClient;
    }
    
    public void send(String to, String subject, String body) {
        smtp.send(to, subject, body);
    }

}
