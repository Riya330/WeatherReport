package cba.tcs.weather.parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityReader {

	private final String filename;
	String row;

	public CityReader(String filename) {
		this.filename = filename;
	}

	public List<City> readAll() throws IOException {
		List<City> list = new ArrayList<City>();

		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));

		while ((row = reader.readLine()) != null) {
			String[] data = row.split(",");

			list.add(new City(data[1]));
		}

		reader.close();

		return list;
	}

}