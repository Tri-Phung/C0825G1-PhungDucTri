package com.codegym.validatesonginfo.service;

import com.codegym.validatesonginfo.entity.Song;
import com.codegym.validatesonginfo.repository.SongRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    SongRepository songRepository;
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new NoResultException("Song not found"));
    }

    @Override
    public Song save(Song entity) {
        return songRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        if(songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
