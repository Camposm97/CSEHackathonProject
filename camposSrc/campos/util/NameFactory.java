package campos.util;

import java.util.ArrayList;

import campos.models.FileBuilt;
import campos.models.Name;

public class NameFactory {
	private static final String BOY_NAMES_SRC = "resources/data/males";
	private static final String GIRL_NAMES_SRC = "resources/data/females";
	private static final String LAST_NAMES_SRC = "resources/data/last_names";
	private FileBuilt fbBoy, fbGirl, fbLast;

	public NameFactory() {	// Constructor
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

	public ArrayList<Name> emitNames(int n) {
		ArrayList<Name> nameList = new ArrayList<Name>(n);

		for (int i = 0; i < n; i++)
			if (i > (n / 2))
				nameList.add(new Name(emitLastName(), emitGirlName(), Gender.Female));
			else
				nameList.add(new Name(emitLastName(), emitBoyName(), Gender.Male));
		return nameList;
	}
}
