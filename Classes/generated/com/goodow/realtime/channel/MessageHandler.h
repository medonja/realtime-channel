//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/retechretech/dev/workspace/realtime/realtime-channel/src/main/java/com/goodow/realtime/channel/MessageHandler.java
//
//  Created by retechretech.
//

#ifndef _GDCMessageHandler_H_
#define _GDCMessageHandler_H_

@protocol GDCMessage;

#import "JreEmulation.h"
#include "com/goodow/realtime/core/Handler.h"

@protocol GDCMessageHandler < ComGoodowRealtimeCoreHandler, NSObject, JavaObject >
- (void)handleWithId:(id<GDCMessage>)message;
@end

#define ComGoodowRealtimeChannelMessageHandler GDCMessageHandler

#endif // _GDCMessageHandler_H_