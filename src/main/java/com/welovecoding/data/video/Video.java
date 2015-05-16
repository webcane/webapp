package com.welovecoding.data.video;

import com.welovecoding.data.base.BaseEntity;
import com.welovecoding.data.playlist.Playlist;
import com.welovecoding.data.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Video extends BaseEntity<Long> {

  @Column(unique = true)
  private String code;

  @Size(min = 0, max = 1024)
  @Column(length = 1024)
  private String description;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
  @NotNull
  private Playlist playlist;

  private String previewImageUrl;

  private String downloadUrl;

  private String permalink;

  public Video() {
  }

  public Video(String code, String name, String description) {
    this.code = code;
    this.setName(name);
    this.setDescription(description);
  }

  Video(Long id, String name, String slug, Date created, Date lastModified, User creator, User lastEditor, String code, String description, Playlist playlist, String previewImageUrl, String downloadUrl, String permalink) {
    super(id, name, slug, created, lastModified, creator, lastEditor);
    this.code = code;
    this.description = description;
    this.playlist = playlist;
    this.previewImageUrl = previewImageUrl;
    this.downloadUrl = downloadUrl;
    this.permalink = permalink;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if (description != null && description.length() > 1024) {
      description = description.substring(0, 1024);
    }

    this.description = description;
  }

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public String getPreviewImageUrl() {
    return previewImageUrl;
  }

  public void setPreviewImageUrl(String previewImageUrl) {
    this.previewImageUrl = previewImageUrl;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public String getPermalink() {
    return permalink;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  @Override
  public String toString() {
    return this.getName();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.code);
    hash = 97 * hash + Objects.hashCode(this.getId());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Video other = (Video) obj;
    if (!Objects.equals(this.code, other.code)) {
      return false;
    }
    if (!super.equals(other)) {
      return false;
    }
    return true;
  }

}