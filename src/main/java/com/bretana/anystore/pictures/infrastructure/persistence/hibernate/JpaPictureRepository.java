package com.bretana.anystore.pictures.infrastructure.persistence.hibernate;

import com.bretana.anystore.pictures.domain.Picture;
import com.bretana.anystore.pictures.domain.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

interface JpaRepositoryType extends JpaRepository<JpaPictureEntity, String> {
}

@Component()
public class JpaPictureRepository implements PictureRepository {

    private final JpaRepositoryType jpaPictureRepository;

    @Autowired
    public JpaPictureRepository(JpaRepositoryType jpaPictureRepository) {
        this.jpaPictureRepository = jpaPictureRepository;
    }

    @Override
    public List<Picture> findAll() {
        var pictures = this.jpaPictureRepository.findAll();
        return pictures.stream()
                .map(p -> new Picture(
                        UUID.fromString(p.getId()),
                        p.getTitle(),
                        p.getDescription(),
                        p.getCreationDate())
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Picture> findById(UUID id) {
        var picture = this.jpaPictureRepository.findById(id.toString());

        if (picture.isEmpty()) {
            return Optional.empty();
        }

        var p = picture.get();

        return Optional.of(new Picture(
                UUID.fromString(p.getId()),
                p.getTitle(),
                p.getDescription(),
                p.getCreationDate()
        ));
    }

    @Override
    public void create(Picture picture) {
        var pic = new JpaPictureEntity();
        pic.setId(picture.getId().toString());
        pic.setTitle(picture.getTitle());
        pic.setDescription(picture.getDescription());
        pic.setCreationDate(picture.getCreationDate());

        this.jpaPictureRepository.saveAndFlush(pic);
    }
}
