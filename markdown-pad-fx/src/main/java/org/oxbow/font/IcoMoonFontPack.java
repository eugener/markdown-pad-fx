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
		
		HOME        ('\ue000'),
		HOME2       ('\ue001'),
		HOME3       ('\ue002'),
		OFFICE      ('\ue003'),
		NEWSPAPER   ('\ue004'),
		PENCIL      ('\ue005'),
		PENCIL2     ('\ue006'),
		QUILL       ('\ue007'),
		PEN         ('\ue008'),
		BLOG        ('\ue009'),
		DROPLET     ('\ue00a'),
		PAINT_FORMAT('\ue00b'),
		IMAGE       ('\ue00c'),
		IMAGE2      ('\ue00d'),
		IMAGES      ('\ue00e'),
		CAMERA      ('\ue00f'),
		MUSIC       ('\ue010'),
		HEADPHONES  ('\ue011'),
		PLAY        ('\ue012'),
		FILM        ('\ue013'),
		CAMERA2     ('\ue014'),
		DICE        ('\ue015'),
		PACMAN      ('\ue016'),
		SPADES      ('\ue017'),
		CLUBS       ('\ue018'),
		DIAMONDS    ('\ue019'),
		PAWN        ('\ue01a'),
		BULLHORN    ('\ue01b'),
		CONNECTION  ('\ue01c'),
		PODCAST     ('\ue01d'),
		FEED        ('\ue01e'),
		BOOK        ('\ue01f'),
		BOOKS       ('\ue020'),
		LIBRARY     ('\ue021'),
		FILE        ('\ue022'),
		PROFILE     ('\ue023'),
		FILE2       ('\ue024'),
		FILE3       ('\ue025'),
		FILE4       ('\ue026'),
		COPY        ('\ue027'),
		COPY2       ('\ue028'),
		COPY3       ('\ue029'),
		PASTE       ('\ue02a'),
		PASTE2      ('\ue02b'),
		PASTE3      ('\ue02c'),
		STACK       ('\ue02d'),
		FOLDER      ('\ue02e'),
		FOLDER_OPEN ('\ue02f'),
		TAG         ('\ue030'),
		TAGS        ('\ue031'),
		BARCODE     ('\ue032'),
		QRCODE      ('\ue033'),
		TICKET      ('\ue034'),
		CART        ('\ue035'),
		CART2       ('\ue036'),
		CART3       ('\ue037'),
		COIN        ('\ue038'),
		CREDIT      ('\ue039'),
		
		DISK('\ue060'),
		SCISSORS('\ue13e'),
		
		BOLD('\ue144'),
		UNDERSCORED('\ue145'),
		ITALIC('\ue146');
		
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
