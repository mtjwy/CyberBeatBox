package com.mtjwy.CyberBeatBox;

public class MiniMiniMusicAppTest {
	public static void main(String[] args) {
		MiniMiniMusicApp miniApp = new MiniMiniMusicApp();
		//miniApp.play();
		
		if (args.length < 2) {
			System.out.println("Don't forget the instrument and note args");
			
		} else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			miniApp.play(instrument, note);
		}
	}
}
