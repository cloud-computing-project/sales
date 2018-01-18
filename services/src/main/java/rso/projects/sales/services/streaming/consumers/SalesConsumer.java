package rso.projects.sales.services.streaming.consumers;

import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.streaming.common.annotations.StreamListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONObject;
import javax.inject.Inject;
import rso.projects.sales.services.SalesBean;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
public class SalesConsumer {

    private Logger log = LogManager.getLogger(SalesConsumer.class.getName());

    @Inject
    private SalesBean salesBean;

    @StreamListener(topics = {"xtmm0ew0-default"})
    public void onMessage(ConsumerRecord<String, String> record) {

        log.info(String.format("Consumed message: offset = %d, key = %s, value = %s%n", record.offset(), record.key()
                , record.value()));

        JSONObject message = new JSONObject(record.value());

        String id = message.getString("id");
        String status = message.getString("status");


        log.info("Status for order " + id + " set to " + status);

        salesBean.setSaleStatus(id,status);

    }
}
