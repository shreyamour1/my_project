package com.radiusAgent.demo.utility;

public class Utility {

	// haversine formula to get distance between given latitudes and longitudes
	public static double getDistanceFromLatLonInMiles(double reqLatitude,
			double reqLongitude, double propertyLatitude,
			double propertyLongitude) {

		reqLatitude = Math.toRadians(reqLatitude);
		reqLongitude = Math.toRadians(reqLongitude);
		propertyLatitude = Math.toRadians(propertyLatitude);
		propertyLongitude = Math.toRadians(propertyLongitude);

		double longitudeDifference = propertyLongitude - reqLongitude;
		double latitudeDifference = propertyLatitude - reqLatitude;

		double a = Math.pow(Math.sin(latitudeDifference / 2), 2)
				+ Math.cos(propertyLatitude) * Math.cos(reqLatitude)
				* Math.pow(Math.sin(longitudeDifference / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		double radius = 3956;// radius of earth in miles
		return (c * radius);

	}
}