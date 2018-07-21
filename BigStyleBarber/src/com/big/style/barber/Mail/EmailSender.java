package com.big.style.barber.Mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.big.style.barber.dao.ParametroDAO;
import com.big.style.barber.utils.ConstantesDominio;
import com.big.style.barber.utils.MailEvent;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class EmailSender {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
//	public static void main(String args[]) throws AddressException, MessagingException {
//		generateAndSendEmail();
//		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
//	}	
 
	public static void generateAndSendEmail(MailEvent event) throws AddressException, MessagingException {
		ParametroDAO parametroDAO = new ParametroDAO();
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		Calendar c = Calendar.getInstance();
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		String remitente = parametroDAO.consultarParametro(ConstantesDominio.MAIL_FROM).getPsValorParametro();  //Para la dirección nomcuenta@gmail.com
		String password = parametroDAO.consultarParametro(ConstantesDominio.MAIL_PASSWORD).getPsValorParametro();
		
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(event.getDireccionDestino()));
		generateMailMessage.setSubject(event.getAsunto());
		String emailBody = event.getCuerpoMensaje();
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		System.out.println(f.format(new Date()));
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", remitente, password);
		System.out.println(f.format(new Date()));
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		System.out.println(f.format(new Date()));
		transport.close();
		System.out.println(f.format(new Date()));
		System.out.println("Termino de enviar");
	}
}