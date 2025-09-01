package br.com.mariojp.solid.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailNotifierTest {
    @Test
    void dry_run_should_not_touch_smtp() {
        System.setProperty("DRY_RUN", "true");
        System.clearProperty("SMTP_AVAILABLE");
        MailSender sender;
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			sender = new NoopMailSender();
		} else {
			sender = new SmtpMailSender(new SmtpClient());
		}
        var notifier = new EmailNotifier(sender);
        assertDoesNotThrow(() -> notifier.welcome(new User("Ana", "ana@example.com")),
                "Após refatoração (DIP), DRY_RUN deve evitar SMTP real");
    }
}
