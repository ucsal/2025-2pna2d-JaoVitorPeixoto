package br.com.mariojp.solid.dip;

public class EmailNotifier {
	private final MailSender smtp;

	public EmailNotifier(MailSender mailSender) {
		this.smtp = mailSender;
	}

	public void welcome(User user) {	
		smtp.send(user.email(), "Bem-vindo", "Olá " + user.name());
	}
}
