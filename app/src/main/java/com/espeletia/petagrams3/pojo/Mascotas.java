package com.espeletia.petagrams3.pojo;

public class Mascotas {
    private String tvNombre, tvLikes;
    private int id,ivFoto,ivLike,ivTLikes,like;

    public Mascotas( int like, String tvNombre, String tvLikes, int ivFoto, int ivLike, int ivTLikes) {
        this.like       = like;
        this.tvNombre   = tvNombre;
        this.tvLikes    = tvLikes;
        this.ivFoto     = ivFoto;
        this.ivLike     = ivLike;
        this.ivTLikes = ivTLikes;
    }

    public Mascotas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(String tvNombre) {
        this.tvNombre = tvNombre;
    }
    public String getTvLikes() {
        return tvLikes;
    }

    public void setTvLikes(String tvLikes) {
        this.tvLikes = tvLikes;
    }

    public int getIvFoto() {
        return ivFoto;
    }

    public void setIvFoto(int ivFoto) {
        this.ivFoto = ivFoto;
    }

    public int getIvLike() {
        return ivLike;
    }

    public void setIvLike(int ivLike) {
        this.ivLike = ivLike;
    }

    public int getIvTLikes() {
        return ivTLikes;
    }

    public void setIvTLikes(int ivTLikes) {
        this.ivTLikes = ivTLikes;
    }
}
