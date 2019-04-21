package utilities;

import models.FileBuilt;

public class NameFactory {
	private static final String BOY_NAMES_SRC = "resources/data/males";
	private static final String GIRL_NAMES_SRC = "resources/data/females";
	private static final String LAST_NAMES_SRC = "resources/data/last_names";
	private FileBuilt fbBoy, fbGirl, fbLast;
	
	public NameFactory() {
		fbBoy = new FileBuilt(BOY_NAMES_SRC);
		fbGirl = new FileBuilt(GIRL_NAMES_SRC);
		fbLast = new FileBuilt(LAST_NAMES_SRC);
	}
	
	public String emitBoyName() {
		return fbBoy.getRandomToken();
	}
	
	public String emitGirlName() {
		return fbGirl.getRandomToken();
	}
	
	public String emitLastName() {
		return fbLast.getRandomToken();
	}
}
