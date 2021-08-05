package com.example.demo;

import java.util.Arrays;

class BinaryData {

    private byte[] image;
    private String imageContentType;

    public byte[] getImage() {
        return image;
    }

    public BinaryData setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public BinaryData setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    @Override
    public String toString() {
        return "BinaryData{" +
                "image=" + Arrays.toString(image) +
                ", imageContentType='" + imageContentType + '\'' +
                '}';
    }
}
