package rso.projects.sales;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "sales")
@NamedQueries(value =
        {
                @NamedQuery(name = "Sale.getAll", query = "SELECT s FROM sales p")
        })
@UuidGenerator(name = "idGenerator")
public class Sale {

        @Id
        @GeneratedValue(generator = "idGenerator")
        private String id;

        @Column(name = "product_id")
        private String productId;

        @Column(name = "old_price")
        private String oldPrice;

        @Column(name = "new_price")
        private String newPrice;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getProductId() {
                return productId;
        }

        public void setProductId(String productId) {
                this.productId = productId;
        }

        public String getOldPrice() {
                return oldPrice;
        }

        public void setOldPrice(String oldPrice) {
                this.oldPrice = oldPrice;
        }

        public String getNewPrice() {
                return newPrice;
        }

        public void setNewPrice(String newPrice) {
                this.newPrice = newPrice;
        }
}
