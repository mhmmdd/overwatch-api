package net.overwatchapi;

public final class UrlConstants {

	public static final String ID = "/{id}";

	public static final String API = "/api";
	public static final String HERO = "/heros";
	public static final String API_HERO = API + HERO;
	public static final String ABILITY = "/abilities";
	public static final String API_ABILITY = API + ABILITY;


	private UrlConstants() {
		throw new IllegalStateException("UrlConstants not initable.");
	}
}
