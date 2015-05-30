package com.mtjwy.CyberBeatBox;

import javax.sound.midi.*;

import org.junit.Test;

public class MiniMiniMusicApp {
	@Test
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			//put in some MidiEvents
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100);//put Instruction in the Message,"start playing note 44"
										//message type, channel, note to play, velocity
			MidiEvent noteOn = new MidiEvent(a, 1);//trigger a at beat 1
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);//16: duration
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}















