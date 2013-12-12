package com.phonegap.cordova.plugins;


import org.json.JSONArray;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.apache.cordova.api.*;
import org.apache.cordova.*;

public class ImeiPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        String result = "";        
        boolean returnState  = false;
        if (action.equals("get")) {
            
        	TelephonyManager telephonyManager = (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            result = telephonyManager.getDeviceId();

            if (result==null) {
                        callbackContext.error("could not retrieve IMEI");
                  }
            else{
                  callbackContext.success(result);
            }            

            returnState = true;
        }
        else {
            returnState = false;            
        }
        return  returnState;
    } 
}

