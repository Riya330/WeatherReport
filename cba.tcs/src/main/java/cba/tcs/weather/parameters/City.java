package cba.tcs.weather.parameters;

public class City {
	//private final double latitude;
	private final String cityName;
	//private final double longitude;

	
	public City(String cityName) {
		this.cityName = cityName;
	
	}

//	public double getLatitude() {
//		return latitude;
//	}
//
//	public double getLongitude() {
//		return longitude;
//	}

	public String getCityName() {
		return cityName;
	}

}
