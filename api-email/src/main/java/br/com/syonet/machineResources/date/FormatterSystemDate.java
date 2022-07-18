package br.com.syonet.machineResources.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.syonet.client.model.Client;

public class FormatterSystemDate {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
	public Date dateOfBirthDay(Client client) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mmmm");
		Date dayOfBrithDay = formatter.parse(String.valueOf(client.getDt_nascimento()));

		return dayOfBrithDay;
	}
	public Date dayAndMounth() throws ParseException {
		
		Date dayAndMount = formatter.parse(String.valueOf(System.currentTimeMillis()));
		
		return dayAndMount;
	}
	
}
