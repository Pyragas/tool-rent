package com.psk.pyragas.ToolRent.usecases;

import com.psk.pyragas.ToolRent.dao.AdvertisementsDAO;
import com.psk.pyragas.ToolRent.dao.ItemsDAO;
import com.psk.pyragas.ToolRent.entities.Advertisement;
import com.psk.pyragas.ToolRent.entities.Item;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AddItem implements Serializable {

    @Inject
    private ItemsDAO itemsDAO;

    @Inject
    private AdvertisementsDAO advertisementsDAO;

    @Getter @Setter
    private Item itemToCreate = new Item();

    @Getter @Setter
    private Advertisement advertisement;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        this.advertisement = advertisementsDAO.findOne(Long.parseLong(requestParameters.get("advertisementId")));
    }

    @Transactional
    public String createItem() {

        itemToCreate.setAdvertisement(this.advertisement);
        itemsDAO.persist(itemToCreate);

        return "add_item.xhtml?faces-redirect=true&advertisementId=" + this.advertisement.getId();
    }


}
