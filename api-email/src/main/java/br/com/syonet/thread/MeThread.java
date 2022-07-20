package br.com.syonet.thread;

import java.time.LocalTime;

public class MeThread extends Thread {

	String name;
	Long timeForSleep;

	public MeThread(String name, Long timeForSleep) {
		this.name = name;
		this.timeForSleep = timeForSleep;
	}

	public MeThread(String name) {
		this.name = name;
	}

//	public void runTimer(Long timeToSleep) {
//		Main main = new Main();
//		try {
//			this.sleep(timeToSleep);
//			main.execute();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	public void run() {
//		TimeOfMachine time = new TimeOfMachine();
		LocalTime time = LocalTime.now();
		Integer horasSistema = time.getHour();
		Integer minutosSistema = time.getMinute();
		Integer minutos=50;
		Integer horas=1;
		while ((horasSistema != horas) || (minutosSistema != minutos)) {
			try {
				System.out.println("Dormindo Hora: " + horasSistema + ":" + minutosSistema); 
				System.out.println(" Hora para Executar " + horas +":"+ minutos);
				sleep(60000);
				horasSistema = time.getHour();
				minutosSistema = time.getMinute();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Teste");
		
	}
}
