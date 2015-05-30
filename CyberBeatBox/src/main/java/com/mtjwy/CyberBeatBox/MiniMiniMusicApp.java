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
	
	public void play(int instrument, int note) {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			MidiEvent envent = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);//put Instruction in the Message,"start playing note 44"
										//message type, channel, note to play, velocity
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			
			//put in some MidiEvents
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);//put Instruction in the Message,"start playing note 44"
										//message type, channel, note to play, velocity
			MidiEvent noteOn = new MidiEvent(a, 1);//trigger a at beat 1
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);//16: duration
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}















