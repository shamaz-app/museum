package by.museum.entities;

import by.museum.entities.template.IdEntity;

import javax.persistence.*;

/**
 * Created by shamaz on 06.05.2016.
 */
@Entity
@Table(name = "state")
public class State extends IdEntity{

    @ManyToOne(targetEntity = StateType.class)
    @JoinColumn(name = "ID_STATE_TYPE", nullable = false)
    private StateType stateType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_NEED_RESTORATION")
    private Boolean isNeedRestoration;

    public Boolean getIsNeedRestoration() {
        return isNeedRestoration;
    }

    public void setIsNeedRestoration(Boolean isNeedRestoration) {
        this.isNeedRestoration = isNeedRestoration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }
}
