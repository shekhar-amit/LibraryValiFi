package com.applib.libraryvalifi.fields;

import com.applib.valifilib.ValiFi;
import com.applib.valifilib.fields.ValiFieldPassword;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.app.Context;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValiFieldPasswordTest {
    private Context mContext;
    private ValiFieldPassword mField;
    private TextField mTextField;
    private Text mErrorText;
    public static final String PASSWORD_VALID = "abcdefgh";
    public static final String PASSWORD_INVALID = "abcd";
    public static final String FIELD_ERROR_MSG = "field is not valid";

    @Before
    public void prepare() {
        mContext = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        ValiFi.install(mContext);
        mTextField = new TextField(mContext);
        mErrorText = new Text(mContext);
        mField = new ValiFieldPassword(null, FIELD_ERROR_MSG);
        mField.setTextField(mTextField);
        mField.setErrorText(mErrorText);
        mField.init();
    }

    @Test
    public void checkConstructWithValidEmail() {
        mTextField.setText(PASSWORD_VALID);
        assertTrue(mField.isValid());
    }

    @Test
    public void checkConstructWithInvalidEmail() {
        mTextField.setText(PASSWORD_INVALID);
        assertFalse(mField.isValid());
        assertEquals(mErrorText.getText(), FIELD_ERROR_MSG);
    }
}
