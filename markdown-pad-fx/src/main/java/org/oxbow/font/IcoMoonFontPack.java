package org.oxbow.font;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;

import org.controlsfx.iconfont.IconFontPack;
import org.controlsfx.iconfont.IconFontRegistry;

public class IcoMoonFontPack extends IconFontPack {
	
	public static String fontName = "icomoon";
	
    private Map<String, Character> glyphs;
	
	public static enum Glyph {
		
		NEW_DOC('\ue024'),
		FOLDER_OPEN('\ue02f'),
		DISK('\ue060'),
		CUT('\ue13e'),
		COPY('\ue027'),
		PASTE('\ue02b'),
		
		BOLD('\ue027'),
		UNDERSCORED('\ue02b'),
		ITALIC('\ue13e');
		
        private final Character ch;
		
		Glyph( Character ch ) {
			this.ch = ch;
		}
		
		public Character getChar() {
			return ch;
		}
		
		public Node create() {
		    return IconFontRegistry.glyph(fontName, name());
		}
	};
	

	public IcoMoonFontPack() {
		super(fontName, IcoMoonFontPack.class.getResourceAsStream("/icomoon.ttf"));
		
		Map<String, Character> map = new HashMap<>();
		for (Glyph e:  Glyph.values()) {
			map.put(e.name(), e.getChar());
		}
		glyphs = Collections.unmodifiableMap(map);
	}

	@Override
	public Map<String, Character> getGlyphs() {
		return glyphs;
	}

}
