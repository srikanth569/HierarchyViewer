package com.demo.srikanth.hierarchyviewer.model;

/**
 * Created by shrek on 5/26/16.
 */

public class Child {

    public String element;
    public String type;
    public String text;
    public String URL;
    public String bitrate;
    public String reliability;
    public String guide_id;
    public String subtext;
    public String genre_id;
    public String formats;
    public String item;
    public String image;
    public String now_playing_id;
    public String preset_id;
    public String show_id;
    public String current_track;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public String getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(String guide_id) {
        this.guide_id = guide_id;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    public String getFormats() {
        return formats;
    }

    public void setFormats(String formats) {
        this.formats = formats;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNow_playing_id() {
        return now_playing_id;
    }

    public void setNow_playing_id(String now_playing_id) {
        this.now_playing_id = now_playing_id;
    }

    public String getPreset_id() {
        return preset_id;
    }

    public void setPreset_id(String preset_id) {
        this.preset_id = preset_id;
    }

    public String getShow_id() {
        return show_id;
    }

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public String getCurrent_track() {
        return current_track;
    }

    public void setCurrent_track(String current_track) {
        this.current_track = current_track;
    }

    @Override
    public String toString() {
        return "Child{" +
                "element='" + element + '\'' +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", URL='" + URL + '\'' +
                ", bitrate='" + bitrate + '\'' +
                ", reliability='" + reliability + '\'' +
                ", guide_id='" + guide_id + '\'' +
                ", subtext='" + subtext + '\'' +
                ", genre_id='" + genre_id + '\'' +
                ", formats='" + formats + '\'' +
                ", item='" + item + '\'' +
                ", image='" + image + '\'' +
                ", now_playing_id='" + now_playing_id + '\'' +
                ", preset_id='" + preset_id + '\'' +
                ", show_id='" + show_id + '\'' +
                ", current_track='" + current_track + '\'' +
                '}';
    }
}