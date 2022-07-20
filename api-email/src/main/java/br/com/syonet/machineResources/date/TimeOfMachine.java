package br.com.syonet.machineResources.date;

import java.util.Date;

public class TimeOfMachine {
	private static Date time = new Date();
	private static Integer hours;
	private static Integer minutes;

	public Integer[] time() {

		this.hours = getTime().getHours();
		this.minutes = getTime().getMinutes();

		Integer[] timeTimer = { hours, minutes };

		return timeTimer;

	}

	public Integer getHours() {
		return hours;
	}

	public static Integer getMinutes() {
		return minutes;
	}

	public static Date getTime() {
		return time;

	}

	public static void setTime(Date time) {
		TimeOfMachine.time = time;

	}
}
