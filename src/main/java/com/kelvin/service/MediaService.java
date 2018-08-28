package com.kelvin.service;

import java.util.List;

import com.kelvin.bean.Media;

public interface MediaService {
    public int saveMedia(Media media);
    public List<Media> queryAll();

}
