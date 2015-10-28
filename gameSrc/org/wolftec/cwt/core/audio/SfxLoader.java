package org.wolftec.cwt.core.audio;

import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.wolftec.cwt.core.Option;
import org.wolftec.cwt.core.loading.DataLoader;
import org.wolftec.cwt.core.persistence.FileDescriptor;

public class SfxLoader implements DataLoader {

  @Override
  public String forPath() {
    return "audio/sfx";
  }

  @Override
  public void downloadRemoteFolder(FileDescriptor entryDesc, Callback1<Option<Object>> doneCb) {

  }

  @Override
  public void handleFolderEntry(FileDescriptor entryDesc, Object entry, Callback0 doneCb) {

  }

}
