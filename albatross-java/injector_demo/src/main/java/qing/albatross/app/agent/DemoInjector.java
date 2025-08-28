package qing.albatross.app.agent;

import android.app.Application;

import qing.albatross.core.Albatross;
import qing.albatross.exception.AlbatrossErr;

public class DemoInjector extends AlbatrossInjector {
  public DemoInjector(String libName, String argString, int flags) {
    super(libName, argString, flags);
  }

  @Override
  public void beforeMakeApplication() {
    Albatross.log("DemoInjector beforeMakeApplication");
  }


  @Override
  public void beforeApplicationCreate(Application application) {
    try {
      Albatross.log("DemoInjector beforeApplicationCreate");
      Albatross.hookClass(ActivityH.class);
    } catch (AlbatrossErr e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void afterApplicationCreate(Application application) {
    Albatross.log("DemoInjector afterApplicationCreate");
  }
}
