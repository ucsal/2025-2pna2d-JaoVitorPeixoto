import br.com.mariojp.solid.dip.*;

public class Main {
	public static void main(String[] args) {
		System.setProperty("DRY_RUN", "true"); // desejável não chamar SMTP
		MailSender sender;
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			sender = new NoopMailSender();
		} else {
			sender = new SmtpMailSender(new SmtpClient());
		}
		var notifier = new EmailNotifier(sender);
		// Estado inicial: vai lançar IllegalStateException (SMTP indisponível)
		notifier.welcome(new User("Ana", "ana@example.com"));
		System.out.println("Email enviado!");
	}
}
