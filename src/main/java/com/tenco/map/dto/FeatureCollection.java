package com.tenco.map.dto;


import java.util.List;

public class FeatureCollection {

	private String type;
	private List<Feature> features;

	// Getters and Setters

	public static class Feature {
		private String type;
		private Geometry geometry;
		private Properties properties;

		// Getters and Setters

		public static class Geometry {
			private String type;
			private List<Double> coordinates;

			// Getters and Setters
		}

		public static class Properties {
			private int totalDistance;
			private int totalTime;
			private int index;
			private int pointIndex;
			private String name;
			private String description;
			private String direction;
			private String nearPoiName;
			private String nearPoiX;
			private String nearPoiY;
			private String intersectionName;
			private String facilityType;
			private String facilityName;
			private int turnType;
			private String pointType;
			private int lineIndex;
			private int distance;
			private int time;
			private int roadType;
			private int categoryRoadType;

			// Getters and Setters
		}
	}

}