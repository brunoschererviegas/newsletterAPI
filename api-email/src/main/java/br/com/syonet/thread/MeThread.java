//package br.com.syonet.thread;
//
//import java.time.LocalTime;
//
//import javax.enterprise.context.ApplicationScoped;
//
//import Main.Main;
//@ApplicationScoped
//public class MeThread extends Thread {
//
//	String name;
//	Long timeForSleep;
//
//	public MeThread(String name, Long timeForSleep) {
//		this.name = name;
//		this.timeForSleep = timeForSleep;
//	}
//
//	public MeThread(String name) {
//		this.name = name;
//	}
//
//	public void run() {
//		LocalTime time = LocalTime.now();
//		Integer horasSistema = time.getHour();
//		Integer minutosSistema = time.getMinute();
//		Integer minutos=50;
//		Integer horas=1;
//		while ((horasSistema != horas) || (minutosSistema != minutos)) {
//			try {
//				System.out.println("Dormindo Hora: " + horasSistema + ":" + minutosSistema); 
//				System.out.println(" Hora para Executar " + horas +":"+ minutos);
//				sleep(60000);
//				horasSistema = time.getHour();
//				minutosSistema = time.getMinute();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		Main main =new Main();
//		main.execute();
//		this.run();
//	}
//}
