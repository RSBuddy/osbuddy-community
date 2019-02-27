package com.rsbuddy.osrs.event;

import com.rsbuddy.osrs.content.config.Skill;

public class SkillUpdated {
    private final Skill skill;
    private final int oldExperience;
    private final int newExperience;

    public SkillUpdated(Skill skill, int oldExperience, int newExperience) {
        this.skill = skill;
        this.oldExperience = oldExperience;
        this.newExperience = newExperience;
    }

    public Skill skill() {
        return skill;
    }

    public int oldExperience() {
        return oldExperience;
    }

    public int newExperience() {
        return newExperience;
    }

    @Override
    public String toString() {
        return "SkillUpdated{" +
                "skill=" + skill +
                ", oldExperience=" + oldExperience +
                ", newExperience=" + newExperience +
                '}';
    }
}
