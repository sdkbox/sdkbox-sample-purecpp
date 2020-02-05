#include <jni.h>
#include <string>

#include "sdkbox/Sdkbox.h"
#include "PluginAdMob/PluginAdMob.h"

namespace cocos2d {
    const char* cocos2dVersion()
    {
        return "cocos2d-x-3.17";
    }
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_sdkbox_sdkboxcpp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    auto str = R"(
                    {
                        "android": {
                            "AdMob": {
                                "testdevice": "FE20924C46522E2E204587EB339897C6,kGADSimulatorID",
                                "test": false,
                                "ads": {
                                    "rewarded": {
                                        "type": "rewarded_video",
                                        "id": "ca-app-pub-1329374026572143/8251968111"
                                    }
                                },
                                "appid": "ca-app-pub-1329374026572143~7139010117"
                            }
                        },
                        "ios": {
                            "AdMob": {
                                "testdevice": "kGADSimulatorID",
                                "test": false,
                                "safearea": true,
                                "ads": {
                                },
                                "appid": "ca-app-pub-1329374026572143~2708810518"
                            }
                        }
                    }
                 )";
    sdkbox::setConfig(str);
    sdkbox::PluginAdMob::init();

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
