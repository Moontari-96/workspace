package dao;

import java.util.ArrayList;

import dto.MovieDTO;

public class MovieDAO {
	ArrayList<MovieDTO> movies = new ArrayList<>();

	public void addMoive(MovieDTO movie) {
		this.movies.add(movie);
	}

	public ArrayList<MovieDTO> getMovies() {
		return movies;
	}

	public ArrayList<MovieDTO> searchMovie(String target) {
		ArrayList<MovieDTO> result = new ArrayList<>();
		for (MovieDTO dto : movies) {
			if (dto.getTitle().contains(target)) {
				result.add(dto);
			}
		}
		return result;
	}

	public boolean deleteMovie(String target) {
		for (MovieDTO dto : movies) {
			if (dto.getId().equals(target)) {
				return movies.remove(dto);
			}
		}
		return false;
	}

	public boolean modifyMovie(MovieDTO dto) {
		for (MovieDTO dtos : movies) {
			if (dtos.getId().equals(dto.getId())) {
				dtos.setTitle(dto.getTitle());
				dtos.setGenre(dto.getTitle());
				dtos.setWrite_date(dto.getWrite_date());
				return true;
			}
		}
		return false;
	}
}
