//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/retechretech/dev/workspace/realtime/realtime-channel/src/main/java/com/goodow/realtime/core/Future.java
//
//  Created by retechretech.
//

#include "com/goodow/realtime/core/Future.h"
#include "com/goodow/realtime/core/Handler.h"
#include "java/lang/Throwable.h"


@interface ComGoodowRealtimeCoreFuture : NSObject
@end

@implementation ComGoodowRealtimeCoreFuture

+ (J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { "complete", NULL, "Z", 0x401, NULL },
    { "setFailureWithJavaLangThrowable:", "setFailure", "Lcom.goodow.realtime.core.Future;", 0x401, NULL },
    { "setHandlerWithComGoodowRealtimeCoreHandler:", "setHandler", "Lcom.goodow.realtime.core.Future;", 0x401, NULL },
    { "setResultWithId:", "setResult", "Lcom.goodow.realtime.core.Future;", 0x401, NULL },
  };
  static J2ObjcClassInfo _ComGoodowRealtimeCoreFuture = { "Future", "com.goodow.realtime.core", NULL, 0x201, 4, methods, 0, NULL, 0, NULL};
  return &_ComGoodowRealtimeCoreFuture;
}

@end