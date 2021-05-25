package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import com.psk.pyragas.ToolRent.entities.Profile;
import com.psk.pyragas.ToolRent.utils.interceptors.WillBeLogged;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@WillBeLogged
@Model
public class OtherProfile implements Serializable {

    @Inject
    private ProfilesDAO profilesDAO;

    @Getter @Setter
    private Profile profile;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long profileId = Long.parseLong(requestParameters.get("userId"));
        this.profile = profilesDAO.findOne(profileId);
    }

}
