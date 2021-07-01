package com.applib.libraryvalifi;

import com.applib.valifilib.ValiFi;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {
        super.onInitialize();
        ValiFi.install();
    }
}
