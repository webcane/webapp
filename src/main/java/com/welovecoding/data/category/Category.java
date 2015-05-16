package com.welovecoding.data.category;

import com.welovecoding.data.base.BaseEntity;
import com.welovecoding.data.playlist.Playlist;
import com.welovecoding.data.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends BaseEntity<Long> {

  @NotNull
  @Size(min = 1, max = 7)
  @Basic(optional = false)
  private String color;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
  private Set<Playlist> playlists;

  public Category() {
    this.playlists = new HashSet<>();
    this.color = "#000000";
  }

  public Category(String color) {
    this();
    this.color = color;
  }

  Category(Long id, String name, String slug, Date created, Date lastModified, User creator, User lastEditor, String color, Set<Playlist> playlists) {
    super(id, name, slug, created, lastModified, creator, lastEditor);
    this.color = color;
    this.playlists = playlists;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Set<Playlist> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(Set<Playlist> playlists) {
    this.playlists = playlists;
  }
}
