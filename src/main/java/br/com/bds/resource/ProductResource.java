package br.com.bds.resource;

import br.com.bds.dto.ProductDTO;
import br.com.bds.model.Product;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Date;
import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> findAll(){
        return Product.listAll();
    }

    @POST
    @Transactional
    public void create(ProductDTO productDTO){

        Product p = new Product();
        p.setName(productDTO.getName());
        p.setPrice(productDTO.getPrice());
        //p.setCreateAt(new Date());
        //p.setUpdatedAt(new Date());

        Product.persist(p);
    }
}
