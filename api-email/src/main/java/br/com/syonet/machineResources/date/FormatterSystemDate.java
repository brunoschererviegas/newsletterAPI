package br.com.syonet.machineResources.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.syonet.client.model.Client;

public class FormatterSystemDate {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
	

	public Date dateOfBirthDay(Client client) throws ParseException {
		System.out.println("before date");
		Date dayOfBrithDay = new Date(client.getDt_nascimento());
		System.out.println("after date\n" + dayOfBrithDay);
		return dayOfBrithDay;
	}
	public Date dayAndMounth() throws ParseException {
		
		Date dayAndMount = new Date(System.currentTimeMillis());
		
		return dayAndMount;
	}
	
}
