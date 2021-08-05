package com.example.demo;

import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor;
import org.springframework.lang.Nullable;

import java.util.Base64;

/**
 * Custom editor for byte arrays. Strings will simply be converted to
 * their corresponding byte representations by encoding them using base 64.
 * Because client will send image data in base64 string.
 */
public class CustomByteArrayPropertyEditor extends ByteArrayPropertyEditor {

    @Override
    public void setAsText(@Nullable String text) {
        setValue(text != null ? Base64.getDecoder().decode(text) : null);
    }

    @Override
    public String getAsText() {
        byte[] value = (byte[]) getValue();
        return (value != null ? Base64.getEncoder().encodeToString(value) : "");
    }

}
