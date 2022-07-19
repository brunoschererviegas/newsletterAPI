package br.com.syonet.machineResources.date;

import java.util.Date;

public class TimeOfMachine {
	static Date time = new Date();

	public static Integer[] time() {
		@SuppressWarnings("deprecation")
		Integer hours = time.getHours();
		@SuppressWarnings("deprecation")
		Integer minutes = time.getMinutes();

		Integer[] time = { hours, minutes };

		return time;

	}
}
