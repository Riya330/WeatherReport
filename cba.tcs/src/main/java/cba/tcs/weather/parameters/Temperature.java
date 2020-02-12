package cba.tcs.weather.parameters;

import java.time.LocalTime;

public class Temperature {

	private static final int[] TEMPERATURES = { 40, 35, 25, 20, 15, 5, 0, -10, -30, -40, -50 };
	private static final double MAX = 1.2;
	private static final double MIN = 0.7;
	private static final double TEMPERATURE_LAPSE = 0.006;

	public static double at(double latitude, int elevation, LocalTime time) {
		double base = calculateTemperaturePerLatitude(latitude);
		double atElevation = calculateTemperaturePerElevation(base, elevation);
		double atTime = calculateTemperaturePerTime(atElevation, time.toSecondOfDay() / 60);

		return atTime;
	}

	private static double calculateTemperaturePerTime(double temperature, int minutesOfDay) {
		final int halfDay = 12 * 60;
		final double max = temperature > 0 ? temperature * MAX : temperature * MIN;
		final double min = temperature > 0 ? temperature * MIN : temperature * MAX;
		final double degreesPerMinute = Math.abs((max - min) / halfDay);

		return max - (halfDay - minutesOfDay) * (degreesPerMinute);

	}

	private static double calculateTemperaturePerElevation(double base, int elevation) {
		return base - (elevation * TEMPERATURE_LAPSE);
	}

	private static double calculateTemperaturePerLatitude(double latitude) {
		int t = (int) Math.min(Math.abs(latitude), 90);
		int i = t / 10;
		double d = t % 10;

		return TEMPERATURES[i] + ((TEMPERATURES[i] - TEMPERATURES[i + 1]) * (d / 10.0));
	}

}
