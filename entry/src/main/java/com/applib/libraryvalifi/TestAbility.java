package com.applib.libraryvalifi;

import com.applib.libraryvalifi.slice.TestAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * Test Ability of sample app.
 */
public class TestAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(TestAbilitySlice.class.getName());
    }
}
