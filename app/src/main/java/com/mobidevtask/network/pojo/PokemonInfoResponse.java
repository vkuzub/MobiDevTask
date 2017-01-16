package com.mobidevtask.network.pojo;

import com.mobidevtask.ui.base.fullinfo.BaseFullInfoResponse;

import java.util.List;

public class PokemonInfoResponse extends BaseFullInfoResponse{

    private long weight;
    private Sprite sprites;
    private List<Object> abilities;

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Object> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Object> abilities) {
        this.abilities = abilities;
    }
}
