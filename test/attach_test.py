import sys
import time

import albatross
from albatross.common import Configuration


def main(device_id=None):
  device = albatross.get_device(device_id)
  assert device.is_root
  device.wake_up()
  user_pkgs = device.get_user_packages()
  inject_dex = Configuration.resource_dir + "plugins/injector_demo.apk"
  inject_class = "qing/albatross/app/agent/DemoInjector"
  for pkg in user_pkgs:
    if 'albatross' in pkg and 'inject_demo' not in pkg:
      continue
    print('try test', pkg)
    device.stop_app(pkg)
    device.start_app(pkg)
    time.sleep(5)
    device.attach(pkg, inject_dex, None, inject_class)
    device.home()
    for i in range(3):
      device.switch_app()
      time.sleep(1)
      device.switch_app()
  print('finish test')
  sys.stdin.read()


if __name__ == '__main__':
  main()
