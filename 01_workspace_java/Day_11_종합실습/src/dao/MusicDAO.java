package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dto.MusicDTO;

public class MusicDAO {
	ArrayList<MusicDTO> music = new ArrayList<>();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public void addMusic(MusicDTO music) {
		this.music.add(music);
	}

	public ArrayList<MusicDTO> getMusic() {
		return this.music;
	}

	public ArrayList<MusicDTO> searchMusic(String title) {
		ArrayList<MusicDTO> result = new ArrayList<>();

		for (MusicDTO dto : music) {
			if (dto.getTitle().contains(title))
				result.add(dto);
		}
		return result;
	}

	public boolean removeMusic(String id) {
//		for (int i = 0; i < music.size(); i++) {
//			if (music.get(i).getId().equals(id)) {
//				music.remove(i);
//				break;
//			}
//		}
		for (MusicDTO dto : music) {
			if (dto.getId().equals(id)) {
				return music.remove(dto);
			}
		}
		return false;
	}

	public String writedate() {
		Date today = Calendar.getInstance().getTime();
		Calendar calendar = Calendar.getInstance();
		return simpleDateFormat.format(today);
	}

	public boolean modifyMusic(MusicDTO modify) {
		for (int i = 0; i < music.size(); i++) {
			if (music.get(i).getId().equals(modify.getId())) {
				music.get(i).setTitle(modify.getTitle());
				music.get(i).setSinger(modify.getSinger());
				music.get(i).setDate(modify.getDate());
				return true;
			}
		}
		return false;
	}

}
