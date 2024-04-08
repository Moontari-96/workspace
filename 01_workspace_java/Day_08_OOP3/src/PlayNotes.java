import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class PlayNotes {
	public static void main(String[] args) {
		// 입력으로 받은 문자열에 따라 도레미파솔라시도 음계를 생성
		if (args.length != 1) {
			System.out.println("Usage: java PlayNotes <notes>");
			System.out.println("Example: java PlayNotes CDEFGABC");
			return;
		}

		try {
			// 오디오 포맷 설정
			AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

			// 오디오 라인 열기
			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(audioFormat);
			line.start();

			// 입력된 문자열을 기반으로 도레미파솔라시도 음계 생성 및 재생
			String notesString = args[0].toUpperCase();
			for (char note : notesString.toCharArray()) {
				if (note >= 'A' && note <= 'G') {
					double frequency = getFrequency(note);
					playSound(line, frequency, 500);
				}
			}

			// 오디오 라인 닫기
			line.drain();
			line.close();

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	// 주파수 계산
	private static double getFrequency(char note) {
		switch (note) {
		case 'C':
			return 261.63;
		case 'D':
			return 293.66;
		case 'E':
			return 329.63;
		case 'F':
			return 349.23;
		case 'G':
			return 392.00;
		case 'A':
			return 440.00;
		case 'B':
			return 493.88;
		default:
			return 0;
		}
	}

	// 주어진 오디오 라인에서 주파수와 지속시간에 따라 소리를 재생하는 메서드
	private static void playSound(SourceDataLine line, double frequency, int duration) {
		int sampleRate = 44100;
		int numSamples = duration * sampleRate / 1000;
		byte[] buffer = new byte[2 * numSamples];

		for (int i = 0; i < numSamples; i++) {
			double angle = 2.0 * Math.PI * i / (sampleRate / frequency);
			short sample = (short) (Short.MAX_VALUE * Math.sin(angle));
			buffer[2 * i] = (byte) (sample & 0xFF);
			buffer[2 * i + 1] = (byte) ((sample >> 8) & 0xFF);
		}
		line.write(buffer, 0, buffer.length);
	}
}