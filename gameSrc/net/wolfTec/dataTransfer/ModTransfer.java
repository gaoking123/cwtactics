package net.wolfTec.dataTransfer;

import net.wolfTec.Constants;
import net.wolfTec.bridges.Globals;
import net.wolfTec.model.Modification;
import net.wolfTec.utility.Debug;
import net.wolfTec.utility.ExternalRequest;
import net.wolfTec.utility.Storage;
import net.wolfTec.utility.ExternalRequest.ExternalRequestOptions;
import net.wolfTec.utility.Storage.StorageEntry;

import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

public class ModTransfer {

	public static final String KEY_MODIFICATION = "__modification__";

	public Modification cachedMod;

	public void transferGameModFromRemote(Callback0 callback) {
		ExternalRequestOptions data = new ExternalRequestOptions();
		
		data.json = true;
		data.path = Constants.DEFAULT_MOD_PATH;

		data.success = Globals.bindedFunction(new Callback1<Object>() {
			@Override public void $invoke(Object mod) {
				cachedMod = (Modification) mod;
				Storage.set(KEY_MODIFICATION, mod, (Callback2<Object, Object>) callback);
			}
		}, this);

		data.error = Globals.bindedFunction(new Callback1<Object>() {
			@Override public void $invoke(Object arg0) {
				Debug.logCritical(null, "Failed to loadGameConfig mod");
				cachedMod = null;
			}
		}, this);

		ExternalRequest.doHttpRequest(data);
	}

	public void transferGameModFromCache(Callback0 callback) {
		Storage.get(KEY_MODIFICATION, Globals.bindedFunction(new Callback1<Storage.StorageEntry>() {
			@Override public void $invoke(StorageEntry entry) {
				cachedMod = (Modification) entry.value;
				if (callback != null)
					callback.$invoke();
			}
		}, this));
	}
}
