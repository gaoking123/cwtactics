package net.wolfTec.loading;

import org.stjs.javascript.annotation.Namespace;

import net.wolfTec.cwt.util.AssertUtil;
import net.wolfTec.system.Logger;

@Namespace("cwt") public class GameLoaderBean {

	private Logger						log;

	private boolean						loaded;

	private GameConfigLoader	cfg;
	private AudioLoader				audio;

	public GameLoaderBean() {
		loaded = false;

		// initialize loaders
		cfg = new GameConfigLoader();
		audio = new AudioLoader();
	}

	/*
	 * 
	 * 1. Check base features 2. Check assets => Download assets into cache 3.
	 * Load assets from cache 4. Prepare stuff 5. DONE
	 */
	public void loadGame() {
		AssertUtil.isNot(loaded, true);

		log.info("Loading game data");

		loaded = true;
	}
}
