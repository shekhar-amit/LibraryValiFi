package com.applib.libraryvalifi.slice;

import com.applib.libraryvalifi.ResourceTable;
import com.applib.valifilib.fields.ValiFieldEmail;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.TextField;
import ohos.agp.window.dialog.ToastDialog;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbilitySlice extends AbilitySlice {

    TextField tf_email;
    Button btn_submit;
    private static final int DOMAIN = 0x00101;
    private static final String TAG = "Databinding";
    protected static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, DOMAIN, TAG);
    public final ValiFieldEmail email = new ValiFieldEmail();

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        tf_email = (TextField) findComponentById(ResourceTable.Id_tf_email);
        btn_submit = (Button) findComponentById(ResourceTable.Id_btn_submit);
        btn_submit.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String val = tf_email.getText();
                email.setValue(val);
                showToast(email.isValid() ? "This field is valid" : "This field is not valid");
            }
        });
    }

    private void showToast(String msg){
        new ToastDialog(this).setDuration(1000).setText(msg).show();
    }

}

