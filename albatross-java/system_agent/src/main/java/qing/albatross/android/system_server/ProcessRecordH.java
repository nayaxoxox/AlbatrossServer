/*
 * Copyright 2025 QingWan (qingwanmail@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package qing.albatross.android.system_server;

import android.content.pm.ApplicationInfo;

import qing.albatross.annotation.TargetClass;
import qing.albatross.reflection.FieldDef;
import qing.albatross.reflection.IntFieldDef;

@TargetClass(className = "com.android.server.am.ProcessRecord")
public class ProcessRecordH {
  public static FieldDef<Object> hostingRecord;
  public static FieldDef<Object> mHostingRecord;
  public static FieldDef<String> processName;
  public static FieldDef<ApplicationInfo> info;
  public static IntFieldDef uid;
  public static IntFieldDef pid;


}
