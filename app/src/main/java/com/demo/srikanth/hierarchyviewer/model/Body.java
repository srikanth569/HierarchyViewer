package com.demo.srikanth.hierarchyviewer.model;

public class Body {

    private String element;
    private String type;
    private String text;
    private String uRL;
    private String key;

    /**
     * @return The element
     */
    public String getElement() {
        return element;
    }

    /**
     * @param element The element
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The uRL
     */
    public String getURL() {
        return uRL;
    }

    /**
     * @param uRL The URL
     */
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    /**
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Body{" +
                "element='" + element + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", uRL='" + uRL + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}