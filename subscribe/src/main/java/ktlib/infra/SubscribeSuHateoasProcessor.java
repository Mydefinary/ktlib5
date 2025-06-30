package ktlib.infra;

import ktlib.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SubscribeSuHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SubscribeSu>> {

    @Override
    public EntityModel<SubscribeSu> process(EntityModel<SubscribeSu> model) {
        return model;
    }
}
