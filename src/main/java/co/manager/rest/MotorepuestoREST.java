package co.manager.rest;

import co.manager.dto.BusinessPartnerDTO;
import co.manager.dto.ItemMotorepuestoDTO;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.BusinessPartnerEJB;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("motorepuesto")
public class MotorepuestoREST {
    private static final Logger CONSOLE = Logger.getLogger(MotorepuestoREST.class.getSimpleName());

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;

    @GET
    @Path("items")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listItemMaster() {
        CONSOLE.log(Level.INFO, "Iniciando servicio item master de motorepuesto.");
        List<Object[]> objects = itemSAPFacade.listItemMasterMotorepuesto();

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el item master de motorepuesto.");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el items master de motorepuesto.")).build();
        }

        List<ItemMotorepuestoDTO> items = new ArrayList<>();
        for (Object[] obj : objects) {
            ItemMotorepuestoDTO dto = new ItemMotorepuestoDTO();
            dto.setItemCode((String) obj[0]);
            //dto.setItemName((String) obj[1]);
            dto.setPresentation((Integer) obj[1]);
            dto.setIva((Integer) obj[2]);
            dto.setWhsCode((String) obj[3]);
            dto.setStock((Integer) obj[4]);
            dto.setPictureUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/motorepuesto/" + obj[5]);
            dto.setPictureMarcaUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/motorepuesto/" + obj[7] + ".jpg");
            dto.setCategory((String) obj[6]);
            dto.setMarca((String) obj[7]);
            dto.setSubMarca((String) obj[8]);
            dto.setGrupo((String) obj[9]);
            dto.setSubgrupo((String) obj[10]);
            //dto.setLinea((String) obj[12]);
            //dto.setSublinea((String) obj[13]);
            dto.setModeloMoto((String) obj[11]);
            dto.setTipoLlanta((String) obj[12]);
            dto.setAnchoLlanta((String) obj[13]);
            dto.setPerfilLlanta((String) obj[14]);
            dto.setRinLlanta((String) obj[15]);
            dto.setTalla((String) obj[16]);
            dto.setColorCadena((String) obj[17]);
            dto.setPasoCadena((String) obj[18]);
            dto.setViscosidad((String) obj[19]);
            dto.setBase((String) obj[20]);
            dto.setItemParent((String) obj[21]);
            dto.setItemType((String) obj[22]);
            dto.setKeyword((String) obj[23]);
            dto.setNomWeb((String) obj[24]);
            dto.setPriceVenta((BigDecimal) obj[25]);
            dto.setPricePromo((BigDecimal) obj[26]);
            items.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el item master de motorepuesto.");
        return Response.ok(new ResponseDTO(0, items)).build();
    }

    @POST
    @Path("create-customer")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(BusinessPartnerDTO dto) {
        dto.setLicTradNum(dto.getCardCode().replace("C", ""));
        return Response.ok(businessPartnerEJB.createBusinessPartner(dto)).build();
    }


    @POST
    @Path("create-payments")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createIncomingPayments(BusinessPartnerDTO dto) {
        dto.setLicTradNum(dto.getCardCode().replace("C", ""));
        return Response.ok(businessPartnerEJB.createBusinessPartner(dto)).build();
    }


}