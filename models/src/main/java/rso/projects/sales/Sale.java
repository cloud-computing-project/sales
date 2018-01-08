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
}
