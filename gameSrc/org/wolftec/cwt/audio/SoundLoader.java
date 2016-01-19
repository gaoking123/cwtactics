package org.wolftec.cwt.audio;

import org.wolftec.cwt.loading.DataGrabber;
import org.wolftec.cwt.loading.ResourceGrabbingType;
import org.wolftec.cwt.serialization.FileDescriptor;

class SoundLoader implements DataGrabber
{

  @Override
  public String getTargetFolder()
  {
    return "audio/sfx";
  }

  @Override
  public ResourceGrabbingType getFileType(FileDescriptor file)
  {
    return ResourceGrabbingType.TEXT_DATA;
  }

  @Override
  public void putDataIntoGame(FileDescriptor file, Object data)
  {
  }

}
