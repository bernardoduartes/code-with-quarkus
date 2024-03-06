package br.com.bds;

import br.com.bds.model.Product;
import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@DBRider
@QuarkusTest
@QuarkusTestResource(DataBaseLifecycle.class)
class ProductTest {

    @Test
    @DataSet("products.yml")
    void has_product() {
        long count = Product.count();
        Assert.assertEquals(0, Product.count());
    }
}