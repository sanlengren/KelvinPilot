package com.kelvin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.bean.Media;
import com.kelvin.mapper.MediaMapper;

@Service
public class MediaServiceImpl {
    @Autowired
    private MediaMapper mediamapper;

    public int saveMedia(Media media){
        return mediamapper.saveMedia(media);
    }
    
    public List<Media> queryAll(){
        return mediamapper.queryAll();
    }
}
