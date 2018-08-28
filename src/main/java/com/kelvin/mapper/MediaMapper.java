package com.kelvin.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kelvin.bean.Media;

@Repository
public interface MediaMapper {
    public int saveMedia(Media media);
    public List<Media> queryAll();
}
