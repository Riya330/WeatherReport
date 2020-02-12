package cba.tcs.weather.parameters;

import java.util.Random;

public class RelativeHumidity {

	private final Random generator;

	public RelativeHumidity() {
		generator = new Random();
	}

	public double at(double latitude, double longitude) {
		return generator.nextInt(70) + 20.0;
	}

}
