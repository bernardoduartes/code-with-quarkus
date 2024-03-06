package br.com.bds.resource;

import br.com.bds.dto.ProductDTO;
import br.com.bds.model.Product;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        Product.persist(p);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id, ProductDTO productDTO){
        Optional<Product> p = Product.findByIdOptional(id);

        if(p.isPresent()) {
            p.get().setName(productDTO.getName());
            p.get().setPrice(productDTO.getPrice());
            Product.persist(p.get());
        }else{
            throw new NotFoundException("Product not foud!");
        }
    }
}
